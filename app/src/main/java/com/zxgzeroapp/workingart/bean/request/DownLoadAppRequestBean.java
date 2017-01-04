package com.zxgzeroapp.workingart.bean.request;

/**
 * 作者：zxg on 2016/11/9 11:07
 * 下载请求
 */

public class DownLoadAppRequestBean {
    /**
     * 文件id
     */
    private String fileId;
    /**
     * 文件存放地址
     */
    private String filepath;
    /**
     * 下载app类型
     */
    private String type;


    public DownLoadAppRequestBean(String fileId, String filepath, String type) {
        this.fileId = fileId;
        this.filepath = filepath;
        this.type = type;
    }

    public DownLoadAppRequestBean() {
    }

    @Override
    public String toString() {
        return "DownLoadAppRequestBean{" +
                "fileId='" + fileId + '\'' +
                ", filepath='" + filepath + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
