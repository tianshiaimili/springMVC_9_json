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

//借助 <context:component-scan>，框架能自动识别到这就是一个 Controller
@Controller
@SessionAttributes
public class ContactController {
	
	@RequestMapping("/contact")
	public ModelAndView showContracts(){
		System.out.println("showContracts!");
											/*command	相当于key 而contact相当于value*/			
		return new ModelAndView("contact","command",new Contact());
	}
	
	//@ModelAttribute 可以为视图渲染提供更多的模型数据
	@RequestMapping(value="/addContact",method=RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result){
		System.out.println("FirstName:"+contact.getFirstname()+"LastName:"+contact.getLastname());
		
		return "redirect:contact.do";
	}
	
	@RequestMapping(value="/getShopJson")
	//@RequestMapping(value="/jsonk")
	public void getUserJson(Shop shop, HttpServletRequest request, HttpServletResponse response){
		String result = "{\"name\":\"啦啦啦德玛西亚\"}";
		PrintWriter out = null;
		/*设置json格式传输*/
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		try {
			/*写入传输*/
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//jsonTest
	@RequestMapping(value="/getjson",method=RequestMethod.POST)
	@ResponseBody
	/* @ResponseBody(将处理完请求后返回的对象绑定到响应正文) */
	public String getData(){
		List<Object> list=new ArrayList<Object>();
		list.add("1");
		list.add("aaa");
		list.add("bb");
		Shop shop = new Shop();
		shop.setName("fuck");
		shop.setStaffName(new String[]{"fuck you","fuck she","fuck 啦"});
		list.add(shop);
		JSONArray jobj = JSONArray.fromObject(list);
		System.out.println(jobj.toString());
		return jobj.toString();
	}
	
	//////
	@RequestMapping(value="/jsonk", method = RequestMethod.POST)
	/*HttpServletRequest request, HttpServletResponse response 不能少*/
	public  void getShopInJSON(HttpServletRequest request, HttpServletResponse response) {
		/* @ResponseBody(将处理完请求后返回的对象绑定到响应正文) */
		//测试数据
		Shop shop = new Shop();
		System.out.println("Shop......");
		shop.setName("lalala");
		shop.setStaffName(new String[]{"ML1", "ML2"});
		System.out.println("shop value="+shop.getName());
		//
		JSONArray jobj = JSONArray.fromObject(shop);
		System.out.println("===="+jobj.toString());
	/*	返回去页面一个shop对象*/
		String data="abcd";
		//return data;//jobj.toString();

	}
	
	
}
