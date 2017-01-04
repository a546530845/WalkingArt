package com.zxgzeroapp.workingart.http.api;

import com.zxgzeroapp.workingart.base.BaseApi;
import com.zxgzeroapp.workingart.http.HttpService;
import com.zxgzeroapp.workingart.mvplistener.OnHttpTaskListener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import okhttp3.MultipartBody;
import rx.Observable;

/**
 * 上传请求api
 * Created by WZG on 2016/10/20.
 */

public class UploadApi<T> extends BaseApi<T> {
    /*需要上传的文件*/
    private MultipartBody.Part part;


    public UploadApi(RxAppCompatActivity rxAppCompatActivity,OnHttpTaskListener listener) {
        super(listener, rxAppCompatActivity);
//        setShowProgress(true);
//        setMothed("AppFiftyToneGraph/videoLink");
    }

    public MultipartBody.Part getPart() {
        return part;
    }

    public void setPart(MultipartBody.Part part) {
        this.part = part;
    }

    @Override
    public Observable getObservable(HttpService methods) {
//        RequestBody uid= RequestBody.create(MediaType.parse("text/plain"), "4811420");
//        RequestBody key = RequestBody.create(MediaType.parse("text/plain"), "cfed6cc8caad0d79ea56d917376dc4df");
        // 添加描述
//        String descriptionString = "hello, 这是文件描述";
//        RequestBody description =
//                RequestBody.create(
//                        MediaType.parse("multipart/form-data"), descriptionString);

        return methods.uploadImage(getPart());
    }

}
