package com.zxgzeroapp.workingart.activity;

import android.view.View;

import com.zxgzeroapp.workingart.R;
import com.zxgzeroapp.workingart.activity.welcome.ConstellationActivity;
import com.zxgzeroapp.workingart.activity.welcome.FilmReviewActivity;
import com.zxgzeroapp.workingart.activity.welcome.JokeActivity;
import com.zxgzeroapp.workingart.activity.welcome.WeaTherActivity;
import com.zxgzeroapp.workingart.base.BaseActivity;
import com.zxgzeroapp.workingart.jpush.JEventUtils;
import com.zxgzeroapp.workingart.utils.SkipActivityUtils;
import com.zxgzeroapp.workingart.utils.ToastUtil;

import java.util.HashMap;
import java.util.Map;

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
    public void onClickEvent(View view) {
        switch (view.getId()) {
            case R.id.main_aty_weather:
                Map<String, String> extraMap = new HashMap<String, String>();
                extraMap.put("天气", "查看天气");
                JEventUtils.onCountEvent(this,"WeatherId",extraMap);
                SkipActivityUtils.skipActivity(mContext, WeaTherActivity.class);
                break;
            case R.id.main_aty_constellation:
                Map<String, String> extraMap_constellation = new HashMap<String, String>();
                extraMap_constellation.put("星座", "查看星座");
                JEventUtils.onCountEvent(this,"ConstellationId",extraMap_constellation);
                SkipActivityUtils.skipActivity(mContext, ConstellationActivity.class);
                break;
            case R.id.main_aty_joke:
                Map<String, String> extraMap_joke = new HashMap<String, String>();
                extraMap_joke.put("笑话", "查看笑话");
                JEventUtils.onCountEvent(this,"JokeId",extraMap_joke);
                SkipActivityUtils.skipActivity(mContext, JokeActivity.class);
                break;
            case R.id.main_aty_filmreview:
                Map<String, String> extraMap_filereview = new HashMap<String, String>();
                extraMap_filereview.put("影评", "查看影评");
                JEventUtils.onCountEvent(this,"FilmreviewId",extraMap_filereview);
                SkipActivityUtils.skipActivity(mContext, FilmReviewActivity.class);
                break;
            case R.id.main_aty_add:
                Map<String, String> extraMap_add = new HashMap<String, String>();
                extraMap_add.put("更多", "查看更多");
                JEventUtils.onCountEvent(this,"AddId",extraMap_add);
                ToastUtil.showShort(mContext,getResources().getString(R.string.main_aty_more));
                break;
        }
    }
}
