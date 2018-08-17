package com.mygui.com.mygui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.mygui.com.mygui.R;

public class GetPutActivity extends AppCompatActivity  implements View.OnClickListener{
    private LinearLayout get;//取出

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.get:
                Intent itget = new Intent();
                itget.setClass(GetPutActivity.this,GetActivity.class);
                startActivity(itget);
                break;

            case R.id.put:
                Intent it = new Intent();
                it.setClass(GetPutActivity.this,PutActivity.class);
                startActivity(it);

                break;
        }
    }

    private LinearLayout put;//存放
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_put);
        initView();
    }

    public void initView (){
        get = findViewById(R.id.get);
        put = findViewById(R.id.put);
        get.setOnClickListener(this);
        put.setOnClickListener(this);
    }
}

