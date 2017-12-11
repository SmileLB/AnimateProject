package com.zhxu.animator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class VectorActivity extends AppCompatActivity implements View.OnClickListener {

    private Button svgBtn ;
    private Button pathBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector);

        svgBtn = (Button) findViewById(R.id.svg);
        pathBtn = (Button) findViewById(R.id.path);

        svgBtn.setOnClickListener(this);
        pathBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.svg:
                startActivity(new Intent(this,SvgActivity.class));
                break;
            case R.id.path:
                startActivity(new Intent(this,PathActivity.class));
                break;
        }
    }
}
