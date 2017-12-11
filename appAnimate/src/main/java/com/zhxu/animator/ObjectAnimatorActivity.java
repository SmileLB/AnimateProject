package com.zhxu.animator;

import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ObjectAnimatorActivity extends AppCompatActivity implements View.OnClickListener {

    private Button translationBtn ;
    private Button roationBtn ;
    private Button scalBtn ;
    private Button alphaBtn ;
    private Button valueBtn ;

    private PointView view ;

    private Button testBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);



        translationBtn = (Button)findViewById(R.id.translation);
        roationBtn = (Button) findViewById(R.id.roation);
        scalBtn = (Button) findViewById(R.id.scal);
        alphaBtn = (Button) findViewById(R.id.alpha);
        valueBtn = (Button) findViewById(R.id.value);

        testBtn = (Button) findViewById(R.id.test);

        view = (PointView) findViewById(R.id.view);



        translationBtn.setOnClickListener(this);
        roationBtn.setOnClickListener(this);
        scalBtn.setOnClickListener(this);
        testBtn.setOnClickListener(this);
        alphaBtn.setOnClickListener(this);
        valueBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.translation:
                translation();
                break;
            case R.id.roation:
                rotation();
                break;
            case R.id.scal:
                scal();
                break;
            case R.id.alpha:
                alpha();
                break;
            case R.id.value:
                value();
                break;

            case R.id.test:
                Toast.makeText(this, "属性动画测试", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //ValueAnimator
    private void value() {

        /**
         * ValueAnimator是一个变化的过程，并不需要指定view
         *
         * 是属性的动画的基础，可以基于ValueAnimator实现任何动画
         */
        /*ValueAnimator valueAnimator = ValueAnimator.ofFloat(100, 300);
        valueAnimator.setDuration(500);

        valueAnimator.start();

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();

                testBtn.setTranslationX(value);
                Log.i("ObjectAnimator","value:"+value);
            }
        });*/

        //Int IntEvaluator
        //Float FloatEvaluator
        //Object 自己提供计算规则

        /*ValueAnimator valueAnimator = ValueAnimator.ofObject(new CharEvaluator(), new Character('a'), new Character('z'));

        valueAnimator.setDuration(10000);
        valueAnimator.start();

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char value = (char) animation.getAnimatedValue();
                testBtn.setText("Value测试"+value);
            }
        });*/

        view.startAnimator();


    }

    //自定义Char计算规则
    class CharEvaluator implements TypeEvaluator<Character>{

        @Override
        public Character evaluate(float fraction, Character startValue, Character endValue) {

            //计算规则
            int reslut = (int) (startValue + fraction * (endValue - startValue));

            return (char)reslut;
        }
    }

    private void alpha() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(testBtn,"alpha",0.2f);
        animator.setDuration(500);
        animator.start();
    }

    private void scal() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(testBtn,"scaleX",2);
        animator.setDuration(500);
        animator.start();

    }

    private void rotation() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(testBtn,"rotation",90);
        animator.setDuration(500);
        animator.start();
    }

    //属性动画平移
    private void translation() {

        //1
        //同时可以改变多个属性值
//        testBtn.animate().translationX(200).setDuration(500).translationY(200).start();


        //2
        /*ObjectAnimator animator = ObjectAnimator.ofFloat(testBtn,"translationX",200);//setTranslationY(Float 200)
        animator.setDuration(500);
        animator.start();*/


        //3
        //通过PropertyValuesHolder改变多个属性值
        /*PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("translationX",200);
        PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("translationY",200);

        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(testBtn, holder1, holder2);
        animator.setDuration(500);
        animator.start();*/

        //4
       /* //关键帧
        Keyframe frame1 = Keyframe.ofFloat(0,0);
        Keyframe frame2 = Keyframe.ofFloat(0.5f,200);
        Keyframe frame3 = Keyframe.ofFloat(1,100);
        //将关键帧应用到属性上
        PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("translationX", frame1, frame2, frame3);

        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(testBtn, holder);
        animator.setDuration(500);
        animator.start();*/


        //差值器 补间器  监听  计算规则

        //差值器 补间器
        ObjectAnimator animator = ObjectAnimator.ofFloat(testBtn,"translationX",100,300);
        animator.setDuration(500);
        //设置差值器  默认差值器 LinearInterpolator
//        animator.setInterpolator(new AnticipateOvershootInterpolator());
        animator.setInterpolator(new TimeInterpolator() {
            @Override
            public float getInterpolation(float input) {
                //input 范围（0-1）就是百分比，只与时间有关
                //如动画执行总时间为500 如果动画执行了200，则input就是0.4
//                Log.i("ObjectAnimator","1- input:"+(1- input)) ;
                return 1 - input;//范围 1 - 0
            }
        });

        /**
         * 如果使用ofFloat，系统默认提供FloatEvaluator
         * 如果使用ofInt，系统默认提供IntEvaluator
         */

        //设置计算规则
        animator.setEvaluator(new TypeEvaluator<Float>() {
            @Override
            public Float evaluate(float fraction, Float startValue, Float endValue) {
                float result = startValue + fraction * (endValue - startValue) + 100 ;
                Log.i("ObjectAnimator","fraction:"+fraction+",result:"+result) ;
                return result;
            }
        });


        animator.start();

        /**
         * 结论：updateListener中的监听获取的百分比的值和差值器getInterpolation()方法返回的结果一致
         *
         * Interpolation 中的getInterpolation方法的返回值 负责计算百分比 只和时间有关
         * Evaluator 中的evaluate方法根据百分比和开始结束值计算value（任意设置计算规则）
         * UpdateListener中的fraction和value都是上面计算的结果
         *
         *
         *
         */

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = animation.getAnimatedFraction();
                float value = (float) animation.getAnimatedValue();
                //value = start + fraction * (end - start)
                //value = 100 + fraction * 200
                Log.i("ObjectAnimator","fraction:"+fraction+",value:"+value) ;
            }
        });

    }


}
