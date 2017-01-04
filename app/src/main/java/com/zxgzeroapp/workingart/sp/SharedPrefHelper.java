package com.zxgzeroapp.workingart.sp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 共享参数帮助类
 * 
 * @author Administrator
 * 
 */
public class SharedPrefHelper {
	/**
	 * SharedPreferences的名字
	 */
	private static final String SP_FILE_NAME = "APPLICATION_SP";
	private static SharedPrefHelper sharedPrefHelper = null;
	private static SharedPreferences sharedPreferences;


	public static synchronized SharedPrefHelper getInstance(Context context) {
		if (null == sharedPrefHelper) {
			sharedPrefHelper = new SharedPrefHelper(context);
		}
		return sharedPrefHelper;
	}

	private SharedPrefHelper(Context mContext) {
		sharedPreferences = mContext.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
	}

	/**
	 * 设置是否是第一次运行
	 *
	 * @param isFirst
	 */
	public void setIsFirstLaunch(boolean isFirst) {
		sharedPreferences.edit().putBoolean("isFirstLaunch", isFirst).commit();
	}

	/**
	 * 获取是否是第一次运行
	 *
	 * @return
	 */
	public boolean getIsFirstLaunch() {
		return sharedPreferences.getBoolean("isFirstLaunch", true);
	}
}
