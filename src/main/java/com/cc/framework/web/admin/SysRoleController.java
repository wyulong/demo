package com.cc.framework.web.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.search.impl.BaseResult;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cc.framework.model.ResultMap;
import com.cc.framework.model.SysRole;
import com.cc.framework.model.SysRoleAuthority;
import com.cc.framework.service.SysRoleAuthorityService;
import com.cc.framework.service.SysRoleService;
import com.cc.framework.web.BaseController;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("/admin/role")
public class SysRoleController extends BaseController{

	private String msg = "";
	
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysRoleAuthorityService sysRoleAuthorityService;
	
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("admin/role/index");
		mv.addObject("msg", msg);
		return mv;
	}
	
	@RequestMapping("/add")
	public ModelAndView add(){
		ModelAndView mv = new ModelAndView("admin/role/add");
		mv.addObject("msg", msg);
		return mv;
	}
	
	@RequestMapping("/del.json")
	@ResponseBody
	public ResultMap del(Long[] ids){
		if(ids != null && ids.length > 0){
			sysRoleService.batchDelRoles(ids);
			return this.success("数据删除成功");
		}else{
			return this.failure("请选择至少一行数据！");
		}
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit(Long id){
		ModelAndView mv = new ModelAndView("admin/role/edit");
		SysRole role = sysRoleService.selectByKey(id);
		List<SysRoleAuthority> authories = sysRoleAuthorityService.findAuthByRole(id);
		StringBuffer sb = new StringBuffer();
		for(SysRoleAuthority auth:authories){
			sb.append(auth.getAuthorities());
			sb.append("---");
		}
		mv.addObject("msg", msg);
		mv.addObject("role", role);
		mv.addObject("authories", sb.toString());
		return mv;
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(SysRole role,String[] authorities, RedirectAttributes redirectAttributes) {
		role.setIsSystem(false);
		role.setCreateDate(new Date());
		role.setModifyDate(new Date());
		sysRoleService.save(role);
		List<SysRoleAuthority> authlist = new ArrayList<SysRoleAuthority>();
		SysRoleAuthority sysRoleAuthority = null;
		for(String auth:authorities){
			sysRoleAuthority = new SysRoleAuthority();
			sysRoleAuthority.setAuthorities(auth);
			sysRoleAuthority.setRole(role.getId());
			authlist.add(sysRoleAuthority);
		}
		sysRoleAuthorityService.save(authlist);
		return "redirect:index";
	}
	
	/**
	 * 更新
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(SysRole role, String[] authorities,RedirectAttributes redirectAttributes) {
		SysRole pRole = sysRoleService.selectByKey(role.getId());
		if (pRole == null || pRole.getIsSystem()) {
			return ERROR_VIEW;
		}
		pRole.setModifyDate(new Date());
		pRole.setDescription(role.getDescription());
		pRole.setIsSystem(false);
		sysRoleService.updateNotNull(pRole);
		
		sysRoleAuthorityService.delete(role.getId());
		
		List<SysRoleAuthority> authlist = new ArrayList<SysRoleAuthority>();
		SysRoleAuthority sysRoleAuthority = null;
		for(String auth:authorities){
			sysRoleAuthority = new SysRoleAuthority();
			sysRoleAuthority.setAuthorities(auth);
			sysRoleAuthority.setRole(role.getId());
			authlist.add(sysRoleAuthority);
		}
		sysRoleAuthorityService.save(authlist);
		
		return "redirect:index";
	}
	
	@RequestMapping("/list.json")
	@ResponseBody
	public Map<String, Object> list(@RequestParam(value="limit",required=false) int limit,
			@RequestParam(value="offset",required=false) int offset,@ModelAttribute(value="role") SysRole role){
		if(limit == 0) limit = this.pageSize;
		HashMap<String, Object> result = new HashMap<String, Object>();
		int pageNum = (offset/limit)+1;
		if(StringUtils.isEmpty(role.getName())){
			role.setName(null);
		}
		PageInfo<SysRole> pageInfo = sysRoleService.selectByPage(role, pageNum, limit);
		result.put("rows", pageInfo.getList());
		result.put("total", pageInfo.getTotal());
		return result;
	}
	
}
