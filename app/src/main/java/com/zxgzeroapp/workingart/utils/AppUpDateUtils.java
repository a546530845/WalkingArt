//package com.zxgzeroapp.workingart.utils;
//
//import android.app.Activity;
//import android.content.Context;
//import android.os.Environment;
//import android.os.Handler;
//import android.os.Message;
//import android.view.View;
//import android.view.WindowManager;
//import android.widget.Button;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//
//import com.zxgzeroapp.workingart.R;
//import com.zxgzeroapp.workingart.application.MyApplication;
//import com.zxgzeroapp.workingart.bean.back.AppUpdateBackBean;
//import com.zxgzeroapp.workingart.bean.request.AppUpdateRequestBean;
//import com.zxgzeroapp.workingart.bean.request.DownLoadAppRequestBean;
//import com.zxgzeroapp.workingart.http.Constant;
//import com.zxgzeroapp.workingart.http.download.AppType;
//import com.zxgzeroapp.workingart.mvplistener.OnHttpTaskListener;
//import com.zxgzeroapp.workingart.utils.about.AboutApp;
//import com.zxgzeroapp.workingart.widget.CustomDialog;
//
//import java.io.File;
//
//import static com.sgccsg.pospay.R.id.force_dialog_content;
//
///**
// * 作者：zxg on 2016/10/14 10:40
// * 用于升级App的工具类
// */
//public class AppUpDateUtils {
//    private Activity mContext;
//    private static AppUpDateUtils mAppUpDateUtils;
//    private boolean cancelDownload;
//    private File downloadAppFile_huabo;
//    private File downloadAppFile_xinye;
//
//    public static final int NO_SD_CARD = 113;
//    public static final int PROGRESS_UPDATE = 114;
//    public static final int PROGRESS_COMPLETE = 115;
//    private int hadDownloadSize;
//
//
//    private ProgressBar force_progressbar_huabo;//强制升级的dialog上的进度条
//    private TextView force_dialog_content_huabo;//强制升级的dialog上的进度条内容
//    private ProgressBar force_progressbar_xingye;//强制升级的dialog上的进度条
//    private TextView force_dialog_content_xingye;//强制升级的dialog上的进度条内容
//    private CustomDialog customDialog_huabo;//强制升级dialog华博
//    private CustomDialog customDialog_xinye;//强制升级dialog兴业
//    protected Handler mHandler = new Handler() {
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case NO_SD_CARD:// 没有SD卡
//                    ToastUtil.showShort(mContext, "升级失败，请插入SD卡");
//                    break;
//                case PROGRESS_UPDATE:// 进度条更新
//                    force_dialog_content_huabo.setText(hadDownloadSize + "/100");
//                    LogUtil.e("进度 = ", hadDownloadSize + "");
//                    force_progressbar_huabo.setProgress(hadDownloadSize);
//                    break;
//                case PROGRESS_COMPLETE:// 更新完成
//                    cancelDownload = true;
//                    MyApplication.isAppUpgrading = false;
//                    LogUtil.e("apk路径 = ", downloadAppFile_huabo.getAbsolutePath());
//                    AboutApp.installApk(downloadAppFile_huabo.getAbsolutePath(), mContext);
//                    break;
//            }
//        }
//
//        ;
//    };
//    protected Handler mHandler_xingye = new Handler() {
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case NO_SD_CARD:// 没有SD卡
//                    ToastUtil.showShort(mContext, "升级失败，请插入SD卡");
//                    break;
//                case PROGRESS_UPDATE:// 进度条更新
//                    force_dialog_content_xingye.setText(hadDownloadSize + "/100");
//                    LogUtil.e("进度 = ", hadDownloadSize + "");
//                    force_progressbar_xingye.setProgress(hadDownloadSize);
//                    break;
//                case PROGRESS_COMPLETE:// 更新完成
//                    cancelDownload = true;
//                    MyApplication.isAppUpgrading = false;
//                    LogUtil.e("apk路径 = ", downloadAppFile_xinye.getAbsolutePath());
//                    AboutApp.installApk(downloadAppFile_xinye.getAbsolutePath(), mContext);
//                    break;
//            }
//        }
//
//        ;
//    };
//
//    public AppUpDateUtils(Activity context) {
//        mContext = context;
//    }
//
//    /**
//     * 启动发送的请求，查看是否需要更新app
//     */
//    public void startUp() {
//        AppUpdateRequestBean mAppUpdateRequestBean = new AppUpdateRequestBean();
//        HttpsApi.App_upDate(mContext, mAppUpdateRequestBean, new OnHttpTaskListener<AppUpdateBackBean>() {
//            @Override
//            public void onPreTask() {
//
//            }
//
//            @Override
//            public void onTaskError(Throwable throwable) {
//
//            }
//
//            @Override
//            public void onFinishTask(AppUpdateBackBean bean) {
//                if (ResponseUtils.chkResponse(bean, mContext)) {
//                    try {
//                        LogUtil.e("本地Code = ", AboutApp.getVersionCode(mContext) + "");
//                        LogUtil.e("兴业本地Code = ", AboutApp.getVersionCodeXinye(mContext) + "");
//                        //一下为判断升级方式，需要根据返回参数具体操作
//                        if(null != bean && null != bean.getContent()){
//                            LogUtil.e("升级数据个数=",bean.getContent().size()+"");
//                            for(int i=0;i<bean.getContent().size();i++){
//                                if(null != bean.getContent().get(i)){
//                                    switch (bean.getContent().get(i).getVersionType()+""){
//                                        case AppType.POS:
//                                            if (Integer.valueOf(bean.getContent().get(i).getVersionCode()) > AboutApp.getVersionCode(mContext)) {
//                                                String downLoadUrl = Constant.DOWNLOADURL;
//                                                customDialog_huabo = LoadingDialog_huabo(mContext, downLoadUrl, bean.getContent().get(i));
//                                            }
//                                            break;
//                                        case AppType.XINYEAPP:
//                                            if (Integer.valueOf(bean.getContent().get(i).getVersionCode()) > AboutApp.getVersionCodeXinye(mContext)) {
//                                                String downLoadUrl = Constant.DOWNLOADURL;
//                                                customDialog_xinye = LoadingDialog_xingye(mContext, downLoadUrl, bean.getContent().get(i));
//                                            }
//                                            break;
//                                    }
//                                }
//                            }
//                        }
//                    }catch (Exception e){
//
//                    }
//
//
////                    //1是兴业更新信息
////                    if (null != bean.getContent().get(1) && bean.getContent().get(0).getVersionType() == 4 && (bean.getContent().get(1).getVersionCode() < (AboutApp.getVersionCodeXinye(mContext)))) {
////                        String downLoadUrl = Constant.DOWNLOADURL;
////                        customDialog_xinye = LoadingDialog_xingye(mContext, downLoadUrl, bean.getContent().get(1));
////                    }
////                    //0是pos更新信息
////                    if (null != bean.getContent().get(0) && bean.getContent().get(0).getVersionType() == 1 && (bean.getContent().get(0).getVersionCode() < (AboutApp.getVersionCode(mContext)))) {
////                        String downLoadUrl = Constant.DOWNLOADURL;
////                        customDialog_huabo = LoadingDialog_huabo(mContext, downLoadUrl, bean.getContent().get(0));
////                    }
//                }
//            }
//        });
//    }
//
//
//    /**
//     * 显示加载dialog
//     *
//     * @return
//     */
//    private CustomDialog LoadingDialog_huabo(final Context mContext, final String upgradeUrl, final AppUpdateBackBean.ContentBean bean) {
//        final CustomDialog customDialog = new CustomDialog(mContext, R.layout.force_update_dialog, R.style.Theme_dialog);
//        WindowManager.LayoutParams lp = customDialog.getWindow().getAttributes();
//        lp.dimAmount = 0.5f;
//        customDialog.getWindow().setAttributes(lp);
//        customDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//
//        force_progressbar_huabo = (ProgressBar) customDialog.findViewById(R.id.force_dialog_upgrade);
//        force_dialog_content_huabo = (TextView) customDialog.findViewById(force_dialog_content);
//        TextView force_dialog_content_info = (TextView) customDialog.findViewById(R.id.force_dialog_content_info);
//        if (null != bean && null != bean.getVersionDesc()) {
//            force_dialog_content_info.setText(bean.getVersionDesc());
//        }
//        final Button mButton = (Button) customDialog.findViewById(R.id.btn_Confirm);
//        mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mButton.setClickable(false);
//                mButton.setEnabled(false);
//                if (MyApplication.isAppUpgrading) {
//                    ToastUtil.showShort(mContext, "当前正在升级，您不需要重新下载！");
//                } else {
//                    // SD卡不存在就不去升级
//                    boolean isSDCardExists = Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
//                    if (!isSDCardExists) {
//                        MyApplication.isAppUpgrading = false;// 下载终止
//                        mHandler.sendEmptyMessage(NO_SD_CARD);
//                        return;
//                    }
//                    String appName = "downLoad_" + "huabo_" + bean.getVersionCode() + ".apk";
//                    downloadAppFile_huabo = new File(getFileCacheDirectory() + "/" + appName);
//
//                    DownLoadAppRequestBean mDownLoadAppRequestBean = new DownLoadAppRequestBean();
//                    mDownLoadAppRequestBean.setFileId(String.valueOf(bean.getFileId()));
//                    mDownLoadAppRequestBean.setFilepath((getFileCacheDirectory() + "/" + appName));
//                    mDownLoadAppRequestBean.setType(AppType.POS);//设置下载app的类型
//
//                    HttpsApi.downLoadApp(mContext, upgradeUrl, mDownLoadAppRequestBean, new OnDownLoadHttpTaskListener<String>() {
//                        @Override
//                        public void onPreTask() {
//                            // 通知栏显示下载通知
////                            showDownLoadNotice();
//                            MyApplication.isAppUpgrading = true;// 正在下载App
//                            cancelDownload = false;
//                            LogUtil.e("华博开始下载", "xxxxxx");
//                        }
//
//                        @Override
//                        public void onTaskError(Throwable throwable) {
//                            MyApplication.isAppUpgrading = false;
//                            ToastUtil.showShort(mContext, "下载失败");
//
//                            customDialog.dismiss();
//                        }
//
//                        @Override
//                        public void onFinishTask(String bean) {
//                                /*
//                                * 下载完成
//					            */
//                            mHandler.sendEmptyMessage(PROGRESS_COMPLETE);
//                            LogUtil.e("下载完成", "xxxxxx");
//                            customDialog.dismiss();
//
//                        }
//
//                        @Override
//                        public void onLoading(long total, long current, boolean arg2) {
//
//                            // 发送消息更新进度条
//                            LogUtil.e("current,total=", current + "----" + total + "");
//                            hadDownloadSize = (int) (((double) current / total) * 100);
//                            mHandler.sendEmptyMessage(PROGRESS_UPDATE);
//
//                        }
//                    });
//                }
//            }
//        });
//
//        customDialog.show();
//        customDialog.setCancelable(false);
//        customDialog.setCanceledOnTouchOutside(false);
//        return customDialog;
//    }
//
//    /**
//     * 显示加载dialog
//     *
//     * @return
//     */
//    private CustomDialog LoadingDialog_xingye(final Context mContext, final String upgradeUrl, final AppUpdateBackBean.ContentBean bean) {
//        final CustomDialog customDialog = new CustomDialog(mContext, R.layout.force_update_dialog, R.style.Theme_dialog);
//        WindowManager.LayoutParams lp = customDialog.getWindow().getAttributes();
//        lp.dimAmount = 0.5f;
//        customDialog.getWindow().setAttributes(lp);
//        customDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//
//        force_progressbar_xingye = (ProgressBar) customDialog.findViewById(R.id.force_dialog_upgrade);
//        force_dialog_content_xingye = (TextView) customDialog.findViewById(force_dialog_content);
//        TextView force_dialog_content_info = (TextView) customDialog.findViewById(R.id.force_dialog_content_info);
//        if (null != bean && null != bean.getVersionDesc()) {
//            force_dialog_content_info.setText(bean.getVersionDesc());
//        }
//        final Button mButton = (Button) customDialog.findViewById(R.id.btn_Confirm);
//        mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mButton.setClickable(false);
//                mButton.setEnabled(false);
//                if (MyApplication.isAppUpgrading) {
//                    ToastUtil.showShort(mContext, "当前正在升级，您不需要重新下载！");
//                } else {
//                    // SD卡不存在就不去升级
//                    boolean isSDCardExists = Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
//                    if (!isSDCardExists) {
//                        MyApplication.isAppUpgrading = false;// 下载终止
//                        mHandler_xingye.sendEmptyMessage(NO_SD_CARD);
//                        return;
//                    }
//                    String appName = "downLoad_" + "xingye_" + bean.getVersionCode() + ".apk";
//                    downloadAppFile_xinye = new File(getFileCacheDirectory_xinye() + "/" + appName);
//
//                    DownLoadAppRequestBean mDownLoadAppRequestBean = new DownLoadAppRequestBean();
//                    mDownLoadAppRequestBean.setFileId(String.valueOf(bean.getFileId()));//设置兴业的fileid
//                    mDownLoadAppRequestBean.setFilepath((getFileCacheDirectory_xinye() + "/" + appName));
//                    mDownLoadAppRequestBean.setType(AppType.XINYEAPP);//设置下载app的类型
//
//                    HttpsApi.downLoadApp(mContext, upgradeUrl, mDownLoadAppRequestBean, new OnDownLoadHttpTaskListener<String>() {
//                        @Override
//                        public void onPreTask() {
//                            // 通知栏显示下载通知
////                            showDownLoadNotice();
//                            MyApplication.isAppUpgrading = true;// 正在下载App
//                            cancelDownload = false;
//                            LogUtil.e("兴业开始下载", "xxxxxx");
//                        }
//
//                        @Override
//                        public void onTaskError(Throwable throwable) {
//                            MyApplication.isAppUpgrading = false;
//                            ToastUtil.showShort(mContext, "下载失败");
//
//                            customDialog.dismiss();
//                        }
//
//                        @Override
//                        public void onFinishTask(String bean) {
//                                /*
//                                * 下载完成
//					            */
//                            mHandler_xingye.sendEmptyMessage(PROGRESS_COMPLETE);
//                            LogUtil.e("下载完成", "xxxxxx");
//                            customDialog.dismiss();
//
//                        }
//
//                        @Override
//                        public void onLoading(long total, long current, boolean arg2) {
//
//                            // 发送消息更新进度条
//                            LogUtil.e("current,total=", current + "----" + total + "");
//                            hadDownloadSize = (int) (((double) current / total) * 100);
//                            mHandler_xingye.sendEmptyMessage(PROGRESS_UPDATE);
//
//                        }
//                    });
//                }
//            }
//        });
//
//        customDialog.show();
//        customDialog.setCancelable(false);
//        customDialog.setCanceledOnTouchOutside(false);
//        return customDialog;
//    }
//
//    /**
//     * 获取下载存储位置
//     *
//     * @return
//     */
//    public String getFileCacheDirectory() {
//        File sdcardDir = Environment.getExternalStorageDirectory();
//        String fileDirectory = "/mnt/sdcard";
//        if (null != sdcardDir) {
//            fileDirectory = sdcardDir.getAbsolutePath() + "/pospay/apk";
//        }
//        return fileDirectory;
//    }
//
//    /**
//     * 获取兴业下载存储位置
//     *
//     * @return
//     */
//    public String getFileCacheDirectory_xinye() {
//        File sdcardDir = Environment.getExternalStorageDirectory();
//        String fileDirectory = "/mnt/sdcard";
//        if (null != sdcardDir) {
//            fileDirectory = sdcardDir.getAbsolutePath() + "/xingyeapk/apk";
//        }
//        return fileDirectory;
//    }
//}
