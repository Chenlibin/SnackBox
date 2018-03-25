package com.clb.clblibrary.net;

import android.text.TextUtils;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Liber on 2018/3/18.
 */

public class OKHttpUtil {

    private static OkHttpClient client;

    private static OKHttpUtil httpUtil = new OKHttpUtil();

    private OKHttpUtil() {
        client = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    public static OKHttpUtil getHttpUtil() {
        return httpUtil;
    }

    /********************************
     *    get
     ********************************/

    public void asyncGetRequest(String url, Callback callback) {
        client.newCall(createRequest(url).build()).enqueue(callback);
    }


    /********************************
     *    post
     ********************************/

    public void asyncPostRequest(String url, Callback callback, Param... params) {
        Request request = createPostParam(url, params);
        client.newCall(request).enqueue(callback);
    }


    /**
     * 创建一个请求
     */
    private Request.Builder createRequest(String url) {
        return new Request.Builder().url(url);
    }

//    private Request createPostParam(String url, Param[] params) {
//        if (params == null)
//            params = new Param[0];
//        FormEncodingBuilder builder = new FormEncodingBuilder();
//        for (Param param : params) {
//            if (param != null && !TextUtils.isEmpty(param.name) && !TextUtils.isEmpty(param.value)) {
//                builder.add(param.name, param.value);
//                Log.e("debug_request", param.name + "=>" + param.value);
//            }
//        }
//    }
    /**
     * 创建一个请求,且携带cookie
     */

    public static class Param {
        public String name;
        public String value;
        public int id;

        public Param() {
        }

        public Param(String name, String value) {
            this.name = name;
            this.value = value;
        }
    }

}
