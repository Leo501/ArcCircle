package com.game.arccircle;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
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
    private int arc_color;
    private Paint mPaint;
    private RectF rectF;
    public ArcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ArcView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array =context.obtainStyledAttributes(attrs,R.styleable.ArcView);
        inner_circle_width=array.getInteger(R.styleable.ArcView_inner_circle_width,DisplayUtils.dip2px(context,70f));
        inner_circle_color=array.getColor(R.styleable.ArcView_inner_circle_color, ContextCompat.getColor(context,R.color.white));
        circle_width=array.getInteger(R.styleable.ArcView_circle_width,DisplayUtils.dip2px(context,10f));
        circle_color=array.getColor(R.styleable.ArcView_circle_color,ContextCompat.getColor(context,R.color.grey_1));
        outer_circle_width=array.getInteger(R.styleable.ArcView_outer_circle_width,DisplayUtils.dip2px(context,5f));
        outer_circle_color=array.getColor(R.styleable.ArcView_outer_circle_color,ContextCompat.getColor(context,R.color.grey_2));
        init(context);
//        setBackgroundColor(0x8fff0000);
    }

    private void init(Context context) {
        //设置默认的宽高
        default_width=DisplayUtils.dip2px(context,200f);
        default_height=DisplayUtils.dip2px(context,200f);
        arc_color=ContextCompat.getColor(context,R.color.red);
        //
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height=measureHeight(heightMeasureSpec);
        int width=measureWidth(widthMeasureSpec);
        int size=Math.min(height,width);
        setMeasuredDimension(size,size);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        int mViewCenterX=getWidth()/2;
        int mViewCenterY=getHeight()/2;
        RectF rectF=new RectF(mViewCenterX-inner_circle_width-circle_width/2,mViewCenterX-inner_circle_width-circle_width/2,
                mViewCenterX+inner_circle_width+circle_width/2,mViewCenterX+inner_circle_width+circle_width/2);
        mPaint.setColor(outer_circle_color);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(mViewCenterX,mViewCenterY,inner_circle_width+circle_width+outer_circle_width,mPaint);
        mPaint.setColor(circle_color);
        canvas.drawCircle(mViewCenterX,mViewCenterY,inner_circle_width+circle_width,mPaint);
        mPaint.setColor(inner_circle_color);
        canvas.drawCircle(mViewCenterX,mViewCenterY,inner_circle_width,mPaint);
        mPaint.setColor(arc_color);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(circle_width);
        canvas.drawArc(rectF,-90,180,false,mPaint);
        mPaint.setStrokeWidth(2);
        canvas.drawLine(mViewCenterX,0,mViewCenterX,getHeight(),mPaint);

    }

    private int measureHeight(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        int result =default_height;
//        if (specMode == MeasureSpec.AT_MOST){
//            result = specSize;
//        }
//        else
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        }
        return result;
    }
    private int measureWidth(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        int result =default_width;
//        if (specMode == MeasureSpec.AT_MOST){//是marth_parent
//            result = specSize;
//        }
//        else
        if (specMode == MeasureSpec.EXACTLY) {//warp_content
            result = specSize;
        }
        return result;
    }
}
