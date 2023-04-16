package com.example.MusicDatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MusicDatabaseApplication {
    private static final Logger log = LoggerFactory.getLogger(MusicDatabaseApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MusicDatabaseApplication.class, args);
    }

    @Bean
    public CommandLineRunner songDemo(GenreRepository grepository, SongRepository srepository, AppUserRepository urepository) {
        return (args) -> {
            grepository.save(new Genre("Rock"));
            grepository.save(new Genre("Pop"));
            grepository.save(new Genre("Electronic"));
            grepository.save(new Genre("Darkwave"));
            grepository.save(new Genre("Experimental"));



            srepository.save(new Song("Ache", "FKA twigs", 2012, grepository.findByName("Electronic").get(0)));
            srepository.save(new Song("A Forest", "The Cure", 1980, grepository.findByName("Rock").get(0)));
            srepository.save(new Song("Shake Well Before Use", "YSI", 2020, grepository.findByName("Experimental").get(0)));
            srepository.save(new Song("Ache", "FKA twigs", 2012, grepository.findByName("Electronic").get(0)));


            // Create users: admin/admin user/user
            AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
            AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
            urepository.save(user1);
            urepository.save(user2);

            log.info("fetch all songs");
            for (Song song : srepository.findAll()) {
                log.info(song.toString());
            }

        };
    }
}
