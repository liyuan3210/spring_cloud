package com.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class App {
    public static void main(String[] args) throws Exception {
    	new SpringApplicationBuilder(App.class).web(true).run(args);
    }
}
