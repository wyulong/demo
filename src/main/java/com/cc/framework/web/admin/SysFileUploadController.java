package com.cc.framework.web.admin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cc.framework.model.ResultMap;
import com.cc.framework.model.SysFiles;
import com.cc.framework.service.SysFilesService;
import com.cc.framework.web.BaseController;


@Controller
@RequestMapping("/admin/sysfile")
public class SysFileUploadController extends BaseController{
	
	String diskPath = "D:\\win7usb";
	
	@Autowired
	private SysFilesService sysFilesService;
	
	@RequestMapping(value = "/upload") 
	@ResponseBody
    public ResultMap upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {  
        String path = diskPath;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String filePath = diskPath+File.separator+sdf.format(new Date());
        File f = new File(filePath);
        if(!f.exists()){
        	f.mkdirs();
        }
        String ip = request.getRemoteAddr();
        String orgName = file.getOriginalFilename();
        String extName = orgName.substring(orgName.lastIndexOf("."));
        String fileName = Math.abs((ip+orgName).hashCode())+extName;
        path = filePath+File.separator+fileName;
//        String fileName = new Date().getTime()+".jpg";
        System.out.println(path);  
        File targetFile = new File(filePath, fileName);  
        if(!targetFile.exists()){
            targetFile.mkdirs();  
        }  
        //保存 
        try {
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        SysFiles files = new SysFiles();
        files.setFileName(fileName);
        files.setFileOriginName(orgName);
        files.setFilePath(path);
        files.setUploadTime(new Date());
        files.setFileType(extName.toUpperCase().substring(1));
        files.setFileClass("UPLOAD");
        sysFilesService.save(files);
        return this.success(path);  
    }
	
	
	/** * @Description 下载文件 * @author zhangyd * @date 2015年12月11日 下午6:11:33 * @param fileName * @param file * @return * @throws IOException */ 
	@RequestMapping("/download/{id}")
	@ResponseBody
	public ResponseEntity<?> download(@PathVariable(value="id")Long id)
			throws IOException {
		SysFiles file = sysFilesService.selectByKey(id);
		if(file != null){
			String dfileName = new String(file.getFileOriginName().getBytes("gb2312"), "iso8859-1");
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.setContentDispositionFormData("attachment", dfileName);
			return new ResponseEntity(FileUtils.readFileToByteArray(new File(file.getFilePath())), headers,
					HttpStatus.CREATED);
		}
		return null;
	}
	
	/** * @Description 下载文件 * @author zhangyd * @date 2015年12月11日 下午6:11:33 * @param fileName * @param file * @return * @throws IOException */ 
	@RequestMapping("/images/{id}")
	public void images(@PathVariable(value="id")Long id,HttpServletResponse response)
			throws IOException {
		SysFiles file = sysFilesService.selectByKey(id);
		if(file != null){
			/*String dfileName = new String(file.getFileOriginName().getBytes("gb2312"), "iso8859-1");
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG);
			headers.setContentDispositionFormData("attachment", dfileName);
			return new ResponseEntity(FileUtils.readFileToByteArray(new File(file.getFilePath())), headers,
					HttpStatus.CREATED);*/
			BufferedImage bufferedImage = ImageIO.read(new FileInputStream(file.getFilePath()));
			ImageIO.write(bufferedImage,"JPG",response.getOutputStream());       
		}
	}
	 
	
	@RequestMapping("/index")
	public ModelAndView index(){
		return new ModelAndView("admin/sysfile/index");
	}
	
}
