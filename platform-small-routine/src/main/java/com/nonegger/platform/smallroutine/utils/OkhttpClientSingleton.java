package com.nonegger.platform.smallroutine.utils;

/**
 * Project: platform-small-routine
 * Author : Eric
 * Time   : 2018/6/25 15:14
 * Desc   : OkHttpClient单例
 */

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * okhttpclient单例模式
 */
public class OkhttpClientSingleton {


    protected static final int DEFAULT_CONNECTION_TIMEOUT_IN_MS = 1500;

    protected static final int DEFAULT_SOCKET_TIMEOUT_IN_MS = 1500;


    public static final OkHttpClient getOkHttpClient() {
        return OkHttpClientHolder.INSTANCE;
    }

    private static class OkHttpClientHolder {
        private static final OkHttpClient INSTANCE = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_CONNECTION_TIMEOUT_IN_MS, TimeUnit.MILLISECONDS)
                .readTimeout(DEFAULT_SOCKET_TIMEOUT_IN_MS, TimeUnit.MILLISECONDS)
                .build();
    }

}
