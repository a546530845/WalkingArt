package com.zxgzeroapp.workingart.imodel;


import com.zxgzeroapp.workingart.bean.request.LoginRequestBean;
import com.zxgzeroapp.workingart.mvplistener.OnMVPHttpTaskListener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;


public interface ILoginModel {
	<T>void getLoginBackBean(RxAppCompatActivity mContext, LoginRequestBean mLoginRequestBean, OnMVPHttpTaskListener<T> mvpHttpTaskListener);
}
