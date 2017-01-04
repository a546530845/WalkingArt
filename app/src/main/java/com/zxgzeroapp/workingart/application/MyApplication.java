package com.zxgzeroapp.workingart.application;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.zxgzeroapp.workingart.exceptionhandler.CrashHandler;
import com.zxgzeroapp.workingart.sp.SharedPrefHelper;

/**
 * 作者：zxg on 2016/9/29 17:15
 */
public class MyApplication extends Application {
    public static boolean isAppUpgrading = false;
    public static SharedPrefHelper mSharedPrefHelper;
    public static SQLiteDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();

        mSharedPrefHelper = SharedPrefHelper.getInstance(this);
        init();


    }
    /**
     * 初始化CrashHandler为程序的默认处理器,用于错误处理重启
     */
    public void init() {
        CrashHandler crashHandler = new CrashHandler(this);
        Thread.setDefaultUncaughtExceptionHandler(crashHandler);
    }

}
