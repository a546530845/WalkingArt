package com.zxgzeroapp.workingart.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zxgzeroapp.workingart.R;
import com.zxgzeroapp.workingart.bean.back.FilmReviewBack.ResultBean;
import com.zxgzeroapp.workingart.pullable.OnItemClickListener;
import com.zxgzeroapp.workingart.pullable.OnLongItemClickListener;

import java.util.ArrayList;

/**
 * 作者：zxg on 2017/1/10 11:12
 */

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {

    public OnItemClickListener itemClickListener;
    public OnLongItemClickListener longItemClickListener;

    public ArrayList<ResultBean> mlists;

    public MyRecycleViewAdapter(ArrayList<ResultBean> mlists) {
        this.mlists = mlists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_review_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.film_item_num.setText("第"+mlists.get(position).getRid()+"名");
        holder.film_item_filmname.setText(mlists.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mlists.size();
    }


    /**
     * 点击事件
     * @param itemClickListener
     */
    public  void setOnItemClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    /**
     * 长按点击事件
     * @param longItemClickListener
     */
    public  void setOnLongItemClickListener(OnLongItemClickListener longItemClickListener){
        this.longItemClickListener = longItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

        public TextView film_item_num;
        public TextView film_item_filmname;

//        private OnItemClickListener mOnItemClickListener;
//        private OnLongItemClickListener mOnLongItemClickListener;

        public ViewHolder(View itemView) {
            super(itemView);
            film_item_num = (TextView) itemView.findViewById(R.id.film_item_num);
            film_item_filmname = (TextView) itemView.findViewById(R.id.film_item_filmname);

//            this.mOnItemClickListener = mOnItemClickListener;
//            this.mOnLongItemClickListener = mOnLongItemClickListener;
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null){
                itemClickListener.onItemClick(v,getLayoutPosition());
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if (longItemClickListener != null){
                longItemClickListener.onLongItemClick(v,getLayoutPosition());
            }
            return true;
        }
    }
}
