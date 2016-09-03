package com.cc.framework.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cc.framework.web.BaseController;


@Controller
@RequestMapping("/admin/org")
public class SysOrganizationController extends BaseController{
	
	@RequestMapping("/index")
	public ModelAndView list(){
		return new ModelAndView("/admin/org/index");
	}
	
}
