package com.zxgzeroapp.workingart.presenter.fragment;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.zxgzeroapp.workingart.bean.back.ConsTellYear;
import com.zxgzeroapp.workingart.bean.request.ConstellationRequestBean;
import com.zxgzeroapp.workingart.http.Constant;
import com.zxgzeroapp.workingart.http.HttpManager;
import com.zxgzeroapp.workingart.http.api.ConsDayApi;
import com.zxgzeroapp.workingart.mvplistener.OnHttpTaskListener;
import com.zxgzeroapp.workingart.view.fragment.IConsYearFgtView;


public class ConsYearFgtPresenter {
    public IConsYearFgtView mIConsYearFgtView;

    public ConsYearFgtPresenter(IConsYearFgtView View) {
        this.mIConsYearFgtView = View;
    }

    public void getConsTelltionYearBack(RxAppCompatActivity mContext, ConstellationRequestBean mConstellationRequestBean) {

        ConsDayApi mConsDayApi = new ConsDayApi(mContext, mConstellationRequestBean, new OnHttpTaskListener<ConsTellYear>() {
            @Override
            public void onPreTask() {
                mIConsYearFgtView.ConsYearPrepare();
            }

            @Override
            public void onTaskError(Throwable throwable) {
                mIConsYearFgtView.ConsYearError(throwable);
            }

            @Override
            public void onSuccessTask(ConsTellYear bean) {
                mIConsYearFgtView.ConsYearSucess(bean);
            }

            @Override
            public void onFinishTask() {
                mIConsYearFgtView.ConsYearfinish();
            }

            @Override
            public void onCancel() {

            }
        });

        HttpManager.doHttpDeal(mConsDayApi, Constant.CONSTELLTIONDAY_BASE);


    }

}
