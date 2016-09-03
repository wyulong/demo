package com.cc.framework.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cc.framework.web.BaseController;


@Controller
@RequestMapping("/admin")
public class AdminIndexController extends BaseController{

	@RequestMapping("/index")
	public ModelAndView index(){
		return new ModelAndView("admin/index");
	}
	
	@RequestMapping("/login")
	public ModelAndView login(){
		return new ModelAndView("admin/login");
	}
	
	
	@RequestMapping("/welcome")
	public ModelAndView welcom(){
		return new ModelAndView("admin/welcome");
	}
}
