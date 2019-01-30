package com.springboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
/**
 * @author liyuan
 * 
 * http://localhost:5555/api-a/hello ： 返回401
 * http://localhost:5555/api-a/hello&accessToken=toke : 正确路由到hello-service
 *
 */
@EnableZuulProxy
@SpringCloudApplication
public class App {
    public static void main(String[] args) {
        new SpringApplicationBuilder(App.class).web(true).run(args);
    }
    @Bean
    public AccessFilter accessFilter(){
    	return new AccessFilter();
    }
}
