package com.zhxu.animator;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;

public class PathActivity extends AppCompatActivity {

    private PathView pathView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);

        //SVG
        //Path

        final Path path = new Path();
        path.lineTo(300,0);
        path.lineTo(300,300);
        path.lineTo(0,300);
        path.close();//将终点和起点连接在一起



        pathView = (PathView) findViewById(R.id.pathView);

        pathView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(pathView, "translationX", "translationY", path);
                animator.setDuration(1000);
                animator.setInterpolator(new AnticipateOvershootInterpolator());
                animator.start();

            }
        });
    }
}
