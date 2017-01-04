package com.zxgzeroapp.workingart.custom;

import android.content.Context;
import android.view.WindowManager;
import android.widget.TextView;

import com.zxgzeroapp.workingart.R;
import com.zxgzeroapp.workingart.widget.CustomDialog;

/**
 * Created by zxg on 2016/9/27.
 */
public class MyDialogUtil {
    /**
     * 旋转加载dialog
     *
     * @param mContext
     * @param mMsg
     * @param cancancelable
     * @return
     */
    public static CustomDialog showRotateDialog(Context mContext, String mMsg, boolean cancancelable) {
        CustomDialog rotateDialog = null;
        if (rotateDialog == null) {
            rotateDialog = new CustomDialog(mContext, R.layout.item_rotate_dialog_layout, R.style.Theme_dialog);
        }
        WindowManager.LayoutParams lp = rotateDialog.getWindow().getAttributes();
        lp.dimAmount = 0.3f;
        rotateDialog.getWindow().setAttributes(lp);
        rotateDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        TextView tv_Msg = (TextView) rotateDialog.findViewById(R.id.tv_Msg);
        tv_Msg.setText(mMsg);

        rotateDialog.setCancelable(false);//把外部的设置关闭了
        rotateDialog.setCanceledOnTouchOutside(false);
        rotateDialog.show();
        return rotateDialog;
    }

}
