package com.zxgzeroapp.workingart.activity.welcome;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.zxgzeroapp.workingart.R;
import com.zxgzeroapp.workingart.adapter.TempAdapter;
import com.zxgzeroapp.workingart.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：zxg on 2017/1/6 16:12
 * 电影票房页面
 */

public class FilmReviewActivity extends BaseActivity {
    private ViewPager film_vp;
    private RadioGroup film_rg;
    private TempAdapter mAdapter;
    private List<String> mColumnList;
    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void setLayoutView() {
        setContentView(R.layout.filmreview_aty);
    }

    @Override
    protected void initTitleView() {
        title_left = (TextView) findViewById(R.id.title_left);
        title_name = (TextView) findViewById(R.id.title_name);
        title_right = (TextView) findViewById(R.id.title_right);

        title_name.setText(getResources().getString(R.string.main_aty_filmreview));
        title_right.setVisibility(View.GONE);
    }

    @Override
    protected void initView() {
        film_vp = (ViewPager) findViewById(R.id.film_vp);
        film_rg = (RadioGroup) findViewById(R.id.film_rg);
    }

    @Override
    protected void initListener() {
        film_vp.addOnPageChangeListener(new MyOnPageChangeListener());
        film_rg.setOnCheckedChangeListener(new MyCheckChanggeListener());
    }

    @Override
    protected void initData() {
        film_vp.setCurrentItem(0);
        film_rg.check(R.id.film_rb_inland);

        mColumnList = new ArrayList<>();
        mColumnList.add("CN");
        mColumnList.add("US");
        mColumnList.add("HK");

        mAdapter = new TempAdapter(getSupportFragmentManager(), mColumnList);
        film_vp.setAdapter(mAdapter);
        film_vp.setOffscreenPageLimit(1);//当前界面左侧或者右侧缓存的界面数


    }

    public void onClickEvent(View view) {
        switch (view.getId()) {
            case R.id.title_left:
                turnToBack();
                break;
        }
    }
    class MyCheckChanggeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.film_rb_inland:
                    film_vp.setCurrentItem(0);
                    break;
                case R.id.film_rb_north:
                    film_vp.setCurrentItem(1);
                    break;
                case R.id.film_rb_hk:
                    film_vp.setCurrentItem(2);
                    break;
            }

        }
    }
    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
//            Log.d("StateChanged", "onPageScrollState");
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
//            Log.d("onPageScrolled", "onPageScrolled");
        }

        @Override
        public void onPageSelected(int arg0) {
            Log.d("onPageSelected", "onPageSelected" + arg0);
            switch (arg0){
                case 0:
                    film_rg.check(R.id.film_rb_inland);
                    break;
                case 1:
                    film_rg.check(R.id.film_rb_north);
                    break;
                case 2:
                    film_rg.check(R.id.film_rb_hk);
                    break;
            }
        }

    }
}
