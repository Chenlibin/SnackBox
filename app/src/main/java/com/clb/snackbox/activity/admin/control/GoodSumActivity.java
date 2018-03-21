package com.clb.snackbox.activity.admin.control;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.clb.clblibrary.activity.RootActivity;
import com.clb.snackbox.R;

/**
 * Created by Liber on 2018/3/17.
 * <p>
 * 作用：统计所有售卖零食的总量
 */

public class GoodSumActivity extends RootActivity {

    private ImageView leftIcon;

    @Override
    protected int loadLayout() {
        return R.layout.ui_admin_good_sum;
    }

    @Override
    protected void initView() {

        TextView centerTitle = $View(R.id.centerTitle);
        centerTitle.setText(R.string.admin_good_sum);
        leftIcon = $View(R.id.leftImage);
        leftIcon.setImageResource(R.mipmap.left_icon);

    }

    public void ClickLeft(View view) {
        finish();
    }
}
