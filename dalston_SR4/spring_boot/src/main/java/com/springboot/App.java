package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
/**
 * 
 * @author liyuan
properties文件
environments.dev.url=http://dev.bar.com
environments.dev.name=Developer Setup
environments.prod.url=http://foo.bar.com
environments.prod.name=My cool App 
类似YAML
environments:
   dev:
      url:http://dev.bar.com
      name:Developer Setup
   prod:
      url:http://foo.bar.com
      name:My cool App 
      
 YAML文件注意(YAML是按照类似大纲缩进形式表示)：
 1.空格单位来缩进
 2.每个值":"后面都要跟一个空格
 */
@EnableAutoConfiguration
@ComponentScan(basePackages={"com"})
public class App {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
