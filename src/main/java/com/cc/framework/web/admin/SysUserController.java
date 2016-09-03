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

import com.cc.framework.model.SysUser;
import com.cc.framework.service.SysUserService;
import com.cc.framework.web.BaseController;
import com.github.pagehelper.PageInfo;


@RequestMapping("/admin/sysuser")
@Controller
public class SysUserController extends BaseController{
	
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("/index")
	public ModelAndView index(){
		return new ModelAndView("/admin/sysuser/index");
	}
	
	@RequestMapping("/add")
	public ModelAndView add(){
		return new ModelAndView("/admin/sysuser/add");
	}
	
	@RequestMapping("/list.json")
	@ResponseBody
	public Map<String, Object> list(@RequestParam(value="limit",required=false) int limit,
			@RequestParam(value="offset",required=false) int offset,@ModelAttribute(value="user") SysUser user){
		if(limit == 0) limit = this.pageSize;
		HashMap<String, Object> result = new HashMap<String, Object>();
		int pageNum = (offset/limit)+1;
		PageInfo<SysUser> pageInfo = sysUserService.selectByPage(user, pageNum, limit);
		result.put("rows", pageInfo.getList());
		result.put("total", pageInfo.getTotal());
		return result;
	}
}
