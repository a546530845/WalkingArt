package com.zxgzeroapp.workingart.view;


import com.zxgzeroapp.workingart.bean.back.LoginBackBean;

public interface ILoginView {
	
	 void LoginSucess(LoginBackBean bean);
	 void LoginError(Throwable ex);
	 void LoginPrepare();
	 void Loginfinish();

}
