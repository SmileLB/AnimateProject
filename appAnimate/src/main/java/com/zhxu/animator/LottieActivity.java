package com.zhxu.animator;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.OnCompositionLoadedListener;

public class LottieActivity extends AppCompatActivity {

    private LottieAnimationView lav ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);




        /**
         *
         * Lottie动画框架通过json字符串实现动画效果，可以使用图片
         * json:是由美工通过AE工具生成的
         *
         * Lottie会自动解析json字符串，生成一个Drawable
         *
         */

        //方式1 直接在xml中引入json文件

        //方式2 通过代码的方式显示动画
        lav = (LottieAnimationView) findViewById(R.id.lav);
//        lav.setAnimation("City.json");
//        lav.loop(true);//循环动画
//        lav.playAnimation();//执行动画

        //方式3
//        LottieComposition.Factory.fromAssetFileName(this, "City.json", new OnCompositionLoadedListener() {
//            @Override
//            public void onCompositionLoaded(@Nullable LottieComposition composition) {
//                //composition对象 其实就是解析json后生成的对象，LottieComposition中包含了json中的动画信息
//                lav.setComposition(composition);
//                lav.loop(true);
//                lav.playAnimation();
//            }
//        });

        //动画中如果包含图片
        /**
         * 1、json中包含图片名称
         * 2、设置图片所在路径
         */
        lav.setImageAssetsFolder("images");//设置json串中需要的图片所在路径
        lav.setAnimation("data.json");//加载json文件
        lav.loop(true);
        lav.playAnimation();
    }
}
