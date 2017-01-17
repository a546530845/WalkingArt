package com.zxgzeroapp.workingart.model.fgtmodel;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.zxgzeroapp.workingart.bean.request.FilmRequestBean;
import com.zxgzeroapp.workingart.http.Constant;
import com.zxgzeroapp.workingart.http.HttpManager;
import com.zxgzeroapp.workingart.http.api.FilmApi;
import com.zxgzeroapp.workingart.imodel.fgtimodel.IFilmModel;
import com.zxgzeroapp.workingart.mvplistener.OnHttpTaskListener;
import com.zxgzeroapp.workingart.mvplistener.OnMVPHttpTaskListener;


public class FilmModel implements IFilmModel {

    @Override
    public <T>void getFilmBackBean(RxAppCompatActivity mContext,FilmRequestBean mFilmRequestBean,
                                 final OnMVPHttpTaskListener<T> mvpHttpTaskListener) {
        // TODO Auto-generated method stub


        FilmApi mFilmApi = new FilmApi(mContext,mFilmRequestBean, new OnHttpTaskListener<T>() {
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

        HttpManager.doHttpDeal(mFilmApi, Constant.FILMREVIEW_BASE);


    }


}
