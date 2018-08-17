package com.mygui.com.mygui.com.mygui.com.mygui.utils;


import com.mygui.com.mygui.com.mygui.com.mygui.contants.UriConstant;

/**
 * Created by Administrator on 2018/5/14 0014.
 */

public class RestUtils {

    public static String getPath() {
        // return "http //" + IP + ":" + PORT + UriConstant.FILE_SEPARATE;
        return "http://" + UriConstant.IP + ":" + UriConstant.PORT + UriConstant.FILE_SEPARATE;
    }
    public static String getUrl(String url) {
        return getPath() + url;
    }
    /**
     * 读取baseurl
     *
     * @param url
     * @return
     */
    public static String getBasUrl(String url) {
        String head = "";
        int index = url.indexOf("://");
        if (index != -1) {
            head = url.substring(0, index + 3);
            url = url.substring(index + 3);
        }
        index = url.indexOf("/");
        if (index != -1) {
            url = url.substring(0, index + 1);
        }
        return head + url;
    }


}
