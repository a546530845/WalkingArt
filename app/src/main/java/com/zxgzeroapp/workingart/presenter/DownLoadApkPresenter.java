package com.zxgzeroapp.workingart.presenter;

import com.zxgzeroapp.workingart.bean.request.DownLoadAppRequestBean;
import com.zxgzeroapp.workingart.imodel.IDownLoadModel;
import com.zxgzeroapp.workingart.model.DownLoadModel;
import com.zxgzeroapp.workingart.mvplistener.OnMVPUploadHttpTaskListener;
import com.zxgzeroapp.workingart.view.IDownLoadApkView;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;


public class DownLoadApkPresenter {
	public IDownLoadApkView mIDownLoadApkView;
	public IDownLoadModel mIDownLoadModel;

	public DownLoadApkPresenter(IDownLoadApkView View){
		this.mIDownLoadApkView = View;
		mIDownLoadModel = new DownLoadModel();
	}
	
	public void downLoadBackBean(RxAppCompatActivity mContext, DownLoadAppRequestBean mDownLoadAppRequestBean){

		mIDownLoadModel.downLoadBackBean(mContext,mDownLoadAppRequestBean,new OnMVPUploadHttpTaskListener<String>() {

			@Override
			public void onPreTask() {
				// TODO Auto-generated method stub
				mIDownLoadApkView.DownLoadPrepare();
			}

			@Override
			public void onTaskError(Throwable throwable) {
				// TODO Auto-generated method stub
				mIDownLoadApkView.DownLoadError(throwable);
			}

			@Override
			public void onSuccessTask(String bean) {
				// TODO Auto-generated method stub
				mIDownLoadApkView.DownLoadSucess(bean);
			}

			@Override
			public void onFinishTask() {
				// TODO Auto-generated method stub
				mIDownLoadApkView.DownLoadFinish();
			}

			@Override
			public void onCancel() {
				// TODO Auto-generated method stub
			}

			@Override
			public void onProgress(long currentBytesCount, long totalBytesCount) {
				mIDownLoadApkView.onProgress(currentBytesCount,totalBytesCount);
			}
		});
	}
	
}
