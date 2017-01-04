package com.zxgzeroapp.workingart.http;

import android.util.Log;

import com.zxgzeroapp.workingart.base.BaseApi;
import com.zxgzeroapp.workingart.http.exception.ExceptionEngine;
import com.zxgzeroapp.workingart.mvplistener.OnHttpTaskListener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import rx.Subscriber;

/**
 * 作者：zxg on 2016/12/22 16:15
 */

public class NormalSubcribers<T> extends Subscriber<T> {
    //    回调接口
    private OnHttpTaskListener<T> mHttpOnNextListener;
    //    弱引用反正内存泄露
    private RxAppCompatActivity mActivity;

    /**
     * 构造
     *
     * @param api
     */
    public NormalSubcribers(BaseApi api) {
        this.mHttpOnNextListener = api.getListener();
        this.mActivity = api.getRxAppCompatActivity();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mHttpOnNextListener != null) {
            mHttpOnNextListener.onPreTask();
        }
//        Log.e("normal新开始", "新开始");
    }

    @Override
    public void onCompleted() {
        if (mHttpOnNextListener != null) {
            mHttpOnNextListener.onFinishTask();
        }
//        Log.e("normal新结束", "新结束");
    }

    @Override
    public void onError(Throwable e) {
        if (mHttpOnNextListener != null) {
            mHttpOnNextListener.onTaskError(e);
        }
        ExceptionEngine.handleException(e,mActivity);
//        Log.e("normal新错误", "新错误");
    }

    @Override
    public void onNext(T t) {
        if (mHttpOnNextListener != null) {
            mHttpOnNextListener.onSuccessTask(t);
        }else {
            Log.e("mHttpOnNextListener", "监听为空");
        }
//        Log.e("normal新数据", t.toString());
    }
}
