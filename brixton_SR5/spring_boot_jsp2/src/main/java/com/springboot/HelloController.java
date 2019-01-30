package com.springboot;

import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
/**
 * 服务提供者2
 * @author liyuan
 *
 */
@RestController
@RequestMapping(value = "/action")
public class HelloController {
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView index(){
		System.out.println("###index: "+ new Date());
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	@RequestMapping(value="/menu1",method=RequestMethod.GET)
	public ModelAndView menu1(){
		ModelAndView mv = new ModelAndView("menu1");
		System.out.println("###menu1: "+ new Date());
		return mv;
	}
	@RequestMapping(value="/menu2",method=RequestMethod.GET)
	public ModelAndView menu2(){
		ModelAndView mv = new ModelAndView("module/menu2");
		System.out.println("###menu2: "+ new Date());
		return mv;
	}
	
}
