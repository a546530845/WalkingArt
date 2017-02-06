package com.zxgzeroapp.workingart.http.exception;

import android.net.ParseException;

import com.google.gson.JsonParseException;
import com.zxgzeroapp.workingart.utils.LogUtil;
import com.zxgzeroapp.workingart.utils.ToastUtil;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import org.json.JSONException;

import java.net.ConnectException;

import retrofit2.adapter.rxjava.HttpException;

/**
 * 作者：zxg on 2016/12/30 13:53
 */

public class ExceptionEngine {
    //对应HTTP的状态码
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;

    public static ApiException handleException(Throwable e, RxAppCompatActivity mActivity){
        LogUtil.e("handleException = ",e.toString());
        ApiException ex;
        if (e instanceof HttpException){             //HTTP错误
            HttpException httpException = (HttpException) e;
            ex = new ApiException(e, ERROR.HTTP_ERROR);
            switch(httpException.code()){
                case UNAUTHORIZED:
                case FORBIDDEN:
                case NOT_FOUND:
                case REQUEST_TIMEOUT:
                case GATEWAY_TIMEOUT:
                case INTERNAL_SERVER_ERROR:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    ex.message = "网络错误";  //均视为网络错误
                    break;
            }
            ToastUtil.showShort(mActivity,ex.message);

            return ex;
        } else if (e instanceof ServerException){    //服务器返回的错误
            ServerException resultException = (ServerException) e;
            ex = new ApiException(resultException, resultException.code);
            ex.message = resultException.message;
            return ex;
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException){
            ex = new ApiException(e, ERROR.PARSE_ERROR);
            ex.message = "解析错误";            //均视为解析错误
            ToastUtil.showShort(mActivity,ex.message);
            return ex;
        }else if(e instanceof ConnectException){
            ex = new ApiException(e, ERROR.NETWORD_ERROR);
            ex.message = "连接失败";  //均视为网络错误
            ToastUtil.showShort(mActivity,ex.message);
            return ex;
        }else {
            ex = new ApiException(e, ERROR.UNKNOWN);
            ex.message = "未知错误";          //未知错误
            ToastUtil.showShort(mActivity,ex.message);
            return ex;
        }
    }
    /**
     * 约定异常
     */

    public class ERROR {
        /**
         * 未知错误
         */
        public static final int UNKNOWN = 1000;
        /**
         * 解析错误
         */
        public static final int PARSE_ERROR = 1001;
        /**
         * 网络错误
         */
        public static final int NETWORD_ERROR = 1002;
        /**
         * 协议出错
         */
        public static final int HTTP_ERROR = 1003;
    }
    public static class ApiException extends Exception {
        public int code;
        public String message;

        public ApiException(Throwable throwable, int code) {
            super(throwable);
            this.code = code;

        }
    }
    public class ServerException extends RuntimeException {
        public int code;
        public String message;
    }
}
