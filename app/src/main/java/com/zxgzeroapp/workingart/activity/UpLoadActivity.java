package com.zxgzeroapp.workingart.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zxgzeroapp.workingart.R;
import com.zxgzeroapp.workingart.bean.back.UpLoadPicBackBean;
import com.zxgzeroapp.workingart.bean.request.UploadRequestBean;
import com.zxgzeroapp.workingart.widget.CustomDialog;
import com.zxgzeroapp.workingart.custom.MyDialogUtil;
import com.zxgzeroapp.workingart.presenter.UploadImagePresenter;
import com.zxgzeroapp.workingart.view.IUploadImageView;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.io.File;

public class UpLoadActivity extends RxAppCompatActivity implements IUploadImageView {
    private ProgressBar progressBar;
    private CustomDialog proDialog;

    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_main);

        content = (TextView) findViewById(R.id.content);
        /*********************************************文件上传***************************************************/
        UploadRequestBean mUploadRequestBean = new UploadRequestBean();
        mUploadRequestBean.setmFile(new File("/storage/emulated/0/Share.jpg"));
        UploadImagePresenter uploadImagePresenter = new UploadImagePresenter(this);
        uploadImagePresenter.upLoadImageBack(this, mUploadRequestBean);

//        uploadeDo();


    }

    /*********************************************文件上传***************************************************/

//    private void uploadeDo(){
//        File file=new File("/storage/emulated/0/Share.jpg");
//        RequestBody requestBody=RequestBody.create(MediaType.parse("image/jpeg"),file);
//        MultipartBody.Part part= MultipartBody.Part.createFormData("pictureFile", file.getName(), new ProgressRequestBody(requestBody,
//                new UploadProgressListener() {
//                    @Override
//                    public void onProgress(long currentBytesCount, long totalBytesCount) {
//                        Log.e("当前总共=",currentBytesCount+"--------"+totalBytesCount);
//                    }
//                }));
//        UploadApi uplaodApi = new UploadApi(this,new OnHttpTaskListener<UpLoadPicBackBean>() {
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
//            public void onSuccessTask(UpLoadPicBackBean bean) {
//
//            }
//
//            @Override
//            public void onFinishTask() {
//
//            }
//
//            @Override
//            public void onCancel() {
//
//            }
//        });
//        uplaodApi.setPart(part);
//        HttpManager.doHttpDeal(uplaodApi);
//    }


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
        Log.e("进度 = ",currentBytesCount+"--------"+totalBytesCount);
    }

    @Override
    public void UploadSucess(UpLoadPicBackBean bean) {
        Log.e("上传成功 = ",bean.toString());
        content.setText("上传成功");
        DissProDialog();
    }

    @Override
    public void UploadError(Throwable ex) {
        Log.e("上传失败 = ",ex.toString());
        content.setText("上传失败");
        DissProDialog();
    }

    @Override
    public void UploadFinish() {
        DissProDialog();
    }

    @Override
    public void UploadPrepare() {
        Log.e("开始上传 = ","xxxxxx");
        ShowProDialog(this, "正在上传中。。。", false);
    }
}
