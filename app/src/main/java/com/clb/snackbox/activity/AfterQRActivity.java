package com.clb.snackbox.activity;

import android.widget.TextView;

import com.clb.clblibrary.activity.RootActivity;
import com.clb.snackbox.R;

/**
 * Created by Liber on 2018/3/27.
 * <p>
 * 扫描完成之后的界面，拿到对应的宿舍编码，
 * 然后显示购物界面
 */

public class AfterQRActivity extends RootActivity {
    private TextView centerText;

    @Override
    protected int loadLayout() {
        return R.layout.ui_after_qr;
    }

    @Override
    protected void initView() {

        centerText = findViewById(R.id.centerTitle);
        centerText.setText(getIntent().getStringExtra("title"));

    }
}
