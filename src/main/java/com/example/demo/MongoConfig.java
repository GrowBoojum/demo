package com.example.demo;

import com.github.mongobee.Mongobee;
import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories
@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:application.yml")
public class MongoConfig {

    @Autowired
    private Environment env;

    @Bean
    public MongoClient mongo()  {
        ServerAddress serverAddress = new ServerAddress(
                env.getProperty("spring.data.mongodb.host"),
                Integer.parseInt(env.getProperty("spring.data.mongodb.port")));
        return new MongoClient(serverAddress);
    }

    @Bean
    public MongoDbFactory mongoDbFactory()  {
        return new SimpleMongoDbFactory(mongo(), env.getProperty("spring.data.mongodb.database"));
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }

    @Bean
    public Mongobee mongobee(){
        Mongobee runner = new Mongobee(env.getProperty("spring.data.mongodb.uri"));
        runner.setDbName(env.getProperty("spring.data.mongodb.database"));
        runner.setChangeLogsScanPackage(
                "com.javagraphql.migrations"); // the package to be scanned for changesets

        return runner;
    }
}