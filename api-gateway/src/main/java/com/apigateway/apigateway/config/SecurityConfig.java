package com.apigateway.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.ldap.EmbeddedLdapServerContextSourceFactoryBean;
import org.springframework.security.config.ldap.LdapBindAuthenticationManagerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@EnableWebSecurity
public class SecurityConfig {

    private final JwtAthFilter jwtAthFilter;
    private final UserDetailsService userDetailsService;
    private final AuthenticationProvider authenticationProvider;
    public SecurityConfig(JwtAthFilter jwtAthFilter, UserDetailsService userDetailsService, AuthenticationProvider authenticationProvider) {
        this.jwtAthFilter = jwtAthFilter;
        this.userDetailsService = userDetailsService;
        this.authenticationProvider = authenticationProvider;
    }


    private final static List<UserDetails> USERS_DETAILS_LIST = Arrays.asList(
            new User("user@email.com", "password", Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))),
            new User("admin@email.com", "password", Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")))
    );

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((requests) -> {
            (requests.anyRequest()).authenticated();
        });
        // tell spring about new filter jwt ->

        http
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                );
        http.authenticationProvider(authenticationProvider);
        http.addFilterBefore(jwtAthFilter, UsernamePasswordAuthenticationFilter.class);

        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }

    //bean methods have to be public
    @Bean
    public AuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                return USERS_DETAILS_LIST.stream()
                        .filter(userDetails -> userDetails.getUsername().equals(email))
                        .findFirst()
                        .orElseThrow(() -> new UsernameNotFoundException("Email not found!"));
            }
        };
    }
    @Bean
    private PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
       // return new BCryptPasswordEncoder();
    }


    //TODO ?? the fuck
    /*@Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("user")
                .password("{bcrypt}$1234")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}$1234")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }*/
}
