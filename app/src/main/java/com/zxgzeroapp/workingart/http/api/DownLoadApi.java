package com.zxgzeroapp.workingart.http.api;

import com.zxgzeroapp.workingart.bean.request.DownLoadAppRequestBean;
import com.zxgzeroapp.workingart.base.BaseApi;
import com.zxgzeroapp.workingart.http.HttpService;
import com.zxgzeroapp.workingart.http.download.DownloadProgressListener;
import com.zxgzeroapp.workingart.mvplistener.OnHttpTaskListener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.HashMap;

import rx.Observable;

/**
 * 上传请求api
 * Created by WZG on 2016/10/20.
 */

public class DownLoadApi<T> extends BaseApi<T> {
    /**
     * 需要上传的参数
     */
    public DownLoadAppRequestBean mDownLoadAppRequestBean;

    private DownloadProgressListener mDownloadProgressListener;

    public DownloadProgressListener getmDownloadProgressListener() {
        return mDownloadProgressListener;
    }

    public void setmDownloadProgressListener(DownloadProgressListener mDownloadProgressListener) {
        this.mDownloadProgressListener = mDownloadProgressListener;
    }

    public DownLoadAppRequestBean getmDownLoadAppRequestBean() {
        return mDownLoadAppRequestBean;
    }

    public void setmDownLoadAppRequestBean(DownLoadAppRequestBean mDownLoadAppRequestBean) {
        this.mDownLoadAppRequestBean = mDownLoadAppRequestBean;
    }

    public DownLoadApi(RxAppCompatActivity rxAppCompatActivity, DownLoadAppRequestBean mDownLoadAppRequestBean, OnHttpTaskListener listener) {
        super(listener, rxAppCompatActivity);
        this.mDownLoadAppRequestBean = mDownLoadAppRequestBean;
//        setShowProgress(true);
//        setMothed("AppFiftyToneGraph/videoLink");
    }

    @Override
    public Observable getObservable(HttpService methods) {
        HashMap<String,String> map = new HashMap<>();
        map.put("type",mDownLoadAppRequestBean.getType());
        map.put("fileId",mDownLoadAppRequestBean.getFileId());


        return methods.download(map);
    }

}
