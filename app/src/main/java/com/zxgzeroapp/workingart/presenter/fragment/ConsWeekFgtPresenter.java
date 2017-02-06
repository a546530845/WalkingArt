package com.zxgzeroapp.workingart.presenter.fragment;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.zxgzeroapp.workingart.bean.back.ConsTellWeek;
import com.zxgzeroapp.workingart.bean.request.ConstellationRequestBean;
import com.zxgzeroapp.workingart.http.Constant;
import com.zxgzeroapp.workingart.http.HttpManager;
import com.zxgzeroapp.workingart.http.api.ConsDayApi;
import com.zxgzeroapp.workingart.mvplistener.OnHttpTaskListener;
import com.zxgzeroapp.workingart.view.fragment.IConsWeekFgtView;


public class ConsWeekFgtPresenter {
    public IConsWeekFgtView mIConsWeekFgtView;

    public ConsWeekFgtPresenter(IConsWeekFgtView View) {
        this.mIConsWeekFgtView = View;
    }

    public void getConsTelltionWeekBack(RxAppCompatActivity mContext, ConstellationRequestBean mConstellationRequestBean) {

        ConsDayApi mConsDayApi = new ConsDayApi(mContext, mConstellationRequestBean, new OnHttpTaskListener<ConsTellWeek>() {
            @Override
            public void onPreTask() {
                mIConsWeekFgtView.ConsWeekPrepare();
            }

            @Override
            public void onTaskError(Throwable throwable) {
                mIConsWeekFgtView.ConsWeekError(throwable);
            }

            @Override
            public void onSuccessTask(ConsTellWeek bean) {
                mIConsWeekFgtView.ConsWeekSucess(bean);
            }

            @Override
            public void onFinishTask() {
                mIConsWeekFgtView.ConsWeekfinish();
            }

            @Override
            public void onCancel() {

            }
        });

        HttpManager.doHttpDeal(mConsDayApi, Constant.CONSTELLTIONDAY_BASE);


    }

}
