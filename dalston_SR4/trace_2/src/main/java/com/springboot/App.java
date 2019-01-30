package com.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class App {
	private final Logger logger=LoggerFactory.getLogger(App.class);
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@RequestMapping(value="/trace-2",method=RequestMethod.GET)
    public String trace() {
		logger.info("===call trace-2===");
		System.out.println("===call trace-2===");
        return "Trace";
    }
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
