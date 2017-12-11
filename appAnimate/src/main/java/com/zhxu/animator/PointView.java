package com.zhxu.animator;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class PointView extends View {
    public PointView(Context context) {
        super(context);
    }

    public PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private int cx = 0 ;
    private int cy = 100 ;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setAntiAlias(true);//设置抗锯齿
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        canvas.drawCircle(cx+20,cy,20,paint);
    }

    public void startAnimator(){

        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(),new Point(0),new Point(300));
        animator.setDuration(1000);
        animator.start();

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //因为ofObject传入的起始对象是Point类型的，所以在这里获取的Value就是Point类型的
                Point point = (Point) animation.getAnimatedValue();
                cx = point.getX();
                //重绘view
                invalidate();
            }
        });

    }
}
