package com.zxgzeroapp.workingart.imodel;


import com.zxgzeroapp.workingart.bean.request.DownLoadAppRequestBean;
import com.zxgzeroapp.workingart.mvplistener.OnMVPUploadHttpTaskListener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;


public interface IDownLoadModel {
	<T>void downLoadBackBean(RxAppCompatActivity mContext, DownLoadAppRequestBean mDownLoadAppRequestBean, OnMVPUploadHttpTaskListener<T> mvpHttpUploadTaskListener);
}
