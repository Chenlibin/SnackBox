package com.clb.snackbox.activity.admin.control;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.clb.clblibrary.activity.RootActivity;
import com.clb.snackbox.R;
import com.clb.snackbox.domain.GoodData;

import me.panpf.sketch.SketchImageView;

public class ChangeAddGoodActivity extends RootActivity {

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
            }
        });

    }
}
