package com.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON; 
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.form.Contact;
import com.model.Shop;

//���� <context:component-scan>��������Զ�ʶ�������һ�� Controller
@Controller
@SessionAttributes
public class ContactController {
	
	@RequestMapping("/contact")
	public ModelAndView showContracts(){
		System.out.println("showContracts!");
											/*command	�൱��key ��contact�൱��value*/			
		return new ModelAndView("contact","command",new Contact());
	}
	
	//@ModelAttribute ����Ϊ��ͼ��Ⱦ�ṩ�����ģ������
	@RequestMapping(value="/addContact",method=RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result){
		System.out.println("FirstName:"+contact.getFirstname()+"LastName:"+contact.getLastname());
		
		return "redirect:contact.do";
	}
	
	@RequestMapping(value="/getShopJson")
	//@RequestMapping(value="/jsonk")
	public void getUserJson(Shop shop, HttpServletRequest request, HttpServletResponse response){
		String result = "{\"name\":\"��������������\"}";
		PrintWriter out = null;
		/*����json��ʽ����*/
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		try {
			/*д�봫��*/
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//jsonTest
	@RequestMapping(value="/getjson",method=RequestMethod.POST)
	@ResponseBody
	/* @ResponseBody(������������󷵻صĶ���󶨵���Ӧ����) */
	public String getData(){
		List<Object> list=new ArrayList<Object>();
		list.add("1");
		list.add("aaa");
		list.add("bb");
		Shop shop = new Shop();
		shop.setName("fuck");
		shop.setStaffName(new String[]{"fuck you","fuck she","fuck ��"});
		list.add(shop);
		JSONArray jobj = JSONArray.fromObject(list);
		System.out.println(jobj.toString());
		return jobj.toString();
	}
	
	//////
	@RequestMapping(value="/jsonk", method = RequestMethod.POST)
	/*HttpServletRequest request, HttpServletResponse response ������*/
	public  void getShopInJSON(HttpServletRequest request, HttpServletResponse response) {
		/* @ResponseBody(������������󷵻صĶ���󶨵���Ӧ����) */
		//��������
		Shop shop = new Shop();
		System.out.println("Shop......");
		shop.setName("lalala");
		shop.setStaffName(new String[]{"ML1", "ML2"});
		System.out.println("shop value="+shop.getName());
		//
		JSONArray jobj = JSONArray.fromObject(shop);
		System.out.println("===="+jobj.toString());
	/*	����ȥҳ��һ��shop����*/
		String data="abcd";
		//return data;//jobj.toString();

	}
	
	
}
