package com.zxgzeroapp.workingart.pullable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.zxgzeroapp.workingart.R;

/**
 * 作者：zxg on 2017/1/10 15:15
 * 可根据属性来设置的divideLine
 */

public class DividerLine extends RecyclerView.ItemDecoration {
    private int mColor = Color.GRAY;
    private int thickness = DEFAULT_THICKNESS;
    private int padding;
    private static final int DEFAULT_THICKNESS = 1;
    private int orientation = HORIZONTAL;

    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    public static final int GRID = 2;

    private boolean drawBound = false;

    private int gridNum = 1;

    public DividerLine(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.divder);
        mColor = a.getColor(R.styleable.divder__dividerColor, mColor);
        padding = (int) a.getDimension(R.styleable.divder__dividerPadding, padding);
        thickness = (int) a.getDimension(R.styleable.divder__thickness, thickness);
        orientation = a.getInt(R.styleable.divder__orientation, 0);
        drawBound = a.getBoolean(R.styleable.divder__drawBound, false);
        gridNum = a.getInt(R.styleable.divder__grid_col_num, 1);
        a.recycle();

    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent) {
        Paint p = new Paint();
        p.setColor(mColor);
        p.setStrokeWidth(thickness);

        //画最前面的一个头部分割线
        if (drawBound && parent.getChildCount() > 0) {
            View v = parent.getChildAt(0);
            if (orientation == HORIZONTAL) {
                //画水平位置的分隔线
                c.drawLine(v.getLeft() + padding, v.getTop(), v.getRight() - padding, v.getTop(), p);
            }
            if (orientation == VERTICAL) {
                //画竖直位置的分隔线(GridView)
                c.drawLine(v.getLeft(), v.getTop()+ padding, v.getLeft(), v.getBottom() - padding, p);
            }
            if (orientation == GRID) {
                for (int i = 0; i < parent.getChildCount(); i += gridNum) {
                    v= parent.getChildAt(i);
                    //都画
                    c.drawLine(v.getLeft() + padding, v.getTop(), v.getRight() - padding, v.getTop(), p);
                    c.drawLine(v.getLeft(), v.getTop()+ padding, v.getLeft(), v.getBottom() - padding, p);
                }
            }
        }

        int to = drawBound ? parent.getChildCount() : parent.getChildCount() - 1;
        for (int i = 0; i < to; i++) {
            View v = parent.getChildAt(i);
            if (orientation == 0) {
                //画水平位置的分隔线
                c.drawLine(v.getLeft() + padding, v.getBottom(), v.getRight() - padding, v.getBottom(), p);
                //画竖直位置的分隔线(GridView)
            }
            if (orientation == 1) {
                c.drawLine(v.getRight(), v.getTop()+ padding, v.getRight(), v.getBottom()- padding, p);
            }
            if (orientation == GRID) {
                c.drawLine(v.getLeft() + padding, v.getBottom(), v.getRight() - padding, v.getBottom(), p);
                c.drawLine(v.getRight(),  v.getTop()+ padding, v.getRight(), v.getBottom()- padding, p);
            }
        }
    }


}