package com.clb.snackbox.activity.admin.control;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.clb.clblibrary.activity.RootActivity;
import com.clb.snackbox.R;
import com.clb.snackbox.domain.GoodData;

/**
 * Created by Liber on 2018/3/17.
 * <p>
 * 发布商品，修改、删除、添加
 * 可以更改商品数量，一改所有数据数量都一样
 * 商品的日期，等等的信息在这里修改
 * 可以跳到一个统一的activity(修改商品信息)，带数据
 */

public class GoodsActivity extends RootActivity {

    private TextView centerTitle;
    private ImageView leftIcon;
    private ImageView rightIcon;

    @Override
    protected int loadLayout() {
        return R.layout.ui_admin_goods;
    }

    @Override
    protected void initView() {
        centerTitle = $View(R.id.centerTitle);
        leftIcon = $View(R.id.leftImage);
        rightIcon = $View(R.id.rightImage);

        centerTitle.setText(R.string.admin_goods);
        leftIcon.setImageResource(R.mipmap.left_icon);
        rightIcon.setImageResource(R.mipmap.add);
    }

    @Override
    public void ClickRight(View view) {
        GoodData addData = null;
        Intent intent = new Intent(this, ChangeAddGoodActivity.class);
        intent.putExtra("title", $str(R.string.add_good));
        intent.putExtra("goodData", addData);
        jump(intent);
    }
}
