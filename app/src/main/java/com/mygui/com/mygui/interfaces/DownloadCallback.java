package com.mygui.com.mygui.interfaces;

public interface DownloadCallback {

    void onProgress(int progress);

    void onComplete(String localPath);

    void onError(String msg);
}
