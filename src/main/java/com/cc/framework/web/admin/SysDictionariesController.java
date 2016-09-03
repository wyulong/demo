package com.cc.framework.web.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cc.framework.model.ResultMap;
import com.cc.framework.model.SysDictionaries;
import com.cc.framework.service.SysDictionariesService;
import com.cc.framework.web.BaseController;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("/admin/dict")
public class SysDictionariesController extends BaseController{
	
	private String msg = "";
	
	@Autowired
	private SysDictionariesService sysDictionariesService;
	
	@RequestMapping("/index")
	public ModelAndView index(@RequestParam(value="parentId",required=false) Long parentId){
		ModelAndView mv = new ModelAndView("/admin/dict/index");
		mv.addObject("msg", msg);
		mv.addObject("parentId", parentId);
		return mv;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add(@RequestParam(value="parentId",required=false,defaultValue="0") Long parentId){
		ModelAndView mv = new ModelAndView("/admin/dict/add");
		List<SysDictionaries> list = null;
		if(parentId == null || parentId == 0){
			list = sysDictionariesService.getChildrenByCode(0L);
		}else{
			list = new ArrayList<SysDictionaries>();
			list.add(sysDictionariesService.selectByKey(parentId));
			mv.addObject("parentId", parentId);
		}
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public ResultMap addPost(@ModelAttribute("dict") SysDictionaries dict){
		List<SysDictionaries> list = sysDictionariesService.getBycode(dict.getBianma());
		if(list != null && list.size() > 0){
			return this.failure("编码已经存在");
		}
		int i = sysDictionariesService.save(dict);
		if(i>0){
			return this.success("新增字典成功!");
		}else{
			return this.failure("未知错误请联系管理员！");
		}
	}
	
	@RequestMapping("/check")
	@ResponseBody
	public ResultMap check(@RequestParam(required=false,value="code") String code){
		if(code==null ||"".equals(code)) this.failure("code不能为空");
		List<SysDictionaries> list = sysDictionariesService.getBycode(code);
		if(list != null && list.size() > 0){
			return this.failure("代码已经存在");
		}else{
			return this.success();
		}
	}
	
	@RequestMapping("/del")
	@ResponseBody
	public ResultMap del(@RequestParam(required=false,value="id") Long id){
		if(id==null || id==0) msg = "参数不能为空";
		SysDictionaries dict = sysDictionariesService.selectByKey(id);
		if(sysDictionariesService.delSysDict(dict)){
			return this.success("记录删除成功");
		}else{
			return this.failure("删除失败");
		}
	}
	
	@RequestMapping("/batchdel")
	@ResponseBody
	public ResultMap del(@RequestParam(required=false,value="id") Long[] ids){
		if(ids==null) return this.failure("参数不能为空");
		if(sysDictionariesService.batchDel(ids)){
			return this.success("批量删除成功");
		}
		return this.failure("记录不存在");
	}
	
	
	@RequestMapping("/list.json")
	@ResponseBody
	public Map<String, Object> list(@RequestParam(value="limit",required=false) int limit,
			@RequestParam(value="offset",required=false) int offset,@ModelAttribute(value="resource") SysDictionaries dict,@RequestParam(value="parentId",required=false) Long parentId){
		if(limit == 0) limit = this.pageSize;
		HashMap<String, Object> result = new HashMap<String, Object>();
		int pageNum = (offset/limit)+1;
		if(parentId == null) parentId = 0L;
		dict.setParentId(parentId);
		PageInfo<SysDictionaries> pageInfo = sysDictionariesService.selectByPage(dict, pageNum, limit);
		result.put("rows", pageInfo.getList());
		result.put("total", pageInfo.getTotal());
		return result;
	}
}
