package com.zxgzeroapp.workingart.presenter;

import com.zxgzeroapp.workingart.bean.back.AppUpdateBackBean;
import com.zxgzeroapp.workingart.imodel.IAppUpdateModel;
import com.zxgzeroapp.workingart.model.AppUpdateModel;
import com.zxgzeroapp.workingart.mvplistener.OnMVPHttpTaskListener;
import com.zxgzeroapp.workingart.view.IAppUpdateView;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;


public class AppUpdatePresenter {
	public IAppUpdateView mIAppUpdateView;
	public IAppUpdateModel mIAppUpdateModel;
	
	public AppUpdatePresenter(IAppUpdateView View){
		this.mIAppUpdateView = View;
		mIAppUpdateModel = new AppUpdateModel();
	}
	
	public void getAppUpdateBackBean(RxAppCompatActivity mContext){

		mIAppUpdateModel.getAppUpDateBackBean(mContext,new OnMVPHttpTaskListener<AppUpdateBackBean>() {

			@Override
			public void onPreTask() {
				// TODO Auto-generated method stub
				mIAppUpdateView.AppUpdatePrepare();
			}

			@Override
			public void onTaskError(Throwable throwable) {
				// TODO Auto-generated method stub
				mIAppUpdateView.AppUpdateError(throwable);
			}

			@Override
			public void onSuccessTask(AppUpdateBackBean bean) {
				// TODO Auto-generated method stub
				mIAppUpdateView.AppUpdateSucess(bean);
			}

			@Override
			public void onFinishTask() {
				// TODO Auto-generated method stub
				mIAppUpdateView.AppUpdatefinish();
			}

			@Override
			public void onCancel() {
				// TODO Auto-generated method stub
				mIAppUpdateView.AppUpdateCancel();
			}
		});
	}
	
}
