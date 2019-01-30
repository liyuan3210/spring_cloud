package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class App {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
