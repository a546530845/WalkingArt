package com.zxgzeroapp.workingart.view;


public interface IDownLoadApkView {
	
	 void onProgress(long currentBytesCount, long totalBytesCount);
	 void DownLoadSucess(String bean);
	 void DownLoadError(Throwable ex);
	 void DownLoadFinish();
	 void DownLoadPrepare();

}
