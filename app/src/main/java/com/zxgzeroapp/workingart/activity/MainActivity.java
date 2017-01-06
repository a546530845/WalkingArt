package com.zxgzeroapp.workingart.activity;

import android.view.View;

import com.zxgzeroapp.workingart.R;
import com.zxgzeroapp.workingart.base.BaseActivity;
import com.zxgzeroapp.workingart.jpush.JEventUtils;

/**
 * 作者：zxg on 2017/1/3 16:12
 */

public class MainActivity extends BaseActivity {
    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void setLayoutView() {
        setContentView(R.layout.main_aty);

    }

    @Override
    protected void initTitleView() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
    public void ClickEvent(View view) {
        switch (view.getId()) {
            case R.id.go:
                JEventUtils.onCountEvent(this);
                break;
            case R.id.down:
                JEventUtils.onLoginEvent(this);
                break;
        }
    }
}
