package com.zxgzeroapp.workingart.http.api;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.zxgzeroapp.workingart.base.BaseApi;
import com.zxgzeroapp.workingart.bean.request.ConstellationRequestBean;
import com.zxgzeroapp.workingart.http.HttpService;
import com.zxgzeroapp.workingart.mvplistener.OnHttpTaskListener;

import rx.Observable;

/**
 * 测试数据
 * Created by WZG on 2016/7/16.
 */
public class ConsWeekApi extends BaseApi {
    private ConstellationRequestBean mConstellationRequestBean;
    /*任何你先要传递的参数*/
//    String xxxxx;
//    String xxxxx;
//    String xxxxx;
//    String xxxxx;


    /**
     * 默认初始化需要给定回调和rx周期类
     * 可以额外设置请求设置加载框显示，回调等（可扩展）
     *
     * @param listener
     * @param rxAppCompatActivity
     */
    public <T> ConsWeekApi(RxAppCompatActivity rxAppCompatActivity, ConstellationRequestBean mConstellationRequestBean, OnHttpTaskListener<T> listener) {
        super(listener, rxAppCompatActivity);
        this.mConstellationRequestBean = mConstellationRequestBean;
    }


    @Override
    public Observable getObservable(HttpService methods) {
        switch (mConstellationRequestBean.getConsName()) {
            case "today":
                return methods.CONSTELLTIONDAY(mConstellationRequestBean);
            case "week":
                return methods.CONSTELLTIONWEEK(mConstellationRequestBean);
            case "month":
                return methods.CONSTELLTIONMONTH(mConstellationRequestBean);
            case "year":
                return methods.CONSTELLTIONYEAR(mConstellationRequestBean);

        }
        return methods.CONSTELLTIONDAY(mConstellationRequestBean);
    }
}
