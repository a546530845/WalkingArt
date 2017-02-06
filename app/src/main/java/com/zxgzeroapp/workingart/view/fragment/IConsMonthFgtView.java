package com.zxgzeroapp.workingart.view.fragment;


import com.zxgzeroapp.workingart.bean.back.ConsTellMonth;

public interface IConsMonthFgtView {
	
	 void ConsMonthSucess(ConsTellMonth bean);
	 void ConsMonthError(Throwable ex);
	 void ConsMonthPrepare();
	 void ConsMonthfinish();

}
