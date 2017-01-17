package com.zxgzeroapp.workingart.bean.request;

/**
 * 作者：zxg on 2016/12/27 14:26
 */

public class FilmRequestBean {
    /**
     * 票房榜的区域,CN-内地，US-北美，HK-香港
     */
    private String area;
    /**
     *应用APPKEY(应用详细页查询)
     */
    private String key;
    /**
     * 返回数据的格式,xml/json，默认json
     * 非必填
     */
    private String dtype;

    public FilmRequestBean(String area, String dtype, String key) {
        this.area = area;
        this.dtype = dtype;
        this.key = key;
    }

    public FilmRequestBean() {
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "FilmRequestBean{" +
                "area='" + area + '\'' +
                ", key='" + key + '\'' +
                ", dtype='" + dtype + '\'' +
                '}';
    }
}
