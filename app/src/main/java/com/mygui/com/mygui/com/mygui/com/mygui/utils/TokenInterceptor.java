package com.mygui.com.mygui.com.mygui.com.mygui.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mygui.com.mygui.com.mygui.com.mygui.contants.UriConstant;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 全局自动刷新Token的拦截器
 */

public class TokenInterceptor implements Interceptor {

    private static final String TAG = "TokenInterceptor";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);

        if (isTokenExpired(response)) {//根据和服务端的约定判断token过期
            //同步请求方式，获取最新的Token
            String newSession = getNewToken();
            //使用新的Token，创建新的请求
            Request newRequest = chain.request()
                    .newBuilder()
                    .header("authorization", newSession)
                    .build();
            //重新请求
            return chain.proceed(newRequest);
        }
        return response;
    }

    /**
     * 根据Response，判断Token是否失效
     *
     * @param response
     * @return
     */
    private boolean isTokenExpired(Response response) {
        boolean test = false;
        if (response.code() != 200) {
            test = true;
        }
        return test;
    }


    /**
     * 同步请求方式，获取最新的Token
     *
     * @return token
     */
    private String getNewToken() throws IOException {
        String accessToken = "";
        OkHttpClient client = new OkHttpClient();
        String url = RestUtils.getUrl(UriConstant.FILE_SEPARATE) + "?loginName=123&loginPassword=456";

        //Request是OkHttp中访问的请求，Builder是辅助类，Response即OkHttp中的响应
        final Request request = new Request.Builder()
                .url(url)
                .build();
        final Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            final String jsonData = response.body().string();

            try {
                JSONObject jsonArray = JSON.parseObject(jsonData);
                JSONObject jsonObject = jsonArray.getJSONObject("data");
//                String id = jsonObject.getString("id");
//                String token = jsonObject.getString("token");
                accessToken = jsonObject.getString("accessToken");
//                String expiresIn = jsonObject.getString("expiresIn");
//                BaseSharedPreferences.setString(App.getInstance(), "accessToken", accessToken);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new IOException("Unexpected code " + response);
        }

//        return BaseSharedPreferences.getString(App.getInstance(), "accessToken");
        return accessToken;
    }
}