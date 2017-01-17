package com.zxgzeroapp.workingart.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.zxgzeroapp.workingart.R;
import com.zxgzeroapp.workingart.adapter.MyRecycleViewAdapter;
import com.zxgzeroapp.workingart.base.BaseFragment;
import com.zxgzeroapp.workingart.bean.back.FilmReviewBack;
import com.zxgzeroapp.workingart.bean.back.FilmReviewBack.ResultBean;
import com.zxgzeroapp.workingart.bean.request.FilmRequestBean;
import com.zxgzeroapp.workingart.presenter.fragment.FilmFgtPresenter;
import com.zxgzeroapp.workingart.pullable.DividerItemDecoration;
import com.zxgzeroapp.workingart.pullable.OnItemClickListener;
import com.zxgzeroapp.workingart.pullable.PullToRefreshLayout;
import com.zxgzeroapp.workingart.pullable.PullableRecycleView;
import com.zxgzeroapp.workingart.utils.LogUtil;
import com.zxgzeroapp.workingart.utils.ToastUtil;
import com.zxgzeroapp.workingart.view.fragment.IFilmFgtView;

import java.util.ArrayList;

/**
 * 作者：zxg on 2017/1/9 11:55
 */

public class FilmReviewFragment extends BaseFragment implements OnItemClickListener, IFilmFgtView, PullToRefreshLayout.OnRefreshListener {
    private static String TAG = "FilmReviewFragment";
    public String select = "";
    private TextView film_test;

    private PullableRecycleView mPullableRecycleView;
    private PullToRefreshLayout mPullToRefreshLayout;

    private boolean isLoading = false;
    private final int SUCCESS = 1001;
    private final int FAIL = 1002;
    private final int ERROR = 1003;
    private final int NOMORE = 1004;
    private final int Loading_refresh = 100;
    private final int Loading_more = 1001;
    private int Loading_status = Loading_refresh;

    private MyRecycleViewAdapter mMyRecycleViewAdapter;
    ArrayList<ResultBean> mlist = new ArrayList<>();

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
        mFgtView = inflater.inflate(R.layout.filmreview_fgt, container, false);
    }

    @Override
    public void lazyLoading(boolean isVisibleToUser) {
        LogUtil.e("Filmfgt select", select+ isAttached+isVisibleToUser);
        if (isAttached && isVisibleToUser && null != mPullToRefreshLayout) {
            //view 还没有加载
            mPullToRefreshLayout.autoRefresh();//自动刷新
        }
    }

    public void getDataFromServer() {
        //获取数据
        FilmRequestBean mFilmRequestBean = new FilmRequestBean();
        mFilmRequestBean.setArea(select);
        mFilmRequestBean.setKey("xxxxxxxx");//有待申请
        FilmFgtPresenter mFilmFgtPresenter = new FilmFgtPresenter(this);
        mFilmFgtPresenter.getFilmBackBean((RxAppCompatActivity) mContext, mFilmRequestBean);
    }

    @Override
    public void initView() {
        film_test = (TextView) mFgtView.findViewById(R.id.film_test);

        mPullToRefreshLayout = ((PullToRefreshLayout) mFgtView.findViewById(R.id.refresh_view));
        mPullableRecycleView = (PullableRecycleView) mFgtView.findViewById(R.id.account_normal_lv);

        setAdapter();

        instanceLoadingViewHelp(mPullToRefreshLayout);
    }

    @Override
    public void initListener() {
        mPullToRefreshLayout.setOnRefreshListener(this);

    }

    @Override
    public void initData() {
        film_test.setText(select);
        if (select.equals("CN")) {
            mPullToRefreshLayout.autoRefresh();//自动刷新
        }



//        mlist = new ArrayList<>();
//        mlist.add("CN");
//        mlist.add("US");
//        mlist.add("HK");


    }

    public void setAdapter() {
        if(null == mPullableRecycleView){
            LogUtil.e("mPullableRecycleView是否为空=","是");
        }
        if (null == mMyRecycleViewAdapter) {

            mMyRecycleViewAdapter = new MyRecycleViewAdapter(mlist);
            mMyRecycleViewAdapter.setOnItemClickListener(this);
            LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(mContext);
            //设置为垂直布局，这也是默认的
            mLinearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
            //设置分隔线
            mPullableRecycleView.addItemDecoration(new DividerItemDecoration(mContext, LinearLayoutManager.VERTICAL));
            //设置增加或删除条目的动画
            mPullableRecycleView.setItemAnimator(new DefaultItemAnimator());
            //设置布局管理器
            mPullableRecycleView.setLayoutManager(mLinearLayoutManager);
            mPullableRecycleView.setAdapter(mMyRecycleViewAdapter);
        } else {
            mMyRecycleViewAdapter.notifyDataSetChanged();
        }

    }

    public static FilmReviewFragment newInstance(String item) {
        FilmReviewFragment fragment = new FilmReviewFragment();
        LogUtil.d(TAG, "item =   " + item.toString());
        fragment.select = item;
        return fragment;
    }

    @Override
    public void onItemClick(View view, int position) {
        ToastUtil.showShort(mContext, mlist.get(position).getName());
    }

    @Override
    public void FilmSucess(FilmReviewBack bean) {
        isLoading = false;

        ResultBean mResultBean = new ResultBean();
        mResultBean.setName("中国合伙人"+select);
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
        LogUtil.e("mlist size = ",mlist.size()+select);
        mHandler.sendEmptyMessage(SUCCESS);
//        if (Loading_status == Loading_refresh) {
//            mlist.clear();
//            mlist.addAll(mlist);
//        } else {
//            mlist.addAll(mlist);
//        }

        setAdapter();

//        if (bean.getResultcode().equals("200")) {
//            mHandler.sendEmptyMessage(SUCCESS);
//            if (Loading_status == Loading_refresh) {
//                mlist.clear();
//                mlist.addAll(bean.getResult());
//            } else {
//                mlist.addAll(bean.getResult());
//            }
//
//            setAdapter();
//        } else {
//            mHandler.sendEmptyMessage(FAIL);
//            ToastUtil.showShort(mContext, bean.getReason());
//        }

    }

    @Override
    public void FilmError(Throwable ex) {
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
    public void FilmPrepare() {

    }

    @Override
    public void Filmfinish() {

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
}
