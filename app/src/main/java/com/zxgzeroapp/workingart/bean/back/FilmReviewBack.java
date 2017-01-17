package com.zxgzeroapp.workingart.bean.back;

import com.zxgzeroapp.workingart.base.BaseBean;

import java.util.List;

/**
 * 作者：zxg on 2017/1/10 15:47
 */

public class FilmReviewBack  extends BaseBean{

    /**
     * resultcode : 200
     * reason : success
     * result : [{"rid":"1","name":"中国合伙人","wk":"2013.5.20--2013.5.26（单位：人民币）","wboxoffice":"￥20900万","tboxoffice":"￥31700万"}]
     * error_code : 10001
     */

    private String resultcode;
    private String reason;
    private int error_code;
    /**
     * rid : 1
     * name : 中国合伙人
     * wk : 2013.5.20--2013.5.26（单位：人民币）
     * wboxoffice : ￥20900万
     * tboxoffice : ￥31700万
     */

    private List<ResultBean> result;

    @Override
    public String toString() {
        return "FilmReviewBack{" +
                "error_code=" + error_code +
                ", resultcode='" + resultcode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

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

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String rid;
        private String name;
        private String wk;
        private String wboxoffice;
        private String tboxoffice;

        public String getRid() {
            return rid;
        }

        public void setRid(String rid) {
            this.rid = rid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWk() {
            return wk;
        }

        public void setWk(String wk) {
            this.wk = wk;
        }

        public String getWboxoffice() {
            return wboxoffice;
        }

        public void setWboxoffice(String wboxoffice) {
            this.wboxoffice = wboxoffice;
        }

        public String getTboxoffice() {
            return tboxoffice;
        }

        public void setTboxoffice(String tboxoffice) {
            this.tboxoffice = tboxoffice;
        }
    }
}
