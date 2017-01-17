package com.zxgzeroapp.workingart.presenter.fragment;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.zxgzeroapp.workingart.bean.back.FilmReviewBack;
import com.zxgzeroapp.workingart.bean.request.FilmRequestBean;
import com.zxgzeroapp.workingart.imodel.fgtimodel.IFilmModel;
import com.zxgzeroapp.workingart.model.fgtmodel.FilmModel;
import com.zxgzeroapp.workingart.mvplistener.OnMVPHttpTaskListener;
import com.zxgzeroapp.workingart.view.fragment.IFilmFgtView;


public class FilmFgtPresenter {
	public IFilmFgtView mIFilmFgtView;
	public IFilmModel mIFilmModel;

	public FilmFgtPresenter(IFilmFgtView View){
		this.mIFilmFgtView = View;
		mIFilmModel = new FilmModel();
	}
	
	public void getFilmBackBean(RxAppCompatActivity mContext, FilmRequestBean mFilmRequestBean){

		mIFilmModel.getFilmBackBean(mContext,mFilmRequestBean,new OnMVPHttpTaskListener<FilmReviewBack>() {

			@Override
			public void onPreTask() {
				// TODO Auto-generated method stub
				mIFilmFgtView.FilmPrepare();
			}

			@Override
			public void onTaskError(Throwable throwable) {
				// TODO Auto-generated method stub
				mIFilmFgtView.FilmError(throwable);
			}

			@Override
			public void onSuccessTask(FilmReviewBack bean) {
				// TODO Auto-generated method stub
				mIFilmFgtView.FilmSucess(bean);
			}

			@Override
			public void onFinishTask() {
				// TODO Auto-generated method stub
				mIFilmFgtView.Filmfinish();
			}

			@Override
			public void onCancel() {
				// TODO Auto-generated method stub
			}
		});
	}
	
}
