package com.mygui.com.mygui.activity;

import android.content.Intent;
import android.serialport.DevUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.mygui.com.mygui.R;

import java.io.File;

public class IndexActivity extends AppCompatActivity {
    private LinearLayout put;
    private LinearLayout get;
    private String DevPath = "/dev/ttyS0";//默认串口
    private final int Baudrate = 115200;//默认波特率
    private final int LoopIdle = 50;//线程空闲时间ms
    private final int PollTime = 1000;//轮询get_ioRunData()时间间隔ms
    private DevUtil devUtil;
    private LinearLayout jisong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        devUtil = new DevUtil(null);
        File dev = new File(DevPath);
        //dev 必须具有读写权限
        boolean r = devUtil.openCOM(dev, Baudrate, 0);
        if(r) {
                //通讯打开
        }

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
