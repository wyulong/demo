package com.cc.framework.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_files")
public class SysFiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_origin_name")
    private String fileOriginName;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "upload_time")
    private Date uploadTime;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "file_class")
    private String fileClass;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return file_origin_name
     */
    public String getFileOriginName() {
        return fileOriginName;
    }

    /**
     * @param fileOriginName
     */
    public void setFileOriginName(String fileOriginName) {
        this.fileOriginName = fileOriginName;
    }

    /**
     * @return file_name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return file_path
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return upload_time
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * @param uploadTime
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    /**
     * @return file_type
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * @param fileType
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * @return file_class
     */
    public String getFileClass() {
        return fileClass;
    }

    /**
     * @param fileClass
     */
    public void setFileClass(String fileClass) {
        this.fileClass = fileClass;
    }
}