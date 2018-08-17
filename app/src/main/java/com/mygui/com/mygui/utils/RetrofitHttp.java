package com.mygui.com.mygui.utils;

import com.mygui.com.mygui.interfaces.ApiService;
import com.mygui.com.mygui.interfaces.DownloadCallback;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHttp {

    private static final int DEFAULT_TIMEOUT = 10;
    private static final String TAG = "RetrofitClient";

    private ApiService apiService;

    private OkHttpClient okHttpClient;

    public static String baseUrl;
    private static RetrofitHttp sIsntance;

    private UrlCheckCallback callback;

    public static RetrofitHttp getInstance(String baseUrl) {
        if (sIsntance == null) {
            synchronized (RetrofitHttp.class) {
                if (sIsntance == null) {
                    sIsntance = new RetrofitHttp(baseUrl);
                }
            }
        }
        return sIsntance;
    }

    private RetrofitHttp(String baseUrl) {
        this.baseUrl = baseUrl;
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
        apiService = retrofit.create(ApiService.class);
    }





    public interface UrlCheckCallback {
        void onSuccess();
        void onFailure();
    }
}
