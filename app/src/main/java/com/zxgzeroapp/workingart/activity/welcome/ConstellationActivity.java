package com.zxgzeroapp.workingart.activity.welcome;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.zxgzeroapp.workingart.R;
import com.zxgzeroapp.workingart.adapter.TempFragmentpAdapter;
import com.zxgzeroapp.workingart.base.BaseActivity;
import com.zxgzeroapp.workingart.fragment.DayFragment;
import com.zxgzeroapp.workingart.fragment.MonthFragment;
import com.zxgzeroapp.workingart.fragment.WeekFragment;
import com.zxgzeroapp.workingart.fragment.YearFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：zxg on 2017/1/6 16:13
 * 星座页面
 */

public class ConstellationActivity extends BaseActivity {
    private ViewPager constelltion_vp;
    private RadioGroup constelltion_rg;
    private TempFragmentpAdapter mAdapter;
    private List<Fragment> mColumnList;
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

        title_name.setText(getResources().getString(R.string.constellation_aty_title));
        title_right.setVisibility(View.GONE);
    }

    @Override
    protected void initView() {
        constelltion_vp = (ViewPager) findViewById(R.id.constelltion_vp);
        constelltion_rg = (RadioGroup) findViewById(R.id.constelltion_rg);
    }

    @Override
    protected void initListener() {
        constelltion_vp.addOnPageChangeListener(new MyOnPageChangeListener());
        constelltion_rg.setOnCheckedChangeListener(new MyCheckChanggeListener());
    }

    @Override
    protected void initData() {
        constelltion_vp.setCurrentItem(0);
        constelltion_rg.check(R.id.film_rb_inland);

        mColumnList = new ArrayList<>();
        mColumnList.add(new DayFragment());
        mColumnList.add(new WeekFragment());
        mColumnList.add(new MonthFragment());
        mColumnList.add(new YearFragment());

        mAdapter = new TempFragmentpAdapter(getSupportFragmentManager(), mColumnList);
        constelltion_vp.setAdapter(mAdapter);
//        film_vp.setOffscreenPageLimit(1);//当前界面左侧或者右侧缓存的界面数


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
                case R.id.constelltion_rb_day:
                    constelltion_vp.setCurrentItem(0);
                    break;
                case R.id.constelltion_rb_week:
                    constelltion_vp.setCurrentItem(1);
                    break;
                case R.id.constelltion_rb_month:
                    constelltion_vp.setCurrentItem(2);
                    break;
                case R.id.constelltion_rb_year:
                    constelltion_vp.setCurrentItem(3);
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
                    constelltion_rg.check(R.id.constelltion_rb_day);
                    break;
                case 1:
                    constelltion_rg.check(R.id.constelltion_rb_week);
                    break;
                case 2:
                    constelltion_rg.check(R.id.constelltion_rb_month);
                    break;
                case 3:
                    constelltion_rg.check(R.id.constelltion_rb_year);
                    break;
            }
        }

    }
}
