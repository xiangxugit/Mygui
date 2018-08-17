package com.mygui.com.mygui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class IndexActivity extends AppCompatActivity {
    private LinearLayout put;
    private LinearLayout get;
    private LinearLayout jisong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        jisong = findViewById(R.id.jisong);
        put = findViewById(R.id.put);
        get = findViewById(R.id.getindex);

        jisong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent();
                it.setClass(IndexActivity.this,MainActivity.class);
                startActivity(it);
            }
        });


        put.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent();
                it.setClass(IndexActivity.this,GetPutActivity.class);
                startActivity(it);
            }
        });


        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent();
                it.setClass(IndexActivity.this,MainActivity.class);
                startActivity(it);
            }
        });
    }
}
