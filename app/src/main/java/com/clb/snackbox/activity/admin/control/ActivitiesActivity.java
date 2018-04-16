package com.clb.snackbox.activity.admin.control;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.clb.clblibrary.activity.RootActivity;
import com.clb.snackbox.R;
import com.clb.snackbox.dialog.ActivityDialog;
import com.clb.snackbox.domain.ActivitiesData;

/**
 * Created by Liber on 2018/3/17.
 * <p>
 * 作用：管理所有的活动，包括添加、删除、修改,最多三个活动,显示
 */

public class ActivitiesActivity extends RootActivity implements View.OnClickListener {

    private ImageView leftIcon;
    private LinearLayout oneActivity;
    private LinearLayout twoActivity;
    private LinearLayout threeActivity;

    @Override
    protected int loadLayout() {
        return R.layout.ui_admin_activities;
    }

    @Override
    protected void initView() {

        TextView centerTitle = $View(R.id.centerTitle);
        centerTitle.setText(R.string.admin_activity);
        leftIcon = $View(R.id.leftImage);
        leftIcon.setImageResource(R.mipmap.left_icon);

        oneActivity = $View(R.id.activity_one);
        twoActivity = $View(R.id.activity_two);
        threeActivity = $View(R.id.activity_three);

        oneActivity.setOnClickListener(this);
        twoActivity.setOnClickListener(this);
        threeActivity.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_one:
                makeActivitiesDialog($str(R.string.activities_one_tip));
                break;
            case R.id.activity_two:
                makeActivitiesDialog($str(R.string.activities_two_tip));
                break;
            case R.id.activity_three:
                makeActivitiesDialog($str(R.string.activities_three_tip));
                break;
        }
    }

    //选择的是那个活动
    private void makeActivitiesDialog(String text) {

        new ActivityDialog(this, null, text) {
            @Override
            protected void changeActivity(ActivitiesData activitiesData) {

            }
        }.show();

    }
}
