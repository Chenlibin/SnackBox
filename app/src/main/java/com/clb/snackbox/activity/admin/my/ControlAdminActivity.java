package com.clb.snackbox.activity.admin.my;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.clb.clblibrary.activity.RootActivity;
import com.clb.snackbox.R;

/**
 * Created by Liber on 2018/3/17.
 * <p>
 * 作用：管理管理员，删除、添加
 */

public class ControlAdminActivity extends RootActivity {

    private TextView centerTitle;
    private ImageView leftIcon;

    @Override
    protected int loadLayout() {
        return R.layout.ui_admin_control_admin;
    }

    @Override
    protected void initView() {
        centerTitle = $View(R.id.centerTitle);
        leftIcon = $View(R.id.leftImage);

        centerTitle.setText(R.string.admin_control_admin);
        leftIcon.setImageResource(R.mipmap.left_icon);
    }

    public void ClickLeft(View view) {
        finish();
    }
}
