package com.zxgzeroapp.workingart.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zxgzeroapp.workingart.fragment.FilmReviewFragment;
import com.zxgzeroapp.workingart.utils.LogUtil;

import java.util.List;

//public class TempAdapter extends FragmentPagerAdapter {
// 改成继承以下Adapter,才能保存状态，要不然rootView会remove,导致空指针，在statePagerAdapter 中缓存几个页面，其他页面就销毁了，在PageAdapter中，fragment不销毁，但是会remove rootView;
public class TempAdapter extends FragmentStatePagerAdapter {

    private List<String> mlist;
    private FragmentManager fm;


    public TempAdapter(FragmentManager fm, List<String> list) {
        super(fm);
        this.fm = fm;
        this.mlist = list;
        LogUtil.d("TempAdapter", "        _________          " + mlist.toString());
    }

    @Override
    public Fragment getItem(int position) {
        LogUtil.i("TempAdapter", "getItem");
        Fragment item = null;
        item = FilmReviewFragment.newInstance(mlist.get(position));

        return item;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }


}
