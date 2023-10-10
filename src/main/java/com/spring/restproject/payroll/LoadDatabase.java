package com.spring.restproject.payroll;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class LoadDatabase {


    private static final Logger log = (Logger) LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            log.info("Preloading" + repository.save(new Employee("Bilbo Baggins", "bulgar")));
            log.info(("Preloading" + repository.save(new Employee("Frodo Baggins", "thief"))));
        };
    }


}
