package com.clb.snackbox;

import android.app.Application;
import android.content.Intent;
import android.view.View;

import com.dtr.zxing.activity.CaptureActivity;


/**
 * Created by Liber on 2018/1/16.
 */

/**
 * 在这里初始化数据库，等等，获得最高的app权限
 */

public class MyApp extends Application {

    public static MyApp app;
    //在onCreate里面执行
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化...Button bn=(Button)findViewById (R.id.button);
            Intent intent;
            intent = new Intent (String.valueOf (CaptureActivity.class));
            startActivity(intent);
        }



    public static MyApp getApp(){
        return app;
    }
}
