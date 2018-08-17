package com.mygui.com.mygui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.mygui.com.mygui.R;

public class MainActivity extends AppCompatActivity {
    private LinearLayout testliucheng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    public void initView(){
        testliucheng = findViewById(R.id.testliucheng);
        testliucheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent();
                it.setClass(MainActivity.this,GetPutActivity.class);
                startActivity(it);
            }
        });
    }
}
