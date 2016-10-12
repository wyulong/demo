package com.cc.framework.model;

import java.util.List;

public class DiskFileList {
	
	private List<DiskFile> files ;
	private Integer totalFiles;
	private Integer totalFolders;
	private String currentDir;
	
	
	public String getCurrentDir() {
		return currentDir;
	}
	public void setCurrentDir(String currentDir) {
		this.currentDir = currentDir;
	}
	public List<DiskFile> getFiles() {
		return files;
	}
	public void setFiles(List<DiskFile> files) {
		this.files = files;
	}
	public Integer getTotalFiles() {
		return totalFiles;
	}
	public void setTotalFiles(Integer totalFiles) {
		this.totalFiles = totalFiles;
	}
	public Integer getTotalFolders() {
		return totalFolders;
	}
	public void setTotalFolders(Integer totalFolders) {
		this.totalFolders = totalFolders;
	}
	
}
