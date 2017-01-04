package com.zxgzeroapp.workingart.bean.request;

/**
 * 作者：zxg on 2016/12/27 14:26
 */

public class LoginRequestBean {
    private String mUesrName;
    private String mPassWord;
    private String mPosCode;

    public LoginRequestBean(String mPassWord, String mPosCode, String mUesrName) {
        this.mPassWord = mPassWord;
        this.mPosCode = mPosCode;
        this.mUesrName = mUesrName;
    }

    public LoginRequestBean() {
    }

    public String getmPassWord() {
        return mPassWord;
    }

    public void setmPassWord(String mPassWord) {
        this.mPassWord = mPassWord;
    }

    public String getmPosCode() {
        return mPosCode;
    }

    public void setmPosCode(String mPosCode) {
        this.mPosCode = mPosCode;
    }

    public String getmUesrName() {
        return mUesrName;
    }

    public void setmUesrName(String mUesrName) {
        this.mUesrName = mUesrName;
    }

    @Override
    public String toString() {
        return "LoginRequestBean{" +
                "mPassWord='" + mPassWord + '\'' +
                ", mUesrName='" + mUesrName + '\'' +
                ", mPosCode='" + mPosCode + '\'' +
                '}';
    }
}
