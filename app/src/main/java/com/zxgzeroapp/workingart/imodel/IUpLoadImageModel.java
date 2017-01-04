package com.zxgzeroapp.workingart.imodel;


import com.zxgzeroapp.workingart.bean.request.UploadRequestBean;
import com.zxgzeroapp.workingart.mvplistener.OnMVPUploadHttpTaskListener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;


public interface IUpLoadImageModel {
	<T>void uploadImageBackBean(RxAppCompatActivity mContext, UploadRequestBean mUploadRequestBean, OnMVPUploadHttpTaskListener<T> mvpHttpUploadTaskListener);
}
