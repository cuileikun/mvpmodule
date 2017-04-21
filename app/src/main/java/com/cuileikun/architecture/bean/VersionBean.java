package com.cuileikun.architecture.bean;

import java.io.Serializable;

/**
 * 作者：popular cui
 * 时间：2017/4/21 11:17
 * 功能:
 */
public class VersionBean implements Serializable {

    /**
     * error :
     * fileSize : 0
     * memberAppUrl :
     * message :
     * result : 1
     * url : http://192.168.1.72/mdk_data/app/mdk3.7.0.0.apk
     * version : 3.7.0.0
     */

    private String error;
    private int fileSize;
    private String memberAppUrl;
    private String message;
    private int result;
    private String url;//最新版本下载链接
    private String version;//后台返回的版本号

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getMemberAppUrl() {
        return memberAppUrl;
    }

    public void setMemberAppUrl(String memberAppUrl) {
        this.memberAppUrl = memberAppUrl;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
