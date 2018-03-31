package com.clb.snackbox.launch;

import android.content.SharedPreferences;
import android.view.View;

import com.clb.clblibrary.activity.RootActivity;
import com.clb.snackbox.R;
import com.clb.snackbox.activity.login.LoginActivity;
import com.clb.snackbox.activity.QRActivity;

/**
 * 引导界面，可以显示打开app的界面。。然后正式进入app
 */
public class LaunchUI extends RootActivity {

    private final String USER = "user";
    private final String ADMIN = "admin";

    private SharedPreferences shared ;
    private SharedPreferences.Editor editor ;

    @Override
    protected int loadLayout() {
        return R.layout.ui_launch;
    }

    @Override
    protected void initView() {
        shared = getSharedPreferences("isFirst",MODE_PRIVATE);
        editor = shared.edit();

        if (!shared.getBoolean("first",true)){
            String jump = shared.getString("jump",USER);
            if (jump.equals(USER)){
                jumpAndFinsh(QRActivity.class);
            } else if (jump.equals(ADMIN)){
                jumpAndFinsh(LoginActivity.class);
            }
        }
    }

    //进入扫描二维码界面
    public void jumpToQR(View view) {
        editor.putBoolean("first",false);
        editor.putString("jump",USER);
        editor.commit();
        jump(QRActivity.class);
    }

    //进入管理员登录界面
    public void jumpToLogin(View view) {
        editor.putBoolean("first",false);
        editor.putString("jump",ADMIN);
        editor.commit();
        jump(LoginActivity.class);
    }
}
