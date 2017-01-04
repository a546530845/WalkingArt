package com.zxgzeroapp.workingart.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zxgzeroapp.workingart.R;
import com.zxgzeroapp.workingart.bean.request.DownLoadAppRequestBean;
import com.zxgzeroapp.workingart.widget.CustomDialog;
import com.zxgzeroapp.workingart.custom.MyDialogUtil;
import com.zxgzeroapp.workingart.http.download.AppType;
import com.zxgzeroapp.workingart.presenter.DownLoadApkPresenter;
import com.zxgzeroapp.workingart.view.IDownLoadApkView;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

/**
 * 下载页面
 */
public class DownLoadActivity extends RxAppCompatActivity implements IDownLoadApkView {
    private ProgressBar progressBar;
    private CustomDialog proDialog;

    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_main);

        content = (TextView) findViewById(R.id.content);

        DownLoadAppRequestBean mDownLoadAppRequestBean = new DownLoadAppRequestBean();
        mDownLoadAppRequestBean.setFileId("258");
        mDownLoadAppRequestBean.setFilepath("/storage/emulated/0/retrofitapk/huaboretrofit.apk");
        mDownLoadAppRequestBean.setType(AppType.POS);
        DownLoadApkPresenter mDownLoadApkPresenter = new DownLoadApkPresenter(this);
        mDownLoadApkPresenter.downLoadBackBean(this,mDownLoadAppRequestBean);



    }



    /*
    * 显示progressDialog
    */
    public void ShowProDialog(Context mContext, String msg, boolean cancelable) {
        if (proDialog == null) {

            proDialog = MyDialogUtil.showRotateDialog(mContext, msg, cancelable);
        } else {
            if (!proDialog.isShowing()) {
                proDialog = MyDialogUtil.showRotateDialog(mContext, msg, cancelable);
            }
        }
    }

    /*
     * 关闭progressDialog
     */
    public void DissProDialog() {
        if (proDialog != null) {
            proDialog.dismiss();
            proDialog = null;
        }
    }


    @Override
    public void onProgress(long currentBytesCount, long totalBytesCount) {
        Log.e("下载进度 = ",currentBytesCount+"--------"+totalBytesCount);
    }

    @Override
    public void DownLoadSucess(String bean) {
        Log.e("下载成功 = ",bean.toString());
        content.setText("下载成功");
        DissProDialog();
    }

    @Override
    public void DownLoadError(Throwable ex) {
        Log.e("下载失败 = ",ex.toString());
        content.setText("下载失败");
        DissProDialog();
    }

    @Override
    public void DownLoadFinish() {
        DissProDialog();
    }

    @Override
    public void DownLoadPrepare() {
        Log.e("下载上传 = ","xxxxxx");
        ShowProDialog(this, "下载上传中。。。", false);
    }
}
