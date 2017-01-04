package com.zxgzeroapp.workingart.presenter;

import com.zxgzeroapp.workingart.bean.back.UpLoadPicBackBean;
import com.zxgzeroapp.workingart.bean.request.UploadRequestBean;
import com.zxgzeroapp.workingart.imodel.IUpLoadImageModel;
import com.zxgzeroapp.workingart.model.UploadImageModel;
import com.zxgzeroapp.workingart.mvplistener.OnMVPUploadHttpTaskListener;
import com.zxgzeroapp.workingart.view.IUploadImageView;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;


public class UploadImagePresenter {
	public IUploadImageView mIUploadImageView;
	public IUpLoadImageModel mIUpLoadImageModel;

	public UploadImagePresenter(IUploadImageView View){
		this.mIUploadImageView = View;
		mIUpLoadImageModel = new UploadImageModel();
	}
	
	public void upLoadImageBack(RxAppCompatActivity mContext, UploadRequestBean mUploadRequestBean){

		mIUpLoadImageModel.uploadImageBackBean(mContext,mUploadRequestBean,new OnMVPUploadHttpTaskListener<UpLoadPicBackBean>() {

			@Override
			public void onPreTask() {
				// TODO Auto-generated method stub
				mIUploadImageView.UploadPrepare();
			}

			@Override
			public void onTaskError(Throwable throwable) {
				// TODO Auto-generated method stub
				mIUploadImageView.UploadError(throwable);
			}

			@Override
			public void onSuccessTask(UpLoadPicBackBean bean) {
				// TODO Auto-generated method stub
				mIUploadImageView.UploadSucess(bean);
			}

			@Override
			public void onFinishTask() {
				// TODO Auto-generated method stub
				mIUploadImageView.UploadFinish();
			}

			@Override
			public void onCancel() {
				// TODO Auto-generated method stub
			}

			@Override
			public void onProgress(long currentBytesCount, long totalBytesCount) {
				mIUploadImageView.onProgress(currentBytesCount,totalBytesCount);
			}
		});
	}
	
}
