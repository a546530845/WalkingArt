package com.zxgzeroapp.workingart.presenter;

import com.zxgzeroapp.workingart.bean.back.LoginBackBean;
import com.zxgzeroapp.workingart.bean.request.LoginRequestBean;
import com.zxgzeroapp.workingart.imodel.ILoginModel;
import com.zxgzeroapp.workingart.model.LoginModel;
import com.zxgzeroapp.workingart.mvplistener.OnMVPHttpTaskListener;
import com.zxgzeroapp.workingart.view.ILoginView;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;


public class LoginPresenter {
	public ILoginView mILoginView;
	public ILoginModel mILoginModel;

	public LoginPresenter(ILoginView View){
		this.mILoginView = View;
		mILoginModel = new LoginModel();
	}
	
	public void getLoginBackBean(RxAppCompatActivity mContext, LoginRequestBean mLoginRequestBean){

		mILoginModel.getLoginBackBean(mContext,mLoginRequestBean,new OnMVPHttpTaskListener<LoginBackBean>() {

			@Override
			public void onPreTask() {
				// TODO Auto-generated method stub
				mILoginView.LoginPrepare();
			}

			@Override
			public void onTaskError(Throwable throwable) {
				// TODO Auto-generated method stub
				mILoginView.LoginError(throwable);
			}

			@Override
			public void onSuccessTask(LoginBackBean bean) {
				// TODO Auto-generated method stub
				mILoginView.LoginSucess(bean);
			}

			@Override
			public void onFinishTask() {
				// TODO Auto-generated method stub
				mILoginView.Loginfinish();
			}

			@Override
			public void onCancel() {
				// TODO Auto-generated method stub
			}
		});
	}
	
}
