package com.crunchify.controller;
 
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.OrderJDBCTemplate;
import com.model.Order;
import com.tutorialspoint.Student;
import com.tutorialspoint.StudentJDBCTemplate;
import com.util.JDBCTemplate;
/*
 * author: Crunchify.com
 * 
 */
 
@Controller
public class CrunchifyHelloWorld {
	  
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
	
	@RequestMapping(value = "/showorder", method = RequestMethod.POST)
	public ModelAndView showOrder(HttpServletRequest request, HttpServletResponse response)  throws IOException {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("Beans.xml");
	      OrderJDBCTemplate orderJDBCTemplate = 
	      (OrderJDBCTemplate)context.getBean("OrderJDBCTemplate");  
	      
	      if (request.getParameterMap().containsKey("gcid")) {
	    	  String gcid = request.getParameter("gcid");
	    	  if (request.getParameterMap().containsKey("newEmail")) {
	    		  String newEmail = request.getParameter("newEmail");
	    		  orderJDBCTemplate.setOrder(gcid,newEmail);
	    	  }
	        }
	      
	      String orderId = request.getParameter("orderId");
	      List<Map<String, Object>> order = orderJDBCTemplate.getOrder(orderId);
	      System.out.println(orderId);
	     // System.out.println(((Order) order).getCompanyName());
	      
		//String message = "<br><div style='text-align:center;'>"
			//	+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>"+order.getCompanyName();
		//return new ModelAndView("showorder", "message", order);
	      
	     // Map<String, Object> model = new HashMap<String, Object>();
	      //model.put("order", order);
	      //model.put("message", "Hello");
	      //and so on
	      //return new ModelAndView("welcomePage", "model", model);
	      ModelAndView mav = new ModelAndView("showorder");
	      mav.addObject("message", "Hello World!");
	      mav.addObject("order", order);
	      mav.addObject("orderId", orderId);
	      return mav;
	}
	
	
	@RequestMapping(value = "/dosomething", method = RequestMethod.GET)
	public ModelAndView dosomething(HttpServletRequest request, HttpServletResponse response)  throws IOException {
	    // setup your Cookie here
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("redirect:/other-page");

	    return mav;
	}
	
}