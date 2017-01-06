package com.zxgzeroapp.workingart.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zxgzeroapp.workingart.R;
import com.zxgzeroapp.workingart.bean.back.AppUpdateBackBean;
import com.zxgzeroapp.workingart.bean.back.LoginBackBean;
import com.zxgzeroapp.workingart.bean.request.LoginRequestBean;
import com.zxgzeroapp.workingart.widget.CustomDialog;
import com.zxgzeroapp.workingart.custom.MyDialogUtil;
import com.zxgzeroapp.workingart.presenter.AppUpdatePresenter;
import com.zxgzeroapp.workingart.presenter.LoginPresenter;
import com.zxgzeroapp.workingart.view.IAppUpdateView;
import com.zxgzeroapp.workingart.view.ILoginView;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

public class LoginActivity extends RxAppCompatActivity implements IAppUpdateView,ILoginView {

	private CustomDialog proDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_aty);
//		//获取最新版本
		AppUpdatePresenter mAppUpdatePresenter = new AppUpdatePresenter(this);
		mAppUpdatePresenter.getAppUpdateBackBean(this);
		//登录
		LoginRequestBean mLoginRequestBean = new LoginRequestBean();
		mLoginRequestBean.setmUesrName("18612596132");
		mLoginRequestBean.setmPassWord("111111");
		mLoginRequestBean.setmPosCode("03610001");
		LoginPresenter mLoginPresenter = new LoginPresenter(this);
		mLoginPresenter.getLoginBackBean(this,mLoginRequestBean);
	}

	public void ClickEvent(View view){
		switch (view.getId()){
			case R.id.main_aty_add:
				Intent mIntent = new Intent(this,UpLoadActivity.class);
				startActivity(mIntent);
				break;
			case R.id.main_aty_constellation:
				Intent mIntent2 = new Intent(this,DownLoadActivity.class);
				startActivity(mIntent2);
				break;
		}
	}
	 /*
     * 显示progressDialog
     */
    public void ShowProDialog(Context mContext, String msg, boolean cancelable) {
        if (proDialog == null) {

            proDialog = MyDialogUtil.showRotateDialog(mContext, msg, cancelable);
        } else {
            if (!proDialog.isShowing()) {
                proDialog = MyDialogUtil.showRotateDialog(mContext, msg, cancelable);
            }
        }
    }

    /*
     * 关闭progressDialog
     */
    public void DissProDialog() {
        if (proDialog != null) {
            proDialog.dismiss();
            proDialog = null;
        }
    }


	@Override
	public void AppUpdateSucess(AppUpdateBackBean bean) {
		Log.e("APPSUccess = ", bean.toString());
		DissProDialog();
	}

	@Override
	public void AppUpdateError(Throwable ex) {
		Log.e("AppError = ", ex.toString());
		DissProDialog();
	}

	@Override
	public void AppUpdatePrepare() {
		ShowProDialog(this, "正在加载中。。。", false);
	}

	@Override
	public void AppUpdatefinish() {
		DissProDialog();
	}

	@Override
	public void AppUpdateCancel() {
		Log.e("Cancel = ", "取消");
	}

	@Override
	public void LoginSucess(LoginBackBean bean) {
		Log.e("LoginSuccess = ", bean.toString());
	}

	@Override
	public void LoginError(Throwable ex) {
		Log.e("LoginError = ", ex.toString());
	}

	@Override
	public void LoginPrepare() {

	}

	@Override
	public void Loginfinish() {

	}
}
