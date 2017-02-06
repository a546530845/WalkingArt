package com.zxgzeroapp.workingart.view.fragment;


import com.zxgzeroapp.workingart.bean.back.ConsTellWeek;

public interface IConsWeekFgtView {
	
	 void ConsWeekSucess(ConsTellWeek bean);
	 void ConsWeekError(Throwable ex);
	 void ConsWeekPrepare();
	 void ConsWeekfinish();

}
