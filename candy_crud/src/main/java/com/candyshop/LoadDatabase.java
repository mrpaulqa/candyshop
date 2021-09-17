package com.candyshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.candyshop.CandyRepository;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(CandyRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Candy( "burglar")));
            log.info("Preloading " + repository.save(new Candy("thief")));
        };
    }
}
