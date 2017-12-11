package com.zhxu.animator;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class SvgActivity extends AppCompatActivity {

    private ImageView search ;
    private Boolean flag = false ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg);

        search = (ImageView) findViewById(R.id.search);

        //加载“桥梁”
        final AnimatedVectorDrawable barToSearch = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.bar_to_search);
        final AnimatedVectorDrawable searchToBar = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.search_to_bar);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag) {
                    search.setImageDrawable(barToSearch);
                    barToSearch.start();
                    flag = false ;
                }else {
                    search.setImageDrawable(searchToBar);
                    searchToBar.start();
                    flag = true ;
                }
            }
        });

        /**
         *
         *
         * 要实现svg动画效果
         * 1、静态svg，给path设置名称<vector><vector/>
         * 2、设置“桥梁”（将静态的svg与动画结合的桥梁）<animated-vector drawable=静态的svg><target="名称" 动画></><animated-vector/>
         * 3、设置动画<objectAnimator><objectAnimator/>
         * 4、AnimatorVectorDrawable加载桥梁，调用start()方法开启svg动画
         *
         *
         *
         */
    }
}