package com.clb.clblibrary.net;

import okhttp3.OkHttpClient;

/**
 * Created by Liber on 2018/3/18.
 */

public class OKHttpUtil {

    private static OkHttpClient client = new OkHttpClient();

    private static OKHttpUtil httpUtil = new OKHttpUtil();

    private OKHttpUtil(){
        
    }

    public static OKHttpUtil getHttpUtil(){
        return httpUtil;
    }




}
