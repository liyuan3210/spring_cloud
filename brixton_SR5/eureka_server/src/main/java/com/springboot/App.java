package com.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * 服务注册中心
 * @author liyuan
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class App {
    public static void main(String[] args) throws Exception {
    		new SpringApplicationBuilder(App.class).web(true).run(args);
    }
}
