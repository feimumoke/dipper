package com.dipper.phecda;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


/**
 * 天玑
 * Web前台页面
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PhecdaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhecdaServiceApplication.class, args);
    }

}
