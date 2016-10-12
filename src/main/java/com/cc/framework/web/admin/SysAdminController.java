/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.cc.framework.web.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cc.framework.model.ResultMap;
import com.cc.framework.model.SysAdmin;
import com.cc.framework.model.SysAdminRole;
import com.cc.framework.model.SysRole;
import com.cc.framework.service.SysAdminService;
import com.cc.framework.service.SysRoleService;
import com.cc.framework.web.BaseController;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @version 1.0
 */
@Controller()
@RequestMapping("/admin/admin")
public class SysAdminController extends BaseController {
	
	private String msg = "";
	
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysAdminService sysAdminService;
	
	
	/**
	 * 检查用户名是否存在
	 */
	@RequestMapping(value = "/check_username", method = RequestMethod.GET)
	@ResponseBody
	public boolean checkUsername(String username) {
		if (StringUtils.isEmpty(username)) {
			return false;
		}
		if (sysAdminService.usernameExists(username)) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 *  
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("roles", sysRoleService.findAll());
		return "/admin/admin/add";
	}
	
	@RequestMapping("/del.json")
	@ResponseBody
	public ResultMap del(Long[] ids){
		if(ids==null || ids.length <=0){
			return this.failure("请至少选择一行数据!");
		}
		sysAdminService.batchDelAdmins(ids);
		return this.success("管理员删除成功！");
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(SysAdmin admin, Long[] roleIds, RedirectAttributes redirectAttributes) {
		Set<SysRole> roles = (new HashSet<SysRole>(sysRoleService.findList(roleIds)));
		/*if (!isValid(admin, Save.class)) {
			return ERROR_VIEW;
		}*/
		if (sysAdminService.usernameExists(admin.getUsername())) {
			return ERROR_VIEW;
		}
		admin.setPassword(DigestUtils.md5Hex(admin.getPassword()));
		admin.setIsLocked(false);
		admin.setLoginFailureCount(0);
		admin.setLockedDate(null);
		admin.setLoginDate(null);
		admin.setLoginIp(null);
		admin.setCreateDate(new Date());
		admin.setModifyDate(new Date());
//		admin.setOrders(null);
		sysAdminService.saveUserAndRole(admin,roles);
//		addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
		return "redirect:index";
	}
	
	/**
	 * 编辑
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("/admin/admin/index");
		mv.addObject("msg", msg);
		return mv;
	}
	
	@RequestMapping("/list.json")
	@ResponseBody
	public Map<String, Object> list(@RequestParam(value="limit",required=false) int limit,
			@RequestParam(value="offset",required=false) int offset,@ModelAttribute(value="admin") SysAdmin admin){
		if(StringUtils.isEmpty(admin.getName())){
			admin.setName(null);
		}
		if(StringUtils.isEmpty(admin.getUsername())){
			admin.setUsername(null);
		}
		if(StringUtils.isEmpty(admin.getEmail())){
			admin.setEmail(null);
		}
		if(StringUtils.isEmpty(admin.getDepartment())){
			admin.setDepartment(null);
		}
		if(limit == 0) limit = this.pageSize;
		HashMap<String, Object> result = new HashMap<String, Object>();
		int pageNum = (offset/limit)+1;
		PageInfo<SysAdmin> pageInfo = sysAdminService.selectByPage(admin, pageNum, limit);
		result.put("rows", pageInfo.getList());
		result.put("total", pageInfo.getTotal());
		return result;
	}
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Long id, ModelMap model) {
		List<SysRole> allrole = sysRoleService.findAll();
		SysAdmin admin = sysAdminService.find(id);
		if(admin == null) return ERROR_VIEW;
		List<SysAdminRole> roles = admin.getRoles();
		for(SysAdminRole adminrole:roles){
			for(SysRole role:allrole){
				if(adminrole.getRoles()==role.getId())role.setSelected(true);
			}
		}
		model.addAttribute("roles", allrole);
		model.addAttribute("admin", admin);
		return "/admin/admin/edit";
	}
	
	/**
	 * 更新
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(SysAdmin admin, Long[] roleIds, RedirectAttributes redirectAttributes) {
		Set<SysRole> roles = (new HashSet<SysRole>(sysRoleService.findList(roleIds)));
		SysAdmin pAdmin = sysAdminService.find(admin.getId());
		if (pAdmin == null) {
			return ERROR_VIEW;
		}
		if (StringUtils.isNotEmpty(admin.getPassword())) {
			admin.setPassword(DigestUtils.md5Hex(admin.getPassword()));
		} else {
			admin.setPassword(pAdmin.getPassword());
		}
		if (pAdmin.getIsLocked() && !admin.getIsLocked()) {
			admin.setLoginFailureCount(0);
			admin.setLockedDate(null);
		} else {
			admin.setIsLocked(pAdmin.getIsLocked());
			admin.setLoginFailureCount(pAdmin.getLoginFailureCount());
			admin.setLockedDate(pAdmin.getLockedDate());
		}
		sysAdminService.update(admin,roles);
		return "redirect:index";
	}
	
	/**
	 * 列表
	 */
	/*@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Pageable pageable, ModelMap model) {
		model.addAttribute("page", adminService.findPage(pageable));
		return "/admin/admin/list";
	}*/

	/**
	 * 删除
	 */
	/*@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public BaseResult delete(Long[] ids) {
		if (ids.length >= adminService.count()) {
			return Message.error("admin.common.deleteAllNotAllowed");
		}
		adminService.delete(ids);
		return SUCCESS_MESSAGE;
	}*/

	

}