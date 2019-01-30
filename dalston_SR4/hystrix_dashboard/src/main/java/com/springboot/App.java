package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
/**
 * 仪表盘
 * @author liyuan
 */
@SpringBootApplication
@EnableHystrixDashboard
public class App {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
