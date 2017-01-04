package com.zxgzeroapp.workingart.bean.request;

import java.io.File;

/**
 * 作者：zxg on 2016/12/27 09:59
 */

public class UploadRequestBean {
    private File mFile;

    public UploadRequestBean(File mFile) {
        this.mFile = mFile;
    }

    public UploadRequestBean() {
    }

    public File getmFile() {
        return mFile;
    }

    public void setmFile(File mFile) {
        this.mFile = mFile;
    }

    @Override
    public String toString() {
        return "UploadRequestBean{" +
                "mFile=" + mFile +
                '}';
    }
}
