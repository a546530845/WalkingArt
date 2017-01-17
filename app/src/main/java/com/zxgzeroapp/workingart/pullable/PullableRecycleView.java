package com.zxgzeroapp.workingart.pullable;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * 作者：zxg on 2017/1/10 09:59
 */

public class PullableRecycleView extends RecyclerView implements Pullable{
    public PullableRecycleView(Context context) {
        super(context);
    }

    public PullableRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        addItemDecoration(new DividerLine(context,attrs));
    }

    public PullableRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addItemDecoration(new DividerLine(context,attrs));
    }

    @Override
    public boolean canPullDown()
    {
        if (getLayoutManager().getItemCount() == 0)
        {
            // 没有item的时候也可以下拉刷新
            return true;
        } else if (((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition() == 0
                && getChildAt(0).getTop() >= 0)
        {
            // 滑到ListView的顶部了
            return true;
        } else
            return false;
    }

    @Override
    public boolean canPullUp()
    {
//        if (getLayoutManager().getItemCount() == 0)
//        {
//            // 没有item的时候也可以上拉加载
//            return true;
//        } else if (((LinearLayoutManager) getLayoutManager()).findLastVisibleItemPosition() == (getLayoutManager().getItemCount() - 1))
//        {
//            // 滑到底部了
//            if (getChildAt(((LinearLayoutManager) getLayoutManager()).findLastVisibleItemPosition() - ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition()) != null
//                    && getChildAt(
//                ((LinearLayoutManager) getLayoutManager()).findLastVisibleItemPosition()
//                            - ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition()).getBottom() <= getMeasuredHeight())
//                return true;
//        }
        return false;
    }
}
