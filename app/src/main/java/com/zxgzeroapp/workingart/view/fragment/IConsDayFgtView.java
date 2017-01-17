package com.zxgzeroapp.workingart.view.fragment;


import com.zxgzeroapp.workingart.bean.back.ConsTellToday;

public interface IConsDayFgtView {
	
	 void ConsDaySucess(ConsTellToday bean);
	 void ConsDayError(Throwable ex);
	 void ConsDayPrepare();
	 void ConsDayfinish();

}
