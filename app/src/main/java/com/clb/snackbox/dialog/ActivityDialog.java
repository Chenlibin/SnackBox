package com.clb.snackbox.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.Window;

import com.clb.snackbox.R;

/**
 * Created by Liber on 2018/3/21.
 * <p>
 * 作用：三个活动管理都来到这里，弹框出来
 */

public abstract class ActivityDialog extends Dialog {

    public ActivityDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_activities);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        initView();
    }

    //初始化想要的控件
    protected abstract void initView();

}
