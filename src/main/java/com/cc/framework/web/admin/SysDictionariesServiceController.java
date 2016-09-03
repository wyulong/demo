package com.cc.framework.web.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cc.framework.model.SysDictionaries;
import com.cc.framework.service.SysDictionariesService;
import com.cc.framework.web.BaseController;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("/admin/dict")
public class SysDictionariesServiceController extends BaseController{
	
	
	@Autowired
	private SysDictionariesService sysDictionariesService;
	
	@RequestMapping("/index")
	public ModelAndView index(){
		return new ModelAndView("/admin/dict/index");
	}
	
	
	@RequestMapping("/list.json")
	@ResponseBody
	public Map<String, Object> list(@RequestParam(value="limit",required=false) int limit,
			@RequestParam(value="offset",required=false) int offset,@ModelAttribute(value="resource") SysDictionaries dict){
		if(limit == 0) limit = this.pageSize;
		HashMap<String, Object> result = new HashMap<String, Object>();
		int pageNum = (offset/limit)+1;
		PageInfo<SysDictionaries> pageInfo = sysDictionariesService.selectByPage(dict, pageNum, limit);
		result.put("rows", pageInfo.getList());
		result.put("total", pageInfo.getTotal());
		return result;
	}
}
