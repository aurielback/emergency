package com.health.hospitalservice;

import com.health.hospitalservice.model.Hospital;
import com.health.hospitalservice.repository.HospitalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class HospitalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(HospitalRepository hospitalRepository) {
        return args -> {
            Hospital hospital1 = new Hospital();
            hospital1.setName("Szpital na Borowskiej");
            hospital1.setCurrentPatients(100);
            hospital1.setTotalCapacity(101);

            Hospital hospital2 = new Hospital();
            hospital2.setName("Szpital na Krakowskiej");
            hospital2.setCurrentPatients(100);
            hospital2.setTotalCapacity(100);

            Hospital hospital3 = new Hospital();
            hospital3.setName("Szpital na Dupie U Maryni");
            hospital3.setCurrentPatients(100);
            hospital3.setTotalCapacity(200);

            hospitalRepository.saveAll(List.of(hospital1, hospital2, hospital3));
        };
    }
}
