package com.clb.snackbox.activity.qr;

import android.view.View;

import com.clb.clblibrary.fragment.RootFragment;
import com.clb.snackbox.R;
import com.clb.snackbox.activity.login.LoginActivity;

/**
 * Created by Liber on 2018/3/27.
 *
 * 作用：三个跳转，，一个是用户的意见，一个是获得这个宿舍编号的购买记录，一个是登录管理员
 */

public class UserFragment extends RootFragment implements View.OnClickListener {


    @Override
    public int loadLayout() {
        return R.layout.fragment_user;
    }

    @Override
    public void initAfterCreate() {

        $View(R.id.user_advise).setOnClickListener(this);
        $View(R.id.user_recode).setOnClickListener(this);
        $View(R.id.user_to_admin).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (getActivity() != null) {
            switch (v.getId()) {
                case R.id.user_advise:
                    break;
                case R.id.user_recode:
                    break;
                case R.id.user_to_admin:
                    jumpAndFinish(LoginActivity.class);
                    break;
            }
        }

    }
}
