package com.zxgzeroapp.workingart.presenter.fragment;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.zxgzeroapp.workingart.bean.back.ConsTellToday;
import com.zxgzeroapp.workingart.bean.request.ConstellationRequestBean;
import com.zxgzeroapp.workingart.http.Constant;
import com.zxgzeroapp.workingart.http.HttpManager;
import com.zxgzeroapp.workingart.http.api.ConsDayApi;
import com.zxgzeroapp.workingart.mvplistener.OnHttpTaskListener;
import com.zxgzeroapp.workingart.view.fragment.IConsDayFgtView;


public class ConsDayFgtPresenter {
    public IConsDayFgtView mIConsDayFgtView;

    public ConsDayFgtPresenter(IConsDayFgtView View) {
        this.mIConsDayFgtView = View;
    }

    public void getConsTelltionDayBack(RxAppCompatActivity mContext, ConstellationRequestBean mConstellationRequestBean) {

        ConsDayApi mConsDayApi = new ConsDayApi(mContext, mConstellationRequestBean, new OnHttpTaskListener<ConsTellToday>() {
            @Override
            public void onPreTask() {
                mIConsDayFgtView.ConsDayPrepare();
            }

            @Override
            public void onTaskError(Throwable throwable) {
                mIConsDayFgtView.ConsDayError(throwable);
            }

            @Override
            public void onSuccessTask(ConsTellToday bean) {
                mIConsDayFgtView.ConsDaySucess(bean);
            }

            @Override
            public void onFinishTask() {
                mIConsDayFgtView.ConsDayfinish();
            }

            @Override
            public void onCancel() {

            }
        });

        HttpManager.doHttpDeal(mConsDayApi, Constant.CONSTELLTIONDAY_BASE);


    }

}
