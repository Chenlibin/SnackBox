package com.clb.snackbox.net;

import com.clb.clblibrary.net.OKHttpUtil;
import com.squareup.okhttp.Callback;

/**
 * Created by Liber on 2018/4/9.
 */

public class NetReqUtil implements Cfg {

    private NetReqUtil() {
    }

    private static NetReqUtil netReqUtil = new NetReqUtil();

    public static NetReqUtil getNetUtil() {
        return netReqUtil;
    }

    /**
     * 注册管理员
     *
     * @param callback
     * @param params
     */
    public void adminRegister(Callback callback, OKHttpUtil.Param... params) {
        OKHttpUtil.getInstance().asyncPostRequest(resigistUrl, callback, params);
    }

    /**
     * 登录管理员
     * @param callback
     * @param params
     */
    public void adminLogin(Callback callback, OKHttpUtil.Param... params) {
        OKHttpUtil.getInstance().asyncPostRequest(loginUrl, callback, params);
    }


}
