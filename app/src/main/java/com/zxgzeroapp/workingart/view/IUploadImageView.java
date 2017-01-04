package com.zxgzeroapp.workingart.view;


import com.zxgzeroapp.workingart.bean.back.UpLoadPicBackBean;

public interface IUploadImageView {
	
	 void onProgress(long currentBytesCount, long totalBytesCount);
	 void UploadSucess(UpLoadPicBackBean bean);
	 void UploadError(Throwable ex);
	 void UploadFinish();
	 void UploadPrepare();

}
