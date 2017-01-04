package com.zxgzeroapp.workingart.model;

import com.zxgzeroapp.workingart.bean.request.LoginRequestBean;
import com.zxgzeroapp.workingart.http.HttpManager;
import com.zxgzeroapp.workingart.http.api.LoginApi;
import com.zxgzeroapp.workingart.imodel.ILoginModel;
import com.zxgzeroapp.workingart.mvplistener.OnHttpTaskListener;
import com.zxgzeroapp.workingart.mvplistener.OnMVPHttpTaskListener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;


public class LoginModel implements ILoginModel {

    @Override
    public <T>void getLoginBackBean(RxAppCompatActivity mContext,LoginRequestBean mLoginRequestBean,
                                 final OnMVPHttpTaskListener<T> mvpHttpTaskListener) {
        // TODO Auto-generated method stub


        LoginApi mLoginApi = new LoginApi(mContext,mLoginRequestBean, new OnHttpTaskListener<T>() {
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

        HttpManager.doHttpDeal(mLoginApi);


    }


}
