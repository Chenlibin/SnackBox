package com.clb.snackbox.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.clb.snackbox.R;
import com.clb.snackbox.domain.ActivitiesData;

/**
 * Created by Liber on 2018/3/21.
 * <p>
 * 作用：三个活动管理都来到这里，弹框出来
 */

public abstract class ActivityDialog extends Dialog {

    private EditText instruction;          //说明
    private EditText fullPrice;            //满多少
    private EditText breakPrice;           //减多少
    private ActivitiesData activitiesData;
    private String titleContent;
    private TextView title;

    public ActivityDialog(@NonNull Context context, ActivitiesData activitiesData, String title) {
        super(context);
        this.activitiesData = activitiesData;
        titleContent = title;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_activities);
        setCancelable(true);
        setCanceledOnTouchOutside(false);

        initView();
        initButton();
    }

    //初始化控件和设置默认值
    private void initView() {

        instruction = findViewById(R.id.instruction);
        fullPrice = findViewById(R.id.full_price);
        breakPrice = findViewById(R.id.break_price);

        title = findViewById(R.id.title);
        title.setText(titleContent);

        //设置默认值
//        if (activitiesData != null) {
//            instruction.setText(activitiesData.getInstruction());
//            fullPrice.setText(activitiesData.getFullPrice());
//            breakPrice.setText(activitiesData.getBreakPrice());
//        }

    }

    //两个按钮的监听
    private void initButton() {
        findViewById(R.id.cancle_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });

        findViewById(R.id.sure_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
//                String instructionText = instruction.getText().toString().trim();
//                if (TextUtils.isEmpty(instructionText)) {
//                    activitiesData.setInstruction(null);
//                } else {
//                    activitiesData.setInstruction(instructionText);
//                }
//
//                String fullText = fullPrice.getText().toString().trim();
//                if (TextUtils.isEmpty(fullText)) {
//                    activitiesData.setFullPrice(null);
//                } else {
//                    activitiesData.setFullPrice(fullText);
//                }
//
//                String breakText = breakPrice.getText().toString().trim();
//                if (TextUtils.isEmpty(breakText)) {
//                    activitiesData.setBreakPrice(null);
//                } else {
//                    activitiesData.setBreakPrice(breakText);
//                }
                changeActivity(activitiesData);
            }
        });
    }

    //将填写的内容上传到后台服务器
    protected abstract void changeActivity(ActivitiesData activitiesData);

}
