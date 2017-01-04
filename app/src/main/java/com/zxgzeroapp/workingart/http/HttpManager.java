package com.zxgzeroapp.workingart.http;


import com.zxgzeroapp.workingart.base.BaseApi;
import com.zxgzeroapp.workingart.http.api.DownLoadApi;
import com.zxgzeroapp.workingart.http.exception.RetryWhenNetworkException;
import com.zxgzeroapp.workingart.http.interceptor.AddCookiesInterceptor;
import com.zxgzeroapp.workingart.http.interceptor.DownloadProgressInterceptor;
import com.zxgzeroapp.workingart.http.interceptor.LoggingInterceptor;
import com.zxgzeroapp.workingart.http.interceptor.ReceivedCookiesInterceptor;
import com.zxgzeroapp.workingart.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * http交互处理类
 * Created by WZG on 2016/7/16.
 */
public class HttpManager {

    /**
     * 处理http请求
     *
     * @param basePar 封装的请求数据
     */
    public static void doHttpDeal(BaseApi basePar) {
        //手动创建一个OkHttpClient并设置超时时间缓存等设置
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(basePar.getConnectionTime(), TimeUnit.SECONDS);
        builder.addInterceptor(new LoggingInterceptor());
        builder.interceptors().add(new ReceivedCookiesInterceptor(basePar.getRxAppCompatActivity()));
        builder.interceptors().add(new AddCookiesInterceptor(basePar.getRxAppCompatActivity()));


        /*get缓存去掉无效逻辑*/
//        builder.addInterceptor(new CookieInterceptor(basePar.isCache()));     
//        builder.cache(new Cache(MyApplication.app.getCacheDir(),10*1024*1024));

        /*创建retrofit对象*/
        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(basePar.getBaseUrl())
                .build();
        HttpService httpService = retrofit.create(HttpService.class);
//        Call<LoginBackBean> a = httpService.LOGINaaa();
//        a.enqueue(new Callback<LoginBackBean>() {
//            @Override
//            public void onResponse(Call<LoginBackBean> call, Response<LoginBackBean> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<LoginBackBean> call, Throwable t) {
//
//            }
//        });

        /*rx处理*/
        NormalSubcribers subscriber = new NormalSubcribers(basePar);
        Observable observable = basePar.getObservable(httpService)
                /*失败后的retry配置*/
                .retryWhen(new RetryWhenNetworkException())
                /*生命周期管理*/
                .compose(basePar.getRxAppCompatActivity().bindToLifecycle())
                /*http请求线程*/
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                /*回调线程*/
                .observeOn(AndroidSchedulers.mainThread());
//                /*结果判断*/
//                .map(basePar);

        /*数据回调*/
        observable.subscribe(subscriber);
    }

    /**
     * 处理http请求,用于下载
     *
     * @param basePar 封装的请求数据
     */
    public static void doHttpDealForDownLoadApk(final DownLoadApi basePar) {
        //手动创建一个OkHttpClient并设置超时时间缓存等设置
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(basePar.getConnectionTime(), TimeUnit.SECONDS);
//        builder.addInterceptor(new LoggingInterceptor());
//        builder.interceptors().add(new ReceivedCookiesInterceptor(basePar.getRxAppCompatActivity()));
//        builder.interceptors().add(new AddCookiesInterceptor(basePar.getRxAppCompatActivity()));
        builder.interceptors().add(new DownloadProgressInterceptor(basePar.getmDownloadProgressListener()));

        /*get缓存去掉无效逻辑*/
//        builder.addInterceptor(new CookieInterceptor(basePar.isCache()));
//        builder.cache(new Cache(MyApplication.app.getCacheDir(),10*1024*1024));

        /*创建retrofit对象*/
        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(basePar.getBaseUrl())
                .build();
        HttpService httpService = retrofit.create(HttpService.class);
        /*rx处理*/
        NormalSubcribers subscriber = new NormalSubcribers(basePar);
        Observable observable = basePar.getObservable(httpService)
                /*失败后的retry配置*/
                .retryWhen(new RetryWhenNetworkException())
                /*生命周期管理*/
                .compose(basePar.getRxAppCompatActivity().bindToLifecycle())
                /*http请求线程*/
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .map(new Func1<ResponseBody, String>() {
                    @Override
                    public String call(ResponseBody responseBody) {
                        try {
                            FileUtils.writeFile(responseBody.byteStream(), new File(basePar.getmDownLoadAppRequestBean().getFilepath()));
                        } catch (IOException e) {
                            return "false";
                            /*失败抛出异常*/
//                            throw new HttpTimeException(e.getMessage());
                        }
                        return "success";
                    }
                })
//                .map(new Func1<ResponseBody, InputStream>() {
//                    @Override
//                    public InputStream call(ResponseBody responseBody) {
//                        return responseBody.byteStream();
//                    }
//                })
//                .observeOn(Schedulers.computation())
//                .doOnNext(new Action1<InputStream>() {
//
//                    @Override
//                    public void call(InputStream inputStream) {
//                        try {
//                            FileUtils.writeFile(inputStream, new File(basePar.getmDownLoadAppRequestBean().getFilepath()));
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                            try {
//                                throw new Exception(e.getMessage(), e);
//                            } catch (Exception e1) {
//                                e1.printStackTrace();
//                            }
//                        }
//                    }
//                })
                /*回调线程*/
                .observeOn(AndroidSchedulers.mainThread());

        /*数据回调*/
        observable.subscribe(subscriber);
    }
}
