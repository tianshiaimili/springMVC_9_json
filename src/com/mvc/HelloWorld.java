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
		 * ����ĵ�һ������ ��Ӧ������ת��jsp ��ҳ�������
		 * message1 �����൱��Message�ı�� ����jspҳ���� ͨ�� ${message1} ����
		 */
		return new ModelAndView("hellow","message1",message);
	}
}
