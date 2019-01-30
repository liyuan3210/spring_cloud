package com.springboot;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class App {
	
    @RequestMapping("/")
//    @ResponseBody
    String home() {
    	System.out.println("####index.jsp	"+new Date());
        return "index";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
