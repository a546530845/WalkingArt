package com.zxgzeroapp.workingart.http.api;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.zxgzeroapp.workingart.base.BaseApi;
import com.zxgzeroapp.workingart.bean.request.FilmRequestBean;
import com.zxgzeroapp.workingart.http.HttpService;
import com.zxgzeroapp.workingart.mvplistener.OnHttpTaskListener;

import rx.Observable;

/**
 * 测试数据
 * Created by WZG on 2016/7/16.
 */
public class FilmApi extends BaseApi {
    private FilmRequestBean mFilmRequestBean;
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
    public <T> FilmApi(RxAppCompatActivity rxAppCompatActivity, FilmRequestBean mFilmRequestBean, OnHttpTaskListener<T> listener) {
        super(listener,rxAppCompatActivity);
        this.mFilmRequestBean = mFilmRequestBean;
    }



    @Override
    public Observable getObservable(HttpService methods) {
//        HashMap<String,String> maps = new HashMap<>();
//        maps.put("area",mFilmRequestBean.getArea());
//        maps.put("key",mFilmRequestBean.getKey());
//        if(!StringUtil.isNullOrEmpty(mFilmRequestBean.getDtype())){
//            maps.put("dtype",mFilmRequestBean.getDtype());
//        }

        return methods.FILMREVIEW(mFilmRequestBean);
    }
}
