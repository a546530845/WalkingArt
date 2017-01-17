package com.zxgzeroapp.workingart.http;

/**
 * 作者：zxg on 2016/9/30 11:56
 * 地址
 */
public class Constant {

    /**
     * 服务器名称
     */
//    private static final String APP_SERVER_NAME = "http://192.168.1.118:7998/pos-provider/";
//    /**
//     * 测试服务器
//     */
//    private static final String APP_SERVER_NAME = "http://192.168.1.119:7998/pos-provider/";
    /**
     //    /**
     //     * 域名外部服务器(预发布)
     //     */
//    private static final String APP_SERVER_NAME = "http://uat.dashufs.com/pos-provider/";
    /**
     * 生产服务器
     */
    public static final String APP_SERVER_NAME = "http://prod.dashufs.com/pos-provider/";

    //    public static final String APP_SERVER_NAME = "http://xxxxxxxxxxxxxxxx/pos-provider/";
    public static final String APP_VERSION = "getCurrentVersion?";
    public static final String LOGIN = "checkLogin?";
    public static final String UPLOAD_IMAGE = "user/updateHeadUrl";
    public static final String DOWNLOADURL = "downloadApp";
    /**
     * 电影票房
     */
    public static final String FILMREVIEW_BASE = "http://v.juhe.cn/boxoffice/";
    public static final String FILMREVIEW = "rank.php?";
}
