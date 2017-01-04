package com.zxgzeroapp.workingart.base;

import com.zxgzeroapp.workingart.http.Constant;
import com.zxgzeroapp.workingart.http.HttpService;
import com.zxgzeroapp.workingart.mvplistener.OnHttpTaskListener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import rx.Observable;

/**
 * 请求数据统一封装类
 * Created by WZG on 2016/7/16.
 */
public abstract class BaseApi<T> {
    //rx生命周期管理
    private RxAppCompatActivity rxAppCompatActivity;
    /*回调*/
    private OnHttpTaskListener listener;
    /*基础url*/
    private  String baseUrl= Constant.APP_SERVER_NAME;
    /*超时时间-默认6秒*/
    private int connectionTime = 10;

    public BaseApi(OnHttpTaskListener listener, RxAppCompatActivity rxAppCompatActivity) {
        setListener(listener);
        setRxAppCompatActivity(rxAppCompatActivity);
    }

    /**
     * 设置参数
     *
     * @param methods
     * @return
     */
    public abstract Observable getObservable(HttpService methods);




    public int getConnectionTime() {
        return connectionTime;
    }

    public void setConnectionTime(int connectionTime) {
        this.connectionTime = connectionTime;
    }


    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }


    public void setRxAppCompatActivity(RxAppCompatActivity rxAppCompatActivity) {
        this.rxAppCompatActivity =rxAppCompatActivity ;
    }


    public OnHttpTaskListener getListener() {
        return listener;
    }

    public void setListener(OnHttpTaskListener listener) {
        this.listener = listener;
    }

    /*
     * 获取当前rx生命周期
     * @return
     */
    public RxAppCompatActivity getRxAppCompatActivity() {
        return rxAppCompatActivity;
    }

}
