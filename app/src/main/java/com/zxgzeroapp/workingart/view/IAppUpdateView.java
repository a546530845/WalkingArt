package com.zxgzeroapp.workingart.view;


import com.zxgzeroapp.workingart.bean.back.AppUpdateBackBean;

public interface IAppUpdateView {
	
	 void AppUpdateSucess(AppUpdateBackBean bean);
	 void AppUpdateError(Throwable ex);
	 void AppUpdatePrepare();
	 void AppUpdatefinish();
	 void AppUpdateCancel();

}
