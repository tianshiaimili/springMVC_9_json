package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorld {
	@RequestMapping(value="/hellow",method=RequestMethod.GET)
	public ModelAndView helloworld(){
		
		String message="Hello Wrold Spring 3.0!------------";
		/**
		 * 这里的第一个参数 对应的是跳转的jsp 的页面的名称
		 * message1 则是相当于Message的标记 ，在jsp页面中 通过 ${message1} 引用
		 */
		return new ModelAndView("hellow","message1",message);
	}
}
