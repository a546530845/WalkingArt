package com.zxgzeroapp.workingart.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.zxgzeroapp.workingart.R;
import com.zxgzeroapp.workingart.base.BaseFragment;
import com.zxgzeroapp.workingart.bean.back.ConsTellYear;
import com.zxgzeroapp.workingart.bean.back.FilmReviewBack;
import com.zxgzeroapp.workingart.bean.request.ConstellationRequestBean;
import com.zxgzeroapp.workingart.presenter.fragment.ConsYearFgtPresenter;
import com.zxgzeroapp.workingart.pullable.PullToRefreshLayout;
import com.zxgzeroapp.workingart.pullable.PullableScrollView;
import com.zxgzeroapp.workingart.utils.LogUtil;
import com.zxgzeroapp.workingart.view.fragment.IConsYearFgtView;

import java.util.ArrayList;

/**
 * 作者：zxg on 2017/1/17 16:27
 */

public class YearFragment extends BaseFragment implements PullToRefreshLayout.OnRefreshListener,IConsYearFgtView{
    private static String TAG = "DayFragment";

    private PullableScrollView mPullableScrollView;
    private PullToRefreshLayout mPullToRefreshLayout;

    private boolean isLoading = false;
    private final int SUCCESS = 1001;
    private final int FAIL = 1002;
    private final int ERROR = 1003;
    private final int NOMORE = 1004;
    private final int Loading_refresh = 100;
    private final int Loading_more = 1001;
    private int Loading_status = Loading_refresh;

    ArrayList<FilmReviewBack.ResultBean> mlist = new ArrayList<>();

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SUCCESS:
                    // 千万别忘了告诉控件刷新完毕了哦！
                    if (Loading_refresh == Loading_status) {
                        mPullToRefreshLayout.refreshFinish(PullToRefreshLayout.SUCCEED);
                    } else {
                        mPullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.SUCCEED);
                    }

                    break;
                case FAIL:
                    //加载失败
                    if (Loading_refresh == Loading_status) {
                        mPullToRefreshLayout.refreshFinish(PullToRefreshLayout.FAIL);
                    } else {
                        mPullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.FAIL);
                    }
                    break;
                case ERROR:
                    if (Loading_refresh == Loading_status) {
                        mPullToRefreshLayout.refreshFinish(PullToRefreshLayout.FAIL);
                    } else {
                        mPullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.FAIL);
                    }
                case NOMORE:
                    mPullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.NOMORE);
                    break;
            }
        }
    };


    @Override
    public void setView(LayoutInflater inflater, @Nullable ViewGroup container) {
        //attachToRoot,如果少了这个参数传入的话，会出现堆栈溢出
        mFgtView = inflater.inflate(R.layout.collection_year_fgt, container, false);
    }

    public void getDataFromServer() {
        ConstellationRequestBean mConstellationRequestBean = new ConstellationRequestBean();
        mConstellationRequestBean.setKey("xxxxx");
        mConstellationRequestBean.setConsName("天秤座");
        mConstellationRequestBean.setType("year");
        //获取数据
        ConsYearFgtPresenter mConsYearFgtPresenter = new ConsYearFgtPresenter(this);
        mConsYearFgtPresenter.getConsTelltionYearBack((RxAppCompatActivity)mContext,mConstellationRequestBean);
    }

    @Override
    public void initView() {

        mPullToRefreshLayout = ((PullToRefreshLayout) mFgtView.findViewById(R.id.refresh_view));
        mPullableScrollView = (PullableScrollView) mFgtView.findViewById(R.id.account_normal_lv);


        instanceLoadingViewHelp(mPullToRefreshLayout);
    }

    @Override
    public void initListener() {
        mPullToRefreshLayout.setOnRefreshListener(this);

    }

    @Override
    public void initData() {
        mPullToRefreshLayout.autoRefresh();//自动刷新
    }

    @Override
    public void lazyLoading(boolean isVisibleToUser) {

    }


    public static FilmReviewFragment newInstance(String item) {
        FilmReviewFragment fragment = new FilmReviewFragment();
        LogUtil.d(TAG, "item =   " + item.toString());
        fragment.select = item;
        return fragment;
    }




    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        if (!isLoading) {
            Loading_status = Loading_refresh;
            getDataFromServer();
        }
        isLoading = true;
        helper.restore();
    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {

    }

    @Override
    public void ConsYearSucess(ConsTellYear bean) {
        isLoading = false;
        LogUtil.e("ConsTellYear = ",bean.toString());
        FilmReviewBack.ResultBean mResultBean = new FilmReviewBack.ResultBean();
        mResultBean.setName("中国合伙人" );
        mResultBean.setRid("1");
        mResultBean.setWk("2013.5.20--2013.5.26（单位：人民币）");
        mResultBean.setWboxoffice("￥20900万");
        mResultBean.setTboxoffice("￥31700万");
        mlist.add(mResultBean);
        mlist.add(mResultBean);
        mlist.add(mResultBean);
        mlist.add(mResultBean);
        mlist.add(mResultBean);
        mlist.add(mResultBean);
        mlist.add(mResultBean);
        mlist.add(mResultBean);
        mlist.add(mResultBean);
        mlist.add(mResultBean);
        mHandler.sendEmptyMessage(SUCCESS);
    }

    @Override
    public void ConsYearError(Throwable ex) {
        isLoading = false;
        helper.showFail(getResources().getString(R.string.bad_wangluo), new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mPullToRefreshLayout.autoRefresh();//自动刷新
            }

        });
        mHandler.sendEmptyMessage(ERROR);
    }

    @Override
    public void ConsYearPrepare() {

    }

    @Override
    public void ConsYearfinish() {

    }
}
