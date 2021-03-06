package com.zxgzeroapp.workingart.http;


import com.zxgzeroapp.workingart.bean.back.AppUpdateBackBean;
import com.zxgzeroapp.workingart.bean.back.ConsTellMonth;
import com.zxgzeroapp.workingart.bean.back.ConsTellToday;
import com.zxgzeroapp.workingart.bean.back.ConsTellWeek;
import com.zxgzeroapp.workingart.bean.back.ConsTellYear;
import com.zxgzeroapp.workingart.bean.back.FilmReviewBack;
import com.zxgzeroapp.workingart.bean.back.LoginBackBean;
import com.zxgzeroapp.workingart.bean.back.UpLoadPicBackBean;
import com.zxgzeroapp.workingart.bean.request.ConstellationRequestBean;
import com.zxgzeroapp.workingart.bean.request.FilmRequestBean;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import rx.Observable;

/**
 * service统一接口数据
 * Created by WZG on 2016/7/16.
 */
public interface HttpService {
    //query get ;field post

    /**
     * app版本
     * @param maps
     * @return
     */
    @FormUrlEncoded
    @POST(Constant.APP_VERSION)
    Observable<AppUpdateBackBean> APP_VERSION(@FieldMap HashMap<String,String> maps);

    /**
     * 登录
     * @param maps
     * @return
     */
    @FormUrlEncoded
    @POST(Constant.LOGIN)
    Observable<LoginBackBean> LOGIN(@FieldMap HashMap<String,String> maps);
    /**
     * 电影票房
     * @param maps
     * @return
     */
    @POST(Constant.FILMREVIEW)
    Observable<FilmReviewBack> FILMREVIEW(@Body FilmRequestBean maps);
    /**
     * 星座today
     * @param maps
     * @return
     */
    @POST(Constant.CONSTELLTIONDAY)
    Observable<ConsTellToday> CONSTELLTIONDAY(@Body ConstellationRequestBean maps);
    @POST(Constant.CONSTELLTIONDAY)
    Observable<ConsTellWeek> CONSTELLTIONWEEK(@Body ConstellationRequestBean maps);
    @POST(Constant.CONSTELLTIONDAY)
    Observable<ConsTellMonth> CONSTELLTIONMONTH(@Body ConstellationRequestBean maps);
    @POST(Constant.CONSTELLTIONDAY)
    Observable<ConsTellYear> CONSTELLTIONYEAR(@Body ConstellationRequestBean maps);


    /*断点续传下载接口*/
    @Streaming/*大文件需要加入这个判断，防止下载过程中写入到内存中*/
    @POST(Constant.DOWNLOADURL)
    Observable<ResponseBody> download(@QueryMap HashMap<String,String> maps);

    /*上传文件*/
    @Multipart
    @POST(Constant.UPLOAD_IMAGE)
    Observable<UpLoadPicBackBean> uploadImage(@Part MultipartBody.Part file);

}
