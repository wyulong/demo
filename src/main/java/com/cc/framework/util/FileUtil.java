package com.cc.framework.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.cc.framework.model.DiskFile;
import com.cc.framework.model.DiskFileList;

public class FileUtil {
	
	private static String fileDir = "D:\\win7usb";
	
	/**
	 * 读取目录下的文件
	 * @param path
	 * @return
	 */
	public static DiskFileList traverseFolder(String path) {
		File file = new File(path);
		if(!file.getAbsolutePath().startsWith(fileDir)) return null;
		if (file.exists()) {
        	int fileNum = 0;
        	int folderNum = 0;
        	DiskFileList diskFileList = new DiskFileList();
        	diskFileList.setCurrentDir(file.getName());
        	List<DiskFile> diskFiles = new ArrayList<DiskFile>();
        	File[] files = file.listFiles();
        	DiskFile f = null;
    		Calendar cal = Calendar.getInstance();    
    		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");           
            for (File file2 : files) {
            	f = new DiskFile();
            	f.setFileFullPath(file2.getAbsolutePath());
            	cal.setTimeInMillis(file2.lastModified());
            	f.setFileName(file2.getName());
            	f.setModifiedDate(formatter.format(cal.getTime()));
            	diskFiles.add(f);
                if (file2.isDirectory()) {
                	f.setFile(false);
                    fileNum++;
                } else {
                	f.setFile(true);
                	folderNum++;
                }
            }
            diskFileList.setFiles(diskFiles);
            diskFileList.setTotalFiles(fileNum);
            diskFileList.setTotalFolders(folderNum);
            return diskFileList;
        }
        return null;
    }
	
	/**
	 * 删除文件
	 * @param path
	 * @return
	 */
	public static boolean deleteFile(String path){
		File f = new File(path);
		if(f.exists()){
			f.delete();
			return true;
		}else{
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println(traverseFolder("D:\\win7usb\\mount"));
	}
}
