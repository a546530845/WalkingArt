package com.zxgzeroapp.workingart.http.api;

import com.zxgzeroapp.workingart.bean.request.LoginRequestBean;
import com.zxgzeroapp.workingart.base.BaseApi;
import com.zxgzeroapp.workingart.http.HttpService;
import com.zxgzeroapp.workingart.mvplistener.OnHttpTaskListener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.HashMap;

import rx.Observable;

/**
 * 测试数据
 * Created by WZG on 2016/7/16.
 */
public class LoginApi extends BaseApi {
    private LoginRequestBean mLoginRequestBean;
    /*任何你先要传递的参数*/
//    String xxxxx;
//    String xxxxx;
//    String xxxxx;
//    String xxxxx;


    /**
     * 默认初始化需要给定回调和rx周期类
     * 可以额外设置请求设置加载框显示，回调等（可扩展）
     * @param listener
     * @param rxAppCompatActivity
     */
    public <T> LoginApi(RxAppCompatActivity rxAppCompatActivity,LoginRequestBean mLoginRequestBean, OnHttpTaskListener<T> listener) {
        super(listener,rxAppCompatActivity);
        this.mLoginRequestBean = mLoginRequestBean;
    }



    @Override
    public Observable getObservable(HttpService methods) {
        HashMap<String,String> maps = new HashMap<>();
        maps.put("account",mLoginRequestBean.getmUesrName());
        maps.put("password",mLoginRequestBean.getmPassWord());
        maps.put("posCode",mLoginRequestBean.getmPosCode());
        return methods.LOGIN(maps);
    }
}
