package com.clb.snackbox.activity.admin.control;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.clb.clblibrary.activity.RootActivity;
import com.clb.snackbox.R;

/**
 * Created by Liber on 2018/3/17.
 * <p>
 * 发布商品，修改、删除、添加
 *  可以更改商品数量，一改所有数据数量都一样
 *  商品的日期，等等的信息在这里修改
 *  可以跳到一个统一的activity(修改商品信息)，带数据过去就好
 */

public class GoodsActivity extends RootActivity {

    private TextView centerTitle;
    private ImageView leftIcon;

    @Override
    protected int loadLayout() {
        return R.layout.ui_admin_goods;
    }

    @Override
    protected void initView() {
        centerTitle = $View(R.id.centerTitle);
        leftIcon = $View(R.id.leftImage);

        centerTitle.setText(R.string.admin_goods);
        leftIcon.setImageResource(R.mipmap.left_icon);
    }

    public void ClickLeft(View view) {
        finish();
    }
}
