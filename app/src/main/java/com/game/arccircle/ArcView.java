package com.game.arccircle;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/8/4.
 */
public class ArcView extends View {
    private int default_width;
    private int default_height;
    private int inner_circle_width;
    private int inner_circle_color;
    private int circle_width;
    private int circle_color;
    private int outer_circle_width;
    private int outer_circle_color;
    private Paint paint;
    public ArcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ArcView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array =context.obtainStyledAttributes(attrs,R.styleable.ArcView);
        inner_circle_width=array.getInteger(R.styleable.ArcView_inner_circle_width,DisplayUtils.dip2px(context,300f));
        inner_circle_color=array.getColor(R.styleable.ArcView_inner_circle_color, ContextCompat.getColor(context,R.color.white));
        circle_width=array.getInteger(R.styleable.ArcView_circle_width,DisplayUtils.dip2px(context,40f));
        circle_color=array.getColor(R.styleable.ArcView_circle_color,ContextCompat.getColor(context,R.color.grey_1));
        outer_circle_width=array.getInteger(R.styleable.ArcView_outer_circle_width,DisplayUtils.dip2px(context,20f));
        outer_circle_color=array.getColor(R.styleable.ArcView_outer_circle_color,ContextCompat.getColor(context,R.color.grey_2));
        init(context);
    }

    private void init(Context context) {
        //设置默认的宽高
        default_width=DisplayUtils.dip2px(context,400f);
        default_height=DisplayUtils.dip2px(context,400f);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
}
