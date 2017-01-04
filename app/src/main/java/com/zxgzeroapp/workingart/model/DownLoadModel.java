package com.zxgzeroapp.workingart.model;

import com.zxgzeroapp.workingart.bean.request.DownLoadAppRequestBean;
import com.zxgzeroapp.workingart.http.HttpManager;
import com.zxgzeroapp.workingart.http.api.DownLoadApi;
import com.zxgzeroapp.workingart.http.download.DownloadProgressListener;
import com.zxgzeroapp.workingart.imodel.IDownLoadModel;
import com.zxgzeroapp.workingart.mvplistener.OnHttpTaskListener;
import com.zxgzeroapp.workingart.mvplistener.OnMVPUploadHttpTaskListener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;


public class DownLoadModel implements IDownLoadModel {

    @Override
    public <T> void downLoadBackBean(RxAppCompatActivity mContext, DownLoadAppRequestBean mDownLoadAppRequestBean, final OnMVPUploadHttpTaskListener<T> mvpHttpUploadTaskListener) {
        // TODO Auto-generated method stub

        DownloadProgressListener mDownloadProgressListener = new DownloadProgressListener() {
            @Override
            public void update(long bytesRead, long contentLength, boolean done) {
                mvpHttpUploadTaskListener.onProgress(bytesRead, contentLength);
            }
        };

        DownLoadApi mDownLoadApi = new DownLoadApi(mContext, mDownLoadAppRequestBean, new OnHttpTaskListener<T>() {
            @Override
            public void onPreTask() {
                mvpHttpUploadTaskListener.onPreTask();
            }

            @Override
            public void onTaskError(Throwable throwable) {
                mvpHttpUploadTaskListener.onTaskError(throwable);
            }

            @Override
            public void onSuccessTask(T bean) {
                mvpHttpUploadTaskListener.onSuccessTask(bean);
            }

            @Override
            public void onFinishTask() {
                mvpHttpUploadTaskListener.onFinishTask();
            }

            @Override
            public void onCancel() {
                mvpHttpUploadTaskListener.onCancel();
            }
        });
        mDownLoadApi.setmDownloadProgressListener(mDownloadProgressListener);

        HttpManager.doHttpDealForDownLoadApk(mDownLoadApi);


    }


}
