package com.clb.snackbox.activity.admin.control;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.clb.clblibrary.activity.PictureActivity;
import com.clb.snackbox.R;
import com.clb.snackbox.domain.GoodData;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.List;

import me.panpf.sketch.SketchImageView;

/**
 * 添加、修改商品信息的界面
 * 添加和修改都是来到这个界面，，如果是添加的，带空数据，如果是修改则带当前商品的数据进来
 */

public class ChangeAddGoodActivity extends PictureActivity {

    private SketchImageView goodPhoto;
    private EditText goodName;
    private EditText productData;
    private EditText goodPrice;
    private EditText goodNumber;
    private EditText goodContent;
    private TextView title;
    private ImageView leftIcon;

    @Override
    protected int loadLayout() {
        return R.layout.ui_change_add_good;
    }

    @Override
    protected void initView() {

        title = $View(R.id.centerTitle);
        title.setText(getIntent().getStringExtra("title"));
        leftIcon = $View(R.id.leftImage);
        leftIcon.setImageResource(R.mipmap.left_icon);

        goodPhoto = $View(R.id.good_photo);
        goodName = $View(R.id.good_name);
        productData = $View(R.id.production_date);
        goodPrice = $View(R.id.good_price);
        goodNumber = $View(R.id.good_number);
        goodContent = $View(R.id.good_content);

        //用于分辨是添加的还是修改的
        GoodData goodData = (GoodData) getIntent().getSerializableExtra("goodData");
        if (goodData != null) {
            goodName.setText(goodData.getGoodName());
            productData.setText(goodData.getProductionDate());
            goodPrice.setText(goodData.getGoodPrice());
            goodNumber.setText(goodData.getGoodNumber());
            goodContent.setText(goodData.getGoodContent());

            goodPhoto.displayImage(goodData.getGoodPhoto());
        }

        goodPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击选择图片
                jump2Gallery();
            }
        });

    }

    //照片选中的回调
    @Override
    protected void onImageSelect(List<LocalMedia> selectList) {
        if (selectList.size() < 1 || selectList == null) return;
        final LocalMedia localMedia = selectList.get(0);
        if (selectList.get(0).isCut()) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    goodPhoto.displayImage(localMedia.getCutPath());
                }
            });
        }
    }
}
