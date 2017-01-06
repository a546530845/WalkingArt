package com.zxgzeroapp.workingart.base;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import cn.jiguang.analytics.android.api.JAnalyticsInterface;


public class BaseFragment extends Fragment {
    private static final String TAG="BaseFragment";
    //0在onResume和onPause中调用(正常replace切换模式)。
    //1在onHiddenChanged中调用(show/hide切换模式)。
    //2在setUserVisibleHint中调用(viewpage嵌套模式)
    protected int apiCallType = 2;

    private boolean isAttached = false;
    //apiCallType为2时是否显示的标识
    private boolean isVisible;
    //apiCallType为1时是否显示的标识
    private boolean isHidden;
    public void setApiCallType(int callType){
        apiCallType = callType;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(apiCallType==2&&isAttached){
            isVisible = isVisibleToUser;
            Log.e(TAG,this.getClass().getCanonicalName()+" isVisibleToUser:"+isVisibleToUser);
            if(isVisibleToUser){
                /**
                 * 页面起始（注意： 每个Fragment中都需要添加，如果有继承的父Fragment中已经添加了该调用，那么子Fragment中务必不能添加）
                 * 如果FragmentActivity包含了几个全页面的fragment，那么可以在fragment里面加入就可以了，这里可以不加入
                 */
                JAnalyticsInterface.onPageStart(getActivity(),this.getClass().getCanonicalName());
            }else{
                /**
                 * 页面结束（注意： 每个Fragment中都需要添加，如果有继承的父Fragment中已经添加了该调用，那么子Fragment中务必不能添加）
                 * 如果FragmentActivity包含了几个全页面的fragment，那么可以在fragment里面加入就可以了，这里可以不加入。
                 */
                JAnalyticsInterface.onPageEnd(getActivity(),this.getClass().getCanonicalName());
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(getActivity());
        isAttached = true;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        isAttached = false;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(apiCallType==1){
            isHidden = hidden;
            Log.d(TAG,this.getClass().getCanonicalName()+" hidden:"+hidden);
            if(hidden){
                JAnalyticsInterface.onPageEnd(getActivity(),this.getClass().getCanonicalName());
            }else{
                JAnalyticsInterface.onPageStart(getActivity(),this.getClass().getCanonicalName());
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,this.getClass().getCanonicalName()+" onResume,apiCallType:"+apiCallType+",isVisible:"+isVisible+",isHidden:"+isHidden);
        if (apiCallType == 0) {
            JAnalyticsInterface.onPageStart(getActivity(),this.getClass().getCanonicalName());
        }else if(apiCallType==2&&isVisible){
            JAnalyticsInterface.onPageStart(getActivity(),this.getClass().getCanonicalName());
        }else if(apiCallType==1&&!isHidden){
            JAnalyticsInterface.onPageStart(getActivity(),this.getClass().getCanonicalName());
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,this.getClass().getCanonicalName()+" onPause");
        JAnalyticsInterface.onPageEnd(getActivity(),this.getClass().getCanonicalName());
    }
}
