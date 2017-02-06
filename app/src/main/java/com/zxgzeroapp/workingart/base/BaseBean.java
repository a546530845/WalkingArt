package com.zxgzeroapp.workingart.base;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/21.
 * base基类，定义bean类共同值
 */
//{
//        success: false,
//        msg: 登录超时,
//        code: e001,
//        "pageNo": 1,
//        "pageSize": 1,
//        "totalPages": 1,
//        "totalCount": 1
//        }
public class BaseBean implements Serializable {


    /**
     * resultcode : 101
     * reason : KEY ERROR!
     */

    private String resultcode;
    private String reason;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "reason='" + reason + '\'' +
                ", resultcode='" + resultcode + '\'' +
                '}';
    }

}
