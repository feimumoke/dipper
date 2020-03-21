package com.dipper.merak;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = "com.dipper.proto.entity")
public class MerakServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MerakServiceApplication.class,args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
