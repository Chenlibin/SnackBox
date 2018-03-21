package com.clb.snackbox.activity.admin;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.clb.clblibrary.fragment.RootFragment;
import com.clb.snackbox.R;
import com.clb.snackbox.activity.admin.control.ActivitiesActivity;
import com.clb.snackbox.activity.admin.control.CustomerAdviseActivity;
import com.clb.snackbox.activity.admin.control.GoodSumActivity;
import com.clb.snackbox.activity.admin.control.GoodsActivity;

/**
 * Created by Liber on 2018/3/17.
 * <p>
 * 作用：主要是控制价格，添加商品，添加活动等等
 */

public class ControlFragment extends RootFragment implements View.OnClickListener {
    private RelativeLayout activityLayout;
    private RelativeLayout goodsLayout;
    private RelativeLayout customerAdviseLayout;
    private RelativeLayout goodSumLayout;

    @Override
    public int loadLayout() {
        return R.layout.fragmengt_admin;
    }

    @Override
    public void initAfterCreate() {
        activityLayout = $View(R.id.activity);
        goodsLayout = $View(R.id.goods);
        customerAdviseLayout = $View(R.id.customer_advise);
        goodSumLayout = $View(R.id.good_sum);

        activityLayout.setOnClickListener(this);
        goodsLayout.setOnClickListener(this);
        customerAdviseLayout.setOnClickListener(this);
        goodSumLayout.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (getActivity() != null) {
            switch (v.getId()) {
                case R.id.activity:
                    startActivity(new Intent(getActivity(), ActivitiesActivity.class));
                    break;
                case R.id.goods:
                    startActivity(new Intent(getActivity(), GoodsActivity.class));
                    break;
                case R.id.customer_advise:
                    startActivity(new Intent(getActivity(), CustomerAdviseActivity.class));
                    break;
                case R.id.good_sum:
                    startActivity(new Intent(getActivity(), GoodSumActivity.class));
                    break;
            }
        } else {
            toast(R.string.error_tip);
        }
    }


}
