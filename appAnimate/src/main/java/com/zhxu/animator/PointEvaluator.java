package com.zhxu.animator;

import android.animation.TypeEvaluator;

/**
 * <p>Description:
 *
 * 针对于Point的计算规则
 *
 * @author xzhang
 */

public class PointEvaluator implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {

        int start = startValue.getX();
        int end = endValue.getX();
        int result = (int) (start + fraction * (end - start));

        Point point = new Point(result);

        return point;
    }
}
