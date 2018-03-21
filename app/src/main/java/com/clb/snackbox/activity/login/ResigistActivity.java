package com.clb.snackbox.activity.login;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.clb.clblibrary.activity.RootActivity;
import com.clb.snackbox.R;

/**
 * Created by Liber on 2018/3/13.
 */

public class ResigistActivity extends RootActivity {

    private TextView centerTitle;
    private ImageView leftInco;
    private TextView resigistNumber;
    private TextView codeNumber;
    private TextView password;

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

        resigistNumber = $View(R.id.resigist_number);
        codeNumber = $View(R.id.code_number);
        password = $View(R.id.password);
    }

    public void submit(View view) {
        if (entry()) {
            toast("注册成功");
        } else {

        }
    }

    private boolean entry() {

        if (TextUtils.isEmpty(resigistNumber.getText().toString().trim())) {
            toast(R.string.admin_tip);
            return false;
        }
        //验证码
//        if (TextUtils.isEmpty(codeNumber.getText().toString().trim())){
//            toast(R.string.code_number_hint);
//            return false;
//        }

        if (TextUtils.isEmpty(password.getText().toString().trim())) {
            toast(R.string.password_tip);
            return false;
        }


        return true;
    }

    public void ClickLeft(View view) {
        finish();
    }
}
