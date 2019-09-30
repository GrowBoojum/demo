package com.example.demo;

import com.github.mongobee.Mongobee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MigartionConfig {
    @Bean
    public Mongobee mongobee(){
        Mongobee runner = new Mongobee("mongodb://localhost:27017/vehicle");
        runner.setDbName("vehicle");         // host must be set if not set in URI
        runner.setChangeLogsScanPackage(
                "com.javagraphql.migrations"); // the package to be scanned for changesets

        return runner;
    }
}