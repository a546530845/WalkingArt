package com.zxgzeroapp.workingart.application;

import android.app.Application;

import com.zxgzeroapp.workingart.exceptionhandler.CrashHandler;
import com.zxgzeroapp.workingart.jpush.JpushNotificationUtils;
import com.zxgzeroapp.workingart.sp.SharedPrefHelper;

import cn.jpush.android.api.JPushInterface;

/**
 * 作者：zxg on 2016/9/29 17:15
 */
public class MyApplication extends Application {
    public static boolean isAppUpgrading = false;
    public static SharedPrefHelper mSharedPrefHelper;

    @Override
    public void onCreate() {
        super.onCreate();

        mSharedPrefHelper = SharedPrefHelper.getInstance(this);
        init();

        JPushInterface.setDebugMode(false);
        JPushInterface.init(this);
        JpushNotificationUtils.setDiyStyleCustom(this.getApplicationContext());


    }
    /**
     * 初始化CrashHandler为程序的默认处理器,用于错误处理重启
     */
    public void init() {
        CrashHandler crashHandler = new CrashHandler(this);
        Thread.setDefaultUncaughtExceptionHandler(crashHandler);
    }

}
