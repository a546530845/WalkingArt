package com.zxgzeroapp.workingart.imodel.fgtimodel;


import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.zxgzeroapp.workingart.bean.request.FilmRequestBean;
import com.zxgzeroapp.workingart.mvplistener.OnMVPHttpTaskListener;


public interface IFilmModel {
	<T>void getFilmBackBean(RxAppCompatActivity mContext, FilmRequestBean mFilmRequestBean, OnMVPHttpTaskListener<T> mvpHttpTaskListener);
}
