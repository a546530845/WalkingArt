package com.zxgzeroapp.workingart.presenter.fragment;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.zxgzeroapp.workingart.bean.back.ConsTellMonth;
import com.zxgzeroapp.workingart.bean.request.ConstellationRequestBean;
import com.zxgzeroapp.workingart.http.Constant;
import com.zxgzeroapp.workingart.http.HttpManager;
import com.zxgzeroapp.workingart.http.api.ConsDayApi;
import com.zxgzeroapp.workingart.mvplistener.OnHttpTaskListener;
import com.zxgzeroapp.workingart.view.fragment.IConsMonthFgtView;


public class ConsMonthFgtPresenter {
    public IConsMonthFgtView mIConsMonthFgtView;

    public ConsMonthFgtPresenter(IConsMonthFgtView View) {
        this.mIConsMonthFgtView = View;
    }

    public void getConsTelltionMonthBack(RxAppCompatActivity mContext, ConstellationRequestBean mConstellationRequestBean) {

        ConsDayApi mConsDayApi = new ConsDayApi(mContext, mConstellationRequestBean, new OnHttpTaskListener<ConsTellMonth>() {
            @Override
            public void onPreTask() {
                mIConsMonthFgtView.ConsMonthPrepare();
            }

            @Override
            public void onTaskError(Throwable throwable) {
                mIConsMonthFgtView.ConsMonthError(throwable);
            }

            @Override
            public void onSuccessTask(ConsTellMonth bean) {
                mIConsMonthFgtView.ConsMonthSucess(bean);
            }

            @Override
            public void onFinishTask() {
                mIConsMonthFgtView.ConsMonthfinish();
            }

            @Override
            public void onCancel() {

            }
        });

        HttpManager.doHttpDeal(mConsDayApi, Constant.CONSTELLTIONDAY_BASE);


    }

}
