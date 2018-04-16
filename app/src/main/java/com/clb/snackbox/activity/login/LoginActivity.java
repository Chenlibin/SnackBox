package com.clb.snackbox.activity.login;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.clb.clblibrary.activity.RootActivity;
import com.clb.clblibrary.net.OKHttpUtil;
import com.clb.snackbox.R;
import com.clb.snackbox.activity.AdminActivity;
import com.clb.snackbox.net.NetReqUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Liber on 2018/3/8.
 */

/**
 * 管理员登录界面
 */

public class LoginActivity extends RootActivity {

    private TextView centerTitle;
    private EditText name;
    private EditText password;

    @Override
    protected int loadLayout() {
        return R.layout.ui_login;
    }

    @Override
    protected void initView() {

        centerTitle = $View(R.id.centerTitle);
        centerTitle.setText(R.string.admin_login);

        name = findViewById(R.id.name);
        password = findViewById(R.id.password);

    }

    //进入登录界面
    public void loginIn(View view) {
        if (entry()) {
            NetReqUtil.getNetUtil().adminLogin(new Callback() {
                @Override
                public void onFailure(Request request, IOException e) {
                    Log.e("onFailure: login", "fail");
                }

                @Override
                public void onResponse(Response response) throws IOException {
                    JsonObject jsonObject = new JsonParser().parse(response.body().string()).getAsJsonObject();
                    Log.e("onResponse: login", jsonObject + "");

                    String status = jsonObject.get("status").getAsString();
                    String message = jsonObject.get("message").getAsString();
                    if (Integer.parseInt(status) == 1) {
                        jumpAndFinsh(AdminActivity.class);
                    }
                    toast(message);

                }
            }, new OKHttpUtil.Param[]{
                    new OKHttpUtil.Param("username", name.getText().toString().trim()),
                    new OKHttpUtil.Param("password", password.getText().toString().trim())
            });

//            toast(R.string.login_in);
//            jumpAndFinsh(AdminActivity.class);
        }
    }

    //进入注册界面
    public void jumpToResigist(View view) {
        jump(ResigistActivity.class);
    }

    //验证是否为空
    private boolean entry() {
        if (TextUtils.isEmpty(name.getText().toString().trim())) {
            toast(R.string.admin_name_tip);
            return false;
        }
        if (TextUtils.isEmpty(password.getText().toString().trim())) {
            toast(R.string.password_tip);
            return false;
        }
        return true;
    }

}
