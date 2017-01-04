package com.zxgzeroapp.workingart.loadView;


import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zxgzeroapp.workingart.R;


/**
 * 加载界面切换的辅助类
 * 
 * @author zsy
 *
 */
public class LoadViewHelper {
	private VaryViewHelper helper;
	private View loadingLayout;
	private TextView loadingTextView;
	private RelativeLayout relay;

	public boolean isEnable() {
		return helper.isEnable();
	}

	public void setEnable(boolean enable) {
		helper.setEnable(enable);
	}

	public LoadViewHelper(View view) {
		super();
		this.helper = new VaryViewHelper(view);
		loadingLayout = helper.inflate(R.layout.total_layout_noresult);
		loadingTextView = (TextView) loadingLayout.findViewById(R.id.tv_noresult);
		relay = (RelativeLayout) loadingLayout.findViewById(R.id.relay_noresult);
	}

	public View getLoadingLayout() {
		return loadingLayout;
	}

	public void showLoading() {
		showLoading("");
	}

	public void showLoading(String text) {
		loadingTextView.setText(text);
		helper.showLayout(loadingLayout);
	}
	public void showLoadingProgressBar() {
		View view = helper.inflate(R.layout.total_layout_noresult);
		TextView textView = (TextView) view.findViewById(R.id.tv_noresult);
		ImageView image = (ImageView) view.findViewById(R.id.iv_noresult);
//		ProgressBar progress = (ProgressBar) view.findViewById(R.id.loading_progressbar_update);
		textView.setVisibility(View.GONE);
		image.setVisibility(View.GONE);
//		progress.setVisibility(View.VISIBLE);
//		textView.setText(errorMsg);
		helper.showLayout(view);
	}

	public void showFail() {
		helper.showLayout(R.layout.total_layout_noresult);
	}

	public void showFail(String errorMsg) {
		showFail(errorMsg,null);
	}

	public void showFail(int errorMsgId, OnClickListener listener) {
		Context context = helper.getContext();
		String errorMsg = context.getString(errorMsgId);
		showFail(errorMsg,listener);
	}

	public void showFail(String errorMsg, OnClickListener listener) {
		View view = helper.inflate(R.layout.total_layout_noresult);
		TextView textView = (TextView) view.findViewById(R.id.tv_noresult);
		ImageView image = (ImageView) view.findViewById(R.id.iv_noresult);
//		ProgressBar progress = (ProgressBar) view.findViewById(R.id.loading_progressbar_update);
		relay.setOnClickListener(listener);
		image.setOnClickListener(listener);
		textView.setOnClickListener(listener);
		textView.setVisibility(View.VISIBLE);
		image.setVisibility(View.INVISIBLE);
//		progress.setVisibility(View.GONE);
		textView.setText(errorMsg);
		helper.showLayout(view);
	}
	public void showNoContent(String noContentMsg, OnClickListener listener) {
		View view = helper.inflate(R.layout.total_layout_noresult);
		TextView textView = (TextView) view.findViewById(R.id.tv_noresult);
		ImageView image = (ImageView) view.findViewById(R.id.iv_noresult);
		relay.setOnClickListener(listener);
		image.setOnClickListener(listener);
		textView.setOnClickListener(listener);
		textView.setVisibility(View.VISIBLE);
		image.setVisibility(View.INVISIBLE);
		textView.setText(noContentMsg);
		helper.showLayout(view);
	}

	public void showLayout(View view) {
		helper.showLayout(view);
	}

	public void restore() {
		helper.restoreView();
	}

}
