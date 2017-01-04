package com.zxgzeroapp.workingart.activity.welcome;

import android.content.Intent;
import android.os.Handler;
import android.view.View;

import com.zxgzeroapp.workingart.R;
import com.zxgzeroapp.workingart.activity.MainActivity;
import com.zxgzeroapp.workingart.base.BaseActivity;
import com.zxgzeroapp.workingart.sp.SharedPrefHelper;


public class WelcomeActivity extends BaseActivity {
    private String TAG = "WelcomeActivity";
    private SharedPrefHelper sharedPreferceHelper;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 0:
                    if (sharedPreferceHelper.getIsFirstLaunch()) {
                        startActivity(new Intent(WelcomeActivity.this,
                                GuideActivity.class));
                        finish();
                    } else {
                        startActivity(new Intent(WelcomeActivity.this,
                                MainActivity.class));
                        finish();
                    }
                    break;
            }
        }

        ;
    };

    public void setStatusbar() {
        //重写方法，不设置bars
    }

    @Override
    protected void beforeInitView() {
        sharedPreferceHelper = SharedPrefHelper.getInstance(this);
    }

    @Override
    protected void setLayoutView() {
        setContentView(R.layout.welcome_aty);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    @Override
    protected void initTitleView() {

    }

    @Override
    protected void initView() {
        mHandler.sendEmptyMessageDelayed(0, 2000);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
