package com.example.securityservice.monitor;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DatabaseService implements HealthIndicator {

    private final String DATABASE_SERVICE = "Database Service";
    private final JdbcTemplate jdbcTemplate;

    public DatabaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Health health() {
        Map<String, String> pairs = new HashMap<>();
        pairs.put("Database Service 1", "Service is running");
        pairs.put("Database Service 2", "Just for check");

        if(isDatabaseHealthGood()) {
            return Health.up().withDetails(pairs).build();
        }
        return Health.down().withDetail(DATABASE_SERVICE, "Service is not available").build();
    }

    private boolean isDatabaseHealthGood() {
        try {
            Integer numberOfRows = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM t_user", Integer.class);
            return numberOfRows != null && numberOfRows > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
