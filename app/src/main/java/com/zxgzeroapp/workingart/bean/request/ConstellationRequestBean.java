package com.zxgzeroapp.workingart.bean.request;

/**
 * 作者：zxg on 2017/1/17 15:26
 */

public class ConstellationRequestBean {
    /**
     * 应用APPKEY(应用详细页查询)
     */
    private String key;
    /**
     * 星座名称，如:双鱼座
     */
    private String consName;
    /**
     * 运势类型：today,tomorrow,week,nextweek,month,year
     */
    private String type;

    public ConstellationRequestBean() {
    }

    public ConstellationRequestBean(String consName, String key, String type) {
        this.consName = consName;
        this.key = key;
        this.type = type;
    }

    public String getConsName() {
        return consName;
    }

    public void setConsName(String consName) {
        this.consName = consName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ConstellationRequestBean{" +
                "consName='" + consName + '\'' +
                ", key='" + key + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
