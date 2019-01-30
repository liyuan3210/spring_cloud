package com.springboot;

import java.io.IOException;
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
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public void test(HttpServletResponse response,HttpServletRequest request) throws IOException{
		ServiceInstance instance=client.getLocalServiceInstance();
		System.out.println("/test,host:"+instance.getHost()+",service_id:"+instance.getServiceId()+",Date:"+new Date()+",port:"+instance.getPort());
		logger.info("/test,host:"+instance.getHost()+",service_id:"+instance.getServiceId());
		response.sendRedirect("http://127.0.0.1:5555/page/sysName/action/index");
	}
	

}
