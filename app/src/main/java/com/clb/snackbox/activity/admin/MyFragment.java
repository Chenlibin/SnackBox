package com.clb.snackbox.activity.admin;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.clb.clblibrary.fragment.RootFragment;
import com.clb.snackbox.R;
import com.clb.snackbox.activity.QRActivity;
import com.clb.snackbox.activity.admin.my.ControlAdminActivity;
import com.clb.snackbox.activity.login.LoginActivity;

/**
 * Created by Liber on 2018/3/17.
 */

public class MyFragment extends RootFragment implements View.OnClickListener {
    private RelativeLayout controlAdminLayout;
    private RelativeLayout goToBuyLayout;
    private RelativeLayout loginOutLayout;

    @Override
    public int loadLayout() {
        return R.layout.fragment_my;
    }

    @Override
    public void initAfterCreate() {

        controlAdminLayout = $View(R.id.control_admin);
        goToBuyLayout = $View(R.id.go_to_buy);
        loginOutLayout = $View(R.id.login_out);


        controlAdminLayout.setOnClickListener(this);
        goToBuyLayout.setOnClickListener(this);
        loginOutLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (getActivity() != null) {
            switch (v.getId()) {
                case R.id.control_admin:
                    startActivity(new Intent(getActivity(), ControlAdminActivity.class));
                    break;
                case R.id.go_to_buy:
                    startActivity(new Intent(getActivity(), QRActivity.class));
                    break;
                case R.id.login_out:
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    getActivity().finish();
                    break;
            }
        } else {
            toast(R.string.error_tip);
        }

    }
}
