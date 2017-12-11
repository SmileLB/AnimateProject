package com.zhxu.animator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class PathView extends View {
    public PathView(Context context) {
        super(context);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private int controlX = 400 ;
    private int controlY = 200 ;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //设置画笔
        Paint paint = new Paint() ;
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        //设置Path路径
        Path path = new Path() ;

//        path.moveTo(100,100);//移动点
//        path.lineTo(200,200);//画线

        /**
         * Direction.CW:顺时针方向
         * Direction.CCW：逆时针方向
         *
         */
//        path.addCircle(300,300,100, Path.Direction.CW);//画圆

//        path.addArc(100,100,300,300,0,90);
//        RectF rectF = new RectF(100,100,300,300);
//        path.addArc(rectF,0,90);


        /**
         * false：将上一个路线的终点和弧线的起点连接
         * true:不连接
         */
//        path.arcTo(100,100,300,300,0,90,false);

        //贝塞尔曲线
//        path.moveTo(300,300);
        //二阶贝塞尔曲线
//        path.quadTo(controlX,controlY,500,300);

//        path.cubicTo(400,200,500,400,500,300);

//        canvas.drawPath(path,paint);

        canvas.drawCircle(300,300,20,paint);
    }

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                controlX = (int) event.getRawX();
                controlY = (int) event.getRawY();
                invalidate();

                break ;
            case MotionEvent.ACTION_MOVE:
                controlX = (int) event.getRawX();
                controlY = (int) event.getRawY();
                invalidate();
                break;
        }

        return true ;
    }*/
}
