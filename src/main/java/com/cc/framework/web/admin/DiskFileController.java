package com.cc.framework.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cc.framework.model.DiskFileList;
import com.cc.framework.util.FileUtil;


@Controller
@RequestMapping("/admin/disk")
public class DiskFileController {
	
	String diskPath = "D:\\win7usb";
	
	
	@RequestMapping("/index")
	public ModelAndView index(@RequestParam(required=false,value="parent")String parent){
		DiskFileList result = null;
		ModelAndView mv = new ModelAndView("admin/disk/index");
		if(parent == null || "".equals(parent)){
			mv.addObject("parent", diskPath);
		}else{
			if(parent.indexOf("\\") > 0 && parent.substring(0,parent.lastIndexOf("\\")).indexOf(diskPath) > 0){
				mv.addObject("parent", parent.substring(0,parent.lastIndexOf("\\")));
			}else{
				mv.addObject("parent", diskPath);
			}
		}
		if(parent == null || "".equals(parent)){
			result = FileUtil.traverseFolder(diskPath);
		}else{
			result = FileUtil.traverseFolder(parent);
		}
		mv.addObject("result", result);
		return mv;
	}
	
	
}
