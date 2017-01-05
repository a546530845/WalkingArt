package com.zxgzeroapp.workingart.activity.welcome;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zxgzeroapp.workingart.R;
import com.zxgzeroapp.workingart.base.BaseActivity;
import com.zxgzeroapp.workingart.sp.SharedPrefHelper;
import com.zxgzeroapp.workingart.utils.about.About_size;

import java.util.ArrayList;
import java.util.List;


/**
 * 引导页面 用于通过图片切换图片介绍本应用
 * 
 * @author Zero
 * 
 */
public class GuideActivity extends BaseActivity {

	private String TAG = "GuideActivity";
	private SharedPrefHelper sharedPreferceHelper;
	private ViewPager vp_anim;
	private List<View> views = new ArrayList<View>();
	private ImageView[] imageViews;
	private ImageView imageView;
	private LinearLayout guide_aty_linear;

	public void setStatusbar() {
		//重写方法，不设置bars
	}
	@Override
	protected void beforeInitView() {
		// TODO Auto-generated method stub
		sharedPreferceHelper = SharedPrefHelper.getInstance(this);
	}

	@Override
	protected void setLayoutView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.guide_aty);
//		JpushNotificationUtils.setDiyStyleCustom(this.getApplicationContext());
//		//顶部导航栏
//		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//A
//		//底部虚拟按键透明
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);//B,设置之后布局可以延展到虚拟按键里面去
	}

	@Override
	public void initView() {
		vp_anim = (ViewPager) findViewById(R.id.vp_anim);
		guide_aty_linear = (LinearLayout) findViewById(R.id.guide_aty_linear);
		views.add(View.inflate(GuideActivity.this, R.layout.total_one, null));
		views.add(View.inflate(GuideActivity.this, R.layout.total_two, null));
		views.add(View.inflate(GuideActivity.this, R.layout.total_three, null));
		views.add(View.inflate(GuideActivity.this, R.layout.total_four, null));
		PagerAdapter adapter = new PagerAdapter() {

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return views.size();
			}

			@Override
			public CharSequence getPageTitle(int position) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				container.addView(views.get(position));
				return views.get(position);
			}

			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				container.removeView(views.get(position));
			}
		};

		vp_anim.setAdapter(adapter);
		initPosition();
		vp_anim.addOnPageChangeListener(new GuidePageChangeListener());
	}

	@Override
	protected void initListener() {

	}

	/**
	 * 初始化底部小点
	 */
	private void initPosition() {
		/**
		 * 有几张图片 下面就显示几个小圆点
		 */
		imageViews = new ImageView[4];
		for (int i = 0; i < views.size(); i++) {
			LinearLayout.LayoutParams margin = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			// 设置每个小圆点距离左边的间距
			margin.setMargins(About_size.dp2px(GuideActivity.this, 7), 0, 0, 0);
			imageView = new ImageView(GuideActivity.this);
			// 设置每个小圆点的宽高
			imageView.setLayoutParams(new LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			imageViews[i] = imageView;
			if (i == 0) {
				// 默认选中第一张图片
				imageViews[i]
						.setBackgroundResource(R.mipmap.guide_aty_redpoint);
			} else {
				// 其他图片都设置未选中状态
				imageViews[i]
						.setBackgroundResource(R.mipmap.guide_aty_whitepoint);
			}
			guide_aty_linear.addView(imageViews[i], margin);
		}

	}

	// @Override
	// public void onClickEvent(View view) {
	// switch (view.getId()) {
	// case R.id.guide_aty_logintv:
	// // sharedPreferceHelper.setmIsFirstLanuch(false);
	// startActivity(new Intent(GuideActivity.this, LoginActivity.class));
	// GotoAnim();
	// break;
	// case R.id.guide_aty_loginfreetv:
	// // sharedPreferceHelper.setmIsFirstLanuch(false);
	// startActivity(new Intent(GuideActivity.this,
	// FreeRegistActivity.class));
	// GotoAnim();
	// break;
	//
	// default:
	// break;
	// }
	// }

	// 指引页面更改事件监听器
	class GuidePageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int arg0) {
			// 遍历数组让当前选中图片下的小圆点设置颜色
			for (int i = 0; i < imageViews.length; i++) {
				imageViews[arg0]
						.setBackgroundResource(R.mipmap.guide_aty_redpoint);

				if (arg0 != i) {
					imageViews[i]
							.setBackgroundResource(R.mipmap.guide_aty_whitepoint);
				}
			}
		}
	}

	@Override
	protected void initTitleView() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initData() {
		// TODO Auto-generated method stub

	}

}
