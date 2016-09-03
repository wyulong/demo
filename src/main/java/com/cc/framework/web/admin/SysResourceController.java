package com.cc.framework.web.admin;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cc.framework.model.SysResource;
import com.cc.framework.service.SysResourceService;
import com.cc.framework.web.BaseController;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("/admin/resources")
public class SysResourceController extends BaseController{

	@Autowired
	private SysResourceService sysResourceService;
	
	@RequestMapping("/index")
	public ModelAndView index(){
		
		return new ModelAndView("/admin/resources/index");
	}
	
	
	@RequestMapping("/list.json")
	@ResponseBody
	public HashMap<String, Object> list(@RequestParam(value="limit",required=false) int limit,
			@RequestParam(value="offset",required=false) int offset,@ModelAttribute(value="resource") SysResource res){
		if(limit == 0) limit = this.pageSize;
		HashMap<String, Object> result = new HashMap<String, Object>();
		int pageNum = (offset/limit)+1;
		PageInfo<SysResource> pageInfo = sysResourceService.findResourceByPage(res, pageNum, limit);
		result.put("rows", pageInfo.getList());
		result.put("total", pageInfo.getTotal());
		return result;/*;*/
	}
}
