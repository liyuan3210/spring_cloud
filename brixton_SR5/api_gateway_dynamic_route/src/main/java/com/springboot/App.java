package com.springboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
/**
 * @author liyuan
api-gateway.properties(放到git仓库里面)
zuul.routes.service-a.path=/service-a/**
zuul.routes.service-a.serviceId=hello-service
zuul.routes.service-b.path=/service-b/**
zuul.routes.service-b.url=http://localhost:8081/
 */
@EnableZuulProxy
@SpringCloudApplication
public class App {
    public static void main(String[] args) {
        new SpringApplicationBuilder(App.class).web(true).run(args);
    }
    
    @RefreshScope
    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties(){
    	return new ZuulProperties();
    }
}
