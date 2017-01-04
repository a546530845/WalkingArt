package com.zxgzeroapp.workingart.model;

import com.zxgzeroapp.workingart.bean.request.AppUpdateRequestBean;
import com.zxgzeroapp.workingart.http.HttpManager;
import com.zxgzeroapp.workingart.http.api.APPUpdateApi;
import com.zxgzeroapp.workingart.imodel.IAppUpdateModel;
import com.zxgzeroapp.workingart.mvplistener.OnHttpTaskListener;
import com.zxgzeroapp.workingart.mvplistener.OnMVPHttpTaskListener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;


public class AppUpdateModel implements IAppUpdateModel {

    @Override
    public <T>void getAppUpDateBackBean(RxAppCompatActivity mContext,
                                 final OnMVPHttpTaskListener<T> mvpHttpTaskListener) {
        // TODO Auto-generated method stub
        AppUpdateRequestBean mAppUpdateRequestBean = new AppUpdateRequestBean();


        APPUpdateApi mAppUpdateApi = new APPUpdateApi(mContext, new OnHttpTaskListener<T>() {
            @Override
            public void onPreTask() {
                mvpHttpTaskListener.onPreTask();
            }

            @Override
            public void onTaskError(Throwable throwable) {
                mvpHttpTaskListener.onTaskError(throwable);
            }

            @Override
            public void onSuccessTask(T bean) {
                mvpHttpTaskListener.onSuccessTask(bean);
            }

            @Override
            public void onFinishTask() {
                mvpHttpTaskListener.onFinishTask();
            }

            @Override
            public void onCancel() {
                mvpHttpTaskListener.onCancel();
            }
        });

        HttpManager.doHttpDeal(mAppUpdateApi);


    }


}
