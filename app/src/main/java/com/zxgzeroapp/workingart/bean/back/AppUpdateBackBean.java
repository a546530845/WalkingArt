package com.zxgzeroapp.workingart.bean.back;

import com.zxgzeroapp.workingart.base.BaseBean;

import java.util.List;

/**
 * 作者：zxg on 2016/9/30 14:59
 * app更新请求返回bean
 * 看看两个app是否有要更新的
 */
public class AppUpdateBackBean extends BaseBean {


    @Override
    public String toString() {
        return "AppUpdateBackBean{" +
                "content=" + content +
                "} " + super.toString();
    }

    /**
     * id : 9
     * versionType : 1
     * versionName : 11-29可退出
     * versionCode : 2
     * increase :
     * versionDesc : 11-29可退出
     * creator :
     * createTime : 1480556835000
     * updateTime : 3415145415415
     * fileId : 194
     */

    private List<ContentBean> content;

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class ContentBean {
        private int id;
        private int versionType;
        private String versionName;
        private String versionCode;
        private String increase;
        private String versionDesc;
        private String creator;
        private long createTime;
        private long updateTime;
        private int fileId;

        @Override
        public String toString() {
            return "ContentBean{" +
                    "createTime=" + createTime +
                    ", id=" + id +
                    ", versionType=" + versionType +
                    ", versionName='" + versionName + '\'' +
                    ", versionCode='" + versionCode + '\'' +
                    ", increase='" + increase + '\'' +
                    ", versionDesc='" + versionDesc + '\'' +
                    ", creator='" + creator + '\'' +
                    ", updateTime=" + updateTime +
                    ", fileId=" + fileId +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getVersionType() {
            return versionType;
        }

        public void setVersionType(int versionType) {
            this.versionType = versionType;
        }

        public String getVersionName() {
            return versionName;
        }

        public void setVersionName(String versionName) {
            this.versionName = versionName;
        }

        public String getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(String versionCode) {
            this.versionCode = versionCode;
        }

        public String getIncrease() {
            return increase;
        }

        public void setIncrease(String increase) {
            this.increase = increase;
        }

        public String getVersionDesc() {
            return versionDesc;
        }

        public void setVersionDesc(String versionDesc) {
            this.versionDesc = versionDesc;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getFileId() {
            return fileId;
        }

        public void setFileId(int fileId) {
            this.fileId = fileId;
        }
    }
}
