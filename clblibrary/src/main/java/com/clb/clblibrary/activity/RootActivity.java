package com.clb.clblibrary.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import com.clb.clblibrary.utils.ActivtyCollectorUtils;
import com.clb.clblibrary.utils.ViewUtil;

/**
 * Created by Liber on 2018/3/7.
 */

public abstract class RootActivity extends UtilActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(loadLayout());
        //添加activity
        ActivtyCollectorUtils.addActivity(this);
        ViewUtil.load(this);
        initView();
    }
    //设置布局
    protected abstract int loadLayout();

    //初始化
    protected abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivtyCollectorUtils.removeActivity(this);
    }
}
