package com.zxgzeroapp.workingart.view.fragment;


import com.zxgzeroapp.workingart.bean.back.ConsTellYear;

public interface IConsYearFgtView {
	
	 void ConsYearSucess(ConsTellYear bean);
	 void ConsYearError(Throwable ex);
	 void ConsYearPrepare();
	 void ConsYearfinish();

}
