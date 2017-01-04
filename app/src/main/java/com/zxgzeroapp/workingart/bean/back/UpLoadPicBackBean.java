package com.zxgzeroapp.workingart.bean.back;


import com.zxgzeroapp.workingart.base.BaseBean;

/**
 * 作者：zxg on 2016/10/18 16:57
 * 上传图片的返回值
 */
//{
//        "subject": {
//        "id": 56,
//        "fileName": "shopPayMentCode",
//        "fileSize": 73209,
//        "fileType": "image",
//        "owner": "pos",
//        "url": "http://192.168.1.118:8888/upload/pos/1190228673A34D0F9524BE31D42E511D.jpg",
//        "uniqueName": "1190228673A34D0F9524BE31D42E511D",
//        "extent": "jpg",
//        "content": null,
//        "createTime": 1476926153629
//        }
//        }
public class UpLoadPicBackBean extends BaseBean {

    /**
     * id : 56
     * fileName : shopPayMentCode
     * fileSize : 73209
     * fileType : image
     * owner : pos
     * url : http://192.168.1.118:8888/upload/pos/1190228673A34D0F9524BE31D42E511D.jpg
     * uniqueName : 1190228673A34D0F9524BE31D42E511D
     * extent : jpg
     * content : null
     * createTime : 1476926153629
     */

    private SubjectBean subject;

    public SubjectBean getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "UpLoadPicBackBean{" +
                "subject=" + subject +
                "} " + super.toString();
    }

    public void setSubject(SubjectBean subject) {
        this.subject = subject;
    }

    public static class SubjectBean {
        private int id;
        private String fileName;
        private int fileSize;
        private String fileType;
        private String owner;
        private String url;
        private String uniqueName;
        private String extent;
        private Object content;
        private long createTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public int getFileSize() {
            return fileSize;
        }

        public void setFileSize(int fileSize) {
            this.fileSize = fileSize;
        }

        public String getFileType() {
            return fileType;
        }

        public void setFileType(String fileType) {
            this.fileType = fileType;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUniqueName() {
            return uniqueName;
        }

        public void setUniqueName(String uniqueName) {
            this.uniqueName = uniqueName;
        }

        public String getExtent() {
            return extent;
        }

        public void setExtent(String extent) {
            this.extent = extent;
        }

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        @Override
        public String toString() {
            return "SubjectBean{" +
                    "content=" + content +
                    ", id=" + id +
                    ", fileName='" + fileName + '\'' +
                    ", fileSize=" + fileSize +
                    ", fileType='" + fileType + '\'' +
                    ", owner='" + owner + '\'' +
                    ", url='" + url + '\'' +
                    ", uniqueName='" + uniqueName + '\'' +
                    ", extent='" + extent + '\'' +
                    ", createTime=" + createTime +
                    '}';
        }
    }
}
