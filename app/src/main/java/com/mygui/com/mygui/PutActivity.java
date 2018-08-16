package com.mygui.com.mygui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class PutActivity extends AppCompatActivity {
    private LinearLayout foot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put);
        initView();

    }

    public void initView(){
        foot = findViewById(R.id.footclick);
        foot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent();
                it.setClass(PutActivity.this,PutDetailActiviy.class);
                startActivity(it);
            }
        });
    }
}
