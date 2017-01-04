package com.zxgzeroapp.workingart.http.interceptor;

import android.util.Log;

import com.zxgzeroapp.workingart.http.download.DownloadProgressListener;
import com.zxgzeroapp.workingart.http.download.DownloadProgressResponseBody;

import java.io.IOException;
import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class DownloadProgressInterceptor implements Interceptor {
    public static final String TAG = "DownloadProgressInterceptor.java";
    private DownloadProgressListener listener;

    public DownloadProgressInterceptor(DownloadProgressListener listener) {
        this.listener = listener;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        //the request url
        String url = request.url().toString();
        //the request method
        String method = request.method();
        long t1 = System.nanoTime();
        Log.e(TAG, String.format(Locale.getDefault(), "Sending %s request [url = %s]", method, url));



        Response originalResponse = chain.proceed(chain.request());


        long t2 = System.nanoTime();
        //the response time
        Log.e(TAG, String.format(Locale.getDefault(), "Received response for [url = %s] in %.1fms", url, (t2 - t1) / 1e6d));

        //the response state
        Log.e(TAG, String.format(Locale.CHINA, "Received response is %s ,message[%s],code[%d]", originalResponse.isSuccessful() ? "success" : "fail", originalResponse.message(), originalResponse.code()));

        return originalResponse.newBuilder()
                .body(new DownloadProgressResponseBody(originalResponse.body(), listener))
                .build();
    }
}