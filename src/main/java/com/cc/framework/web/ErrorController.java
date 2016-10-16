package com.cc.framework.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rest/page")
public class ErrorController {

	@RequestMapping("/404")
	public ModelAndView Error404(){
		ModelAndView mv = new ModelAndView("/404");
		return mv;
	}
	@RequestMapping("/500")
	public ModelAndView Error500(){
		ModelAndView mv = new ModelAndView("/500");
		return mv;
	}
}
