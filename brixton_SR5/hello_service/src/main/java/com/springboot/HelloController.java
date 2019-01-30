package com.springboot;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * 服务提供者
 * @author liyuan
 *
 */
@RestController
public class HelloController {
	
	private final Logger logger=Logger.getLogger(getClass());
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello(){
		ServiceInstance instance=client.getLocalServiceInstance();
		System.out.println("/hello,host:"+instance.getHost()+",service_id:"+instance.getServiceId()+",Date:"+new Date()+",port:"+instance.getPort());
		logger.info("/hello,host:"+instance.getHost()+",service_id:"+instance.getServiceId());
		return "Hello World";
	}
	/**
	 * Hystrix容错超过2000毫秒触发熔断
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/hello_out",method=RequestMethod.GET)
	public String hello2() throws Exception{
		ServiceInstance instance=client.getLocalServiceInstance();
		
		int sleepTime=new Random().nextInt(3000);
		logger.info("sleepTime:"+sleepTime);
		System.out.println("sleepTime:"+sleepTime);
		Thread.sleep(sleepTime);
		
		System.out.println("/hello2,host:"+instance.getHost()+",service_id:"+instance.getServiceId()+",Date:"+new Date()+",port:"+instance.getPort());
		logger.info("/hello2,host:"+instance.getHost()+",service_id:"+instance.getServiceId());
		return "Hello World2";
	}
	
	@RequestMapping(value="/user_get",method=RequestMethod.GET)
	public String user_get(HttpServletResponse response, HttpServletRequest request){
		System.out.println("##########user_get##########");
		String urlData=request.getParameter("data");
		String httpParam=Util.httpProcess(request);
		System.out.println("urlData:"+urlData);
		System.out.println("httpParam:"+httpParam);
		System.out.println("name:"+request.getParameter("name"));
		System.out.println("age:"+request.getParameter("age"));
		System.out.println("date:"+request.getParameter("date"));
		return "user_get success";
	}
	
	@RequestMapping(value="/user2_get",method=RequestMethod.GET)
	public User user2_get(HttpServletResponse response, HttpServletRequest request){
		System.out.println("##########user2_get##########");
		String urlData=request.getParameter("data");
		String httpParam=Util.httpProcess(request);
		System.out.println("urlData:"+urlData);
		System.out.println("httpParam:"+httpParam);
		System.out.println("name:"+request.getParameter("name"));
		System.out.println("age:"+request.getParameter("age"));
		System.out.println("date:"+request.getParameter("date"));
		User user2=new User("zhangsan",21,new Date());
		return user2;
	}
	
	
	@RequestMapping(value="/user_post",method=RequestMethod.POST)
	public String user_post(HttpServletResponse response, HttpServletRequest request){
		System.out.println("##########user_post##########");
		String urlData=request.getParameter("data");
		String httpParam=Util.httpProcess(request);
		System.out.println("urlData:"+urlData);
		System.out.println("httpParam:"+httpParam);
		System.out.println("name:"+request.getParameter("name"));
		System.out.println("age:"+request.getParameter("age"));
		System.out.println("date:"+request.getParameter("date"));
		return "user_post success";
	}
	
	@RequestMapping(value="/user2_post",method=RequestMethod.POST)
	public User user2_post(HttpServletResponse response, HttpServletRequest request){
		System.out.println("##########user2_post##########");
		String urlData=request.getParameter("data");
		String httpParam=Util.httpProcess(request);
		System.out.println("urlData:"+urlData);
		System.out.println("httpParam:"+httpParam);
		System.out.println("name:"+request.getParameter("name"));
		System.out.println("age:"+request.getParameter("age"));
		System.out.println("date:"+request.getParameter("date"));
		User user2=new User("zhangsan",21,new Date());
		return user2;
	}
	
	@RequestMapping(value="/user_put",method=RequestMethod.PUT)
	public User user_put(HttpServletResponse response, HttpServletRequest request){
		System.out.println("##########user_put##########");
		String urlData=request.getParameter("data");
		String httpParam=Util.httpProcess(request);
		System.out.println("urlData:"+urlData);
		System.out.println("httpParam:"+httpParam);
		System.out.println("name:"+request.getParameter("name"));
		System.out.println("age:"+request.getParameter("age"));
		System.out.println("date:"+request.getParameter("date"));
		User user2=new User("zhangsan",21,new Date());
		return user2;
	}
	
	@RequestMapping(value="/user_delete",method=RequestMethod.DELETE)
	public User user_delete(HttpServletResponse response, HttpServletRequest request){
		System.out.println("##########user_delete##########");
		String urlData=request.getParameter("data");
		String httpParam=Util.httpProcess(request);
		System.out.println("urlData:"+urlData);
		System.out.println("httpParam:"+httpParam);
		System.out.println("name:"+request.getParameter("name"));
		System.out.println("age:"+request.getParameter("age"));
		System.out.println("date:"+request.getParameter("date"));
		User user2=new User("zhangsan",21,new Date());
		return user2;
	}

}
