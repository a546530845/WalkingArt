package com.zxgzeroapp.workingart.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * 作者：zxg on 2017/1/5 15:23
 * 设置scrollView 不能滑动
 */

public class MyScrollView extends ScrollView {
    public MyScrollView(Context context) {
        super(context);
        setCantScrollView();
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCantScrollView();
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCantScrollView();
    }
    public void setCantScrollView(){
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

}
