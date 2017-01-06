package com.zxgzeroapp.workingart.activity.welcome;

import android.view.View;
import android.widget.TextView;

import com.zxgzeroapp.workingart.R;
import com.zxgzeroapp.workingart.base.BaseActivity;

/**
 * 作者：zxg on 2017/1/6 16:12
 * 笑话页面
 */

public class JokeActivity extends BaseActivity {
    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void setLayoutView() {
        setContentView(R.layout.joke_aty);

    }

    @Override
    protected void initTitleView() {
        title_left = (TextView) findViewById(R.id.title_left);
        title_name = (TextView) findViewById(R.id.title_name);
        title_right = (TextView) findViewById(R.id.title_right);

        title_name.setText(getResources().getString(R.string.main_aty_joke));
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
