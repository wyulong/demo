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

import com.cc.framework.model.SysArea;
import com.cc.framework.service.SysAreaService;
import com.cc.framework.web.BaseController;
import com.github.pagehelper.PageInfo;


@RequestMapping("/admin/area")
@Controller
public class SysAreaController extends BaseController{
	
	@Autowired
	private SysAreaService sysAreaService;
	
	@RequestMapping("/index")
	public ModelAndView index(){
		return new ModelAndView("/admin/area/index");
	}
	
	@RequestMapping("/list.json")
	@ResponseBody
	public Map<String, Object> list(@RequestParam(value="limit",required=false) int limit,
			@RequestParam(value="offset",required=false) int offset,@ModelAttribute(value="resource") SysArea area){
		if(limit == 0) limit = this.pageSize;
		HashMap<String, Object> result = new HashMap<String, Object>();
		int pageNum = (offset/limit)+1;
		PageInfo<SysArea> pageInfo = sysAreaService.selectByPage(area, pageNum, limit);
		result.put("rows", pageInfo.getList());
		result.put("total", pageInfo.getTotal());
		return result;
	}
}
