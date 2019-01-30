package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="helloFallback")
	public String helloService(){
		return restTemplate.getForEntity("http://HELLO-SERVICE/hello",
				String.class).getBody();
	}
	
	@HystrixCommand(fallbackMethod="helloFallback2")
	public String helloService2(){
		return restTemplate.getForEntity("http://HELLO-SERVICE/hello_out",
				String.class).getBody();
	}
	public String helloFallback(){
		return "error";
	}
	public String helloFallback2(){
		return "time out";
	}
}
