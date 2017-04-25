package com.zxgzeroapp.workingart.jpush;

import android.app.Notification;
import android.content.Context;
import android.widget.Toast;

import com.zxgzeroapp.workingart.R;
import com.zxgzeroapp.workingart.utils.LogUtil;

import cn.jpush.android.api.BasicPushNotificationBuilder;
import cn.jpush.android.api.CustomPushNotificationBuilder;
import cn.jpush.android.api.JPushInterface;

/**
 * 作者：zxg on 2017/1/5 16:22
 * 设置jpush notification style
 */

public class JpushNotificationUtils {
    /**
     *设置通知提示方式 - 基础属性
     */
    public static void setNotifiCationStyleBasic(Context mContext){
        BasicPushNotificationBuilder builder = new BasicPushNotificationBuilder(mContext);
        builder.statusBarDrawable = R.mipmap.ic_launcher;
        builder.notificationFlags = Notification.FLAG_AUTO_CANCEL;  //设置为点击后自动消失
        builder.notificationDefaults = Notification.DEFAULT_SOUND;  //设置为铃声（ Notification.DEFAULT_SOUND）或者震动（ Notification.DEFAULT_VIBRATE）
        JPushInterface.setDefaultPushNotificationBuilder(builder);
        Toast.makeText(mContext, "基础通知设置成功", Toast.LENGTH_SHORT).show();
    }
    /**
     *设置通知栏样式 - 定义通知栏Layout
     */
    public static void  setDiyStyleCustom(Context mContext){
        CustomPushNotificationBuilder builder = new CustomPushNotificationBuilder(mContext,R.layout.customer_notitfication_layout,R.id.icon, R.id.title, R.id.text);
        builder.layoutIconDrawable = R.mipmap.ic_launcher;
        builder.statusBarDrawable = R.mipmap.ic_launcher;
        builder.developerArg0 = "developerArg2";
        JPushInterface.setPushNotificationBuilder(1, builder);
        Toast.makeText(mContext,"自定义设置成功", Toast.LENGTH_SHORT).show();
        LogUtil.d("JpushNotificationUtils","通知栏自定义成功");
    }
}
