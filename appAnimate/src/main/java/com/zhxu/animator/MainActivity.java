package com.zhxu.animator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button baseBtn ;
    private Button objectBtn ;
    private Button vectorBtn ;
    private Button lottieBtn ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        baseBtn = (Button) findViewById(R.id.base);
        objectBtn = (Button) findViewById(R.id.object);
        vectorBtn = (Button) findViewById(R.id.vector);
        lottieBtn = (Button) findViewById(R.id.lottie);

        baseBtn.setOnClickListener(this);
        objectBtn.setOnClickListener(this);
        vectorBtn.setOnClickListener(this);
        lottieBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.base:
                startActivity(new Intent(this,BaseAnimatorActivity.class));
                break;
            case R.id.object:
                startActivity(new Intent(this,ObjectAnimatorActivity.class));
                break;
            case R.id.vector:
                startActivity(new Intent(this,VectorActivity.class));
                break;
            case R.id.lottie:
                startActivity(new Intent(this,LottieActivity.class));
                break;
        }
    }
}
