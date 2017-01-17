package com.zxgzeroapp.workingart.view.fragment;


import com.zxgzeroapp.workingart.bean.back.FilmReviewBack;

public interface IFilmFgtView {
	
	 void FilmSucess(FilmReviewBack bean);
	 void FilmError(Throwable ex);
	 void FilmPrepare();
	 void Filmfinish();

}
