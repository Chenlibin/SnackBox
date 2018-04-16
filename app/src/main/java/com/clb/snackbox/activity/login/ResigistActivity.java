package com.clb.snackbox.activity.login;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.clb.clblibrary.activity.RootActivity;
import com.clb.clblibrary.net.OKHttpUtil;
import com.clb.snackbox.R;
import com.clb.snackbox.net.NetReqUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Liber on 2018/3/13.
 */

public class ResigistActivity extends RootActivity {

    private TextView centerTitle;
    private ImageView leftInco;
    private EditText name;
    private EditText email;
    private EditText phoneNumber;
    private EditText password;
    private EditText surePwd;

    @Override
    protected int loadLayout() {
        return R.layout.ui_resigist;
    }

    @Override
    protected void initView() {
        centerTitle = $View(R.id.centerTitle);
        centerTitle.setText(R.string.resigist_admin);
        leftInco = $View(R.id.leftImage);
        leftInco.setImageResource(R.mipmap.left_icon);

        name = $View(R.id.resigist_name);
        email = $View(R.id.resigist_email);
        phoneNumber = $View(R.id.resigist_number);
        password = $View(R.id.password);
        surePwd = $View(R.id.sure_Pwd);
    }

    public void submit(View view) {
        if (entry()) {

            NetReqUtil.getNetUtil().adminRegister(new Callback() {
                @Override
                public void onFailure(Request request, IOException e) {
                    Log.e("onFailure: ", "register fail");
                }

                @Override
                public void onResponse(Response response) throws IOException {
                    JsonObject jsonObject = new JsonParser().parse(response.body().string()).getAsJsonObject();

                    Log.e("onResponse: register", jsonObject + "");
                    String status = jsonObject.get("status").getAsString();
                    String message = jsonObject.get("message").getAsString();

                    if (Integer.parseInt(status) == 1) {
                        toast(R.string.register_success);
                        jumpAndFinsh(LoginActivity.class);
                    } else {
                        toast(message);
                    }

                }
            }, new OKHttpUtil.Param[]{
                    new OKHttpUtil.Param("username", name.getText().toString().trim()),
                    new OKHttpUtil.Param("password", password.getText().toString().trim()),
                    new OKHttpUtil.Param("password2", surePwd.getText().toString().trim()),
                    new OKHttpUtil.Param("tel", phoneNumber.getText().toString().trim()),
                    new OKHttpUtil.Param("email", email.getText().toString().trim()),
            });

        } else {

        }
    }

    private boolean entry() {
        leftInco.setImageResource(R.mipmap.left_icon);

        if (TextUtils.isEmpty(name.getText().toString().trim())) {
            toast(R.string.admin_name_tip);
            return false;
        }
        if (TextUtils.isEmpty(email.getText().toString().trim())) {
            toast(R.string.admin_email_tip);
            return false;
        }
        if (TextUtils.isEmpty(password.getText().toString().trim())) {
            toast(R.string.password_tip);
            return false;
        }
        if (TextUtils.isEmpty(phoneNumber.getText().toString().trim())) {
            toast(R.string.admin_number_tip);
            return false;
        }
        if (TextUtils.isEmpty(password.getText().toString().trim())) {
            toast(R.string.password_tip);
            return false;
        }
        if (TextUtils.isEmpty(surePwd.getText().toString().trim())) {
            toast(R.string.admin_sure_psw_hint);
            return false;
        }
        if (!password.getText().toString().trim().equals(surePwd.getText().toString().trim())) {
            toast(R.string.sure_pwd_password);
            return false;
        }
        return true;
    }

    public void ClickLeft(View view) {
        finish();
    }
}
