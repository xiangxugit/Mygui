package com.mygui.com.mygui.utils;

import android.content.Context;
import android.content.SharedPreferences;


public class SPDownloadUtil {
    private static SharedPreferences mSharedPreferences;
    private static SPDownloadUtil instance;

    private SPDownloadUtil() {
    }



    /**
     * 清空数据
     *
     * @return true 成功
     */
    public boolean clear() {
        return mSharedPreferences.edit().clear().commit();
    }

    /**
     * 保存数据
     *
     * @param key   键
     * @param value 保存的value
     */
    public boolean save(String key, long value) {
        return mSharedPreferences.edit().putLong(key, value).commit();
    }

    /**
     * 获取保存的数据
     *
     * @param key      键
     * @param defValue 默认返回的value
     * @return value
     */
    public long get(String key, long defValue) {
        return mSharedPreferences.getLong(key, defValue);
    }
}

