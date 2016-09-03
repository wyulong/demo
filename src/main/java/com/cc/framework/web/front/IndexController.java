package com.cc.framework.web.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cc.framework.model.ResultMap;
import com.cc.framework.web.BaseController;


@Controller
public class IndexController extends BaseController{
	
	
	@RequestMapping("/index.do")
	@ResponseBody
	public ResultMap index(){
		return this.success();
	}
	
	@RequestMapping("/jsp.do")
	public ModelAndView jsp(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsp");
		mv.addObject("msg", "hello");
		return mv;
	}
}
