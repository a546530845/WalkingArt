package com.zxgzeroapp.workingart.activity.welcome;

import android.view.View;
import android.widget.TextView;

import com.zxgzeroapp.workingart.R;
import com.zxgzeroapp.workingart.base.BaseActivity;

/**
 * 作者：zxg on 2017/1/6 16:13
 * 星座页面
 */

public class Constellation extends BaseActivity {
    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void setLayoutView() {
        setContentView(R.layout.constellation_aty);
    }

    @Override
    protected void initTitleView() {
        title_left = (TextView) findViewById(R.id.title_left);
        title_name = (TextView) findViewById(R.id.title_name);
        title_right = (TextView) findViewById(R.id.title_right);

        title_name.setText(getResources().getString(R.string.main_aty_constellation));
        title_right.setVisibility(View.GONE);
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
    public void onClickEvent(View view) {
        switch (view.getId()) {
            case R.id.title_left:
                turnToBack();
                break;
        }
    }
}
