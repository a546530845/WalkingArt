package com.zxgzeroapp.workingart.imodel;


import com.zxgzeroapp.workingart.mvplistener.OnMVPHttpTaskListener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;


public interface IAppUpdateModel {
	<T>void getAppUpDateBackBean(RxAppCompatActivity mContext, OnMVPHttpTaskListener<T> mvpHttpTaskListener);
}
