package com.spkafproject2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProducer implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProducer.class);
    }

    @Autowired
    private TopicProducer topicProducer;

    @Override
    public void run(String... args) throws Exception {

    }
}