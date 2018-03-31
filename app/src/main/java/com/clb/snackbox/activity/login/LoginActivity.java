package com.clb.snackbox.activity.login;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.clb.clblibrary.activity.RootActivity;
import com.clb.snackbox.R;
import com.clb.snackbox.activity.AdminActivity;

/**
 * Created by Liber on 2018/3/8.
 */

/**
 * 管理员登录界面
 */

public class LoginActivity extends RootActivity {

    private TextView centerTitle;
    private EditText admin;
    private EditText password;

    @Override
    protected int loadLayout() {
        return R.layout.ui_login;
    }

    @Override
    protected void initView() {

        centerTitle = $View(R.id.centerTitle);
        centerTitle.setText(R.string.admin_login);

        admin = findViewById(R.id.admin);
        password = findViewById(R.id.password);

    }

    //进入登录界面
    public void loginIn(View view) {
        if (entry()) {
            toast(R.string.login_in);
            jumpAndFinsh(AdminActivity.class);
        }
    }

    //进入注册界面
    public void jumpToResigist(View view) {
        jump(ResigistActivity.class);
    }

    //验证是否为空
    private boolean entry() {
        if (TextUtils.isEmpty(admin.getText().toString().trim())) {
            toast(R.string.admin_tip);
            return false;
        }
        if (TextUtils.isEmpty(password.getText().toString().trim())) {
            toast(R.string.password_tip);
            return false;
        }
        return true;
    }

}
