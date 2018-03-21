package com.clb.clblibrary.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by Liber on 2018/3/18.
 */

public class OKHttpUtil {

    private static OkHttpClient client;

    private static OKHttpUtil httpUtil = new OKHttpUtil();

    private OKHttpUtil(){
        client = new OkHttpClient().
    }

    public static OKHttpUtil getHttpUtil(){
        return httpUtil;
    }




}
