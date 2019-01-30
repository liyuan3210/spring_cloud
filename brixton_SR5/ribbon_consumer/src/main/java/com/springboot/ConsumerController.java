package com.springboot;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
/**
 * 服务消费者
 * @author liyuan
 * 
 *http://127.0.0.1:9000/ribbon-consumer
 *
 *http://127.0.0.1:9000/user_get
 *http://127.0.0.1:9000/user_post
 *http://127.0.0.1:9000/user_put
 *http://127.0.0.1:9000/user_delete
 */
@RestController
public class ConsumerController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HelloService helloService;

	@RequestMapping(value="/ribbon-consumer",method=RequestMethod.GET)
	public String helloConsumer(){
		return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
	}
	/**
	 * Hystrix
	 * 连接断开
	 * @return
	 */
	@RequestMapping(value="/ribbon-consumer0",method=RequestMethod.GET)
	public String helloConsumer0(){
		return helloService.helloService();
	}
	/**
	 * Hystrix
	 * 超时
	 * @return
	 */
	@RequestMapping(value="/ribbon-consumer2",method=RequestMethod.GET)
	public String helloConsumer2(){
		return helloService.helloService2();
	}
	
	/**
	 * get 基本调用
	 * @return
	 */
	@RequestMapping(value="/user_get",method=RequestMethod.GET)
	public String user_get(){
		System.out.println("user_get:"+new Date());
		//方法1.基本传参数{x}索引,对应参数放getForEntity方法后面
//		ResponseEntity<String> responseEntity=restTemplate.getForEntity("http://HELLO-SERVICE/user_get?name={1}&age={2}", String.class,"lisi",89);
		
		//map传参,可以传中文
//		Map<String,String> params=new HashMap<String,String>();
//		params.put("name","王五");
//		params.put("age","77");
//		ResponseEntity<String> responseEntity=restTemplate.getForEntity("http://HELLO-SERVICE/user_get?name={name}&age={age}", String.class,params);
		
		//URI,getForEntity,getForObject字符串返回,getForObject对象返回
		UriComponents uriComponents=UriComponentsBuilder.fromUriString("http://HELLO-SERVICE/user_get?name={name}")
				.build().expand("zhangsan").encode();
		URI uri=uriComponents.toUri();
		ResponseEntity<String> responseEntity=restTemplate.getForEntity(uri,String.class);
		//方法2
//		String result=restTemplate.getForObject(uri,String.class);
//		User result2=restTemplate.getForObject(uri,User.class);
		
		String body=responseEntity.getBody();
		System.out.println("###body:"+body);
		return body;
	}
	/**
	 * 支持三种不同重载方法
	 * (String url,class responseType,Object... urlVariables)
	 * (String url,class responseType,Map urlVariables)
	 * (URL url,class responseType)
	 * @return
	 */
	@RequestMapping(value="/user_post",method=RequestMethod.GET)
	public String user_post(){
		System.out.println("user_post:"+new Date());
		User user=new User("lisi",29,new Date());
		//基本post表单提交,传表单参数user对象,可以url直接指定参数
		ResponseEntity<String> responseEntity=restTemplate.postForEntity("http://HELLO-SERVICE/user_post?name={1}&age=100",user,String.class,"lisi");
		String body=responseEntity.getBody();
		
		//postForObject
//		String result=restTemplate.postForObject("http://HELLO-SERVICE/user_post", user,String.class);
//		String body=result;
		
		//postForLocation,返回新资源的URI所以不需要指定responseType
//		URI responseURI=restTemplate.postForLocation("http://HELLO-SERVICE/user_post", user);
		
		return body;
	}
	/**
	 * 支持三种不同重载方法
	 * (String url,class responseType,Object... urlVariables)
	 * (String url,class responseType,Map urlVariables)
	 * (URL url,class responseType)
	 * @return
	 */
	@RequestMapping(value="/user_put",method=RequestMethod.GET)
	public String user_put(){
		System.out.println("user_put:"+new Date());
		Long id=10001L;
		User user=new User("lisi",29,new Date());
		//book:restTemplate.put("http://HELLO-SERVICE/user_put/{1}", user,id);
		restTemplate.put("http://HELLO-SERVICE/user_put", user,id);
		return "put success";
	}
	/**
	 * 支持三种不同重载方法
	 * (String url,class responseType,Object... urlVariables)
	 * (String url,class responseType,Map urlVariables)
	 * (URL url,class responseType)
	 * @return
	 */
	@RequestMapping(value="/user_delete",method=RequestMethod.GET)
	public String user_delete(){
		System.out.println("user_delete:"+new Date());
		Long id=10001L;
		//book:restTemplate.delete("http://HELLO-SERVICE/user_delete/{1}",id);
		restTemplate.delete("http://HELLO-SERVICE/user_delete",id);
		return "delete success";
	}
	
	/**
	 * body返回 User对象
	 * 对象没验证成功
	 * @return
	 */
	@RequestMapping(value="/user2_get",method=RequestMethod.GET)
	public User user2_get(){
		System.out.println("user2_get:"+new Date());
		ResponseEntity<User> responseEntity=restTemplate.getForEntity("http://HELLO-SERVICE/user2_get?name={1}", User.class,"lisi");
		User body=responseEntity.getBody();
		System.out.println("###name:"+body.getName());
		System.out.println("###age:"+body.getAge());
		System.out.println("###date:"+body.getDate());
		return body;
	}
}

