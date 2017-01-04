package com.zxgzeroapp.workingart.model;

import com.zxgzeroapp.workingart.bean.request.UploadRequestBean;
import com.zxgzeroapp.workingart.http.HttpManager;
import com.zxgzeroapp.workingart.http.api.UploadApi;
import com.zxgzeroapp.workingart.http.upload.ProgressRequestBody;
import com.zxgzeroapp.workingart.http.upload.UploadProgressListener;
import com.zxgzeroapp.workingart.imodel.IUpLoadImageModel;
import com.zxgzeroapp.workingart.mvplistener.OnHttpTaskListener;
import com.zxgzeroapp.workingart.mvplistener.OnMVPUploadHttpTaskListener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;


public class UploadImageModel implements IUpLoadImageModel{

    @Override
    public <T>void uploadImageBackBean(RxAppCompatActivity mContext,UploadRequestBean mUploadRequestBean , final OnMVPUploadHttpTaskListener<T> mvpHttpUploadTaskListener) {
        // TODO Auto-generated method stub
//        AppUpdateRequestBean mAppUpdateRequestBean = new AppUpdateRequestBean();


        File file=mUploadRequestBean.getmFile();
//        String CONTENT_TYPE = "multipart/form-data"; // 内容类型application/otcet-stream

        RequestBody requestBody=RequestBody.create(MediaType.parse("image/jpeg"),file);
        MultipartBody.Part part= MultipartBody.Part.createFormData("pictureFile", file.getName(), new ProgressRequestBody(requestBody,
                new UploadProgressListener() {
                    @Override
                    public void onProgress(long currentBytesCount, long totalBytesCount) {
                        mvpHttpUploadTaskListener.onProgress(currentBytesCount,totalBytesCount);
                    }
                }));
//        MultipartBody.Part part= MultipartBody.Part.createFormData("pictureFile", file.getName(), requestBody);

        UploadApi mAppUpdateApi = new UploadApi(mContext, new OnHttpTaskListener<T>() {
            @Override
            public void onPreTask() {
                mvpHttpUploadTaskListener.onPreTask();
            }

            @Override
            public void onTaskError(Throwable throwable) {
                mvpHttpUploadTaskListener.onTaskError(throwable);
            }

            @Override
            public void onSuccessTask(T bean) {
                mvpHttpUploadTaskListener.onSuccessTask(bean);
            }

            @Override
            public void onFinishTask() {
                mvpHttpUploadTaskListener.onFinishTask();
            }

            @Override
            public void onCancel() {
                mvpHttpUploadTaskListener.onCancel();
            }
        });

        mAppUpdateApi.setPart(part);
        HttpManager.doHttpDeal(mAppUpdateApi);


    }


}
