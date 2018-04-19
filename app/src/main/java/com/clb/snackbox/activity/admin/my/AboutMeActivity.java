package com.clb.snackbox.activity.admin.my;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.clb.clblibrary.activity.RootActivity;
import com.clb.snackbox.R;

/**
 * 关于我们，显示版本等信息
 */

public class AboutMeActivity extends RootActivity {
    private TextView version;
    private TextView checkUpData;
    private TextView title;
    private ImageView leftIcon;

    @Override
    protected int loadLayout() {
        return R.layout.ui_about_me;
    }

    @Override
    protected void initView() {

        title = $View(R.id.centerTitle);
        leftIcon = $View(R.id.leftImage);
        version = $View(R.id.version);
        checkUpData = $View(R.id.check_upData);

        title.setText(R.string.admin_about_me);
        leftIcon.setImageResource(R.mipmap.left_icon);

        try {

            version.setText(getString(R.string.app_name) + "V" + getAppVersion(getPackageName()));

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        checkUpData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast(R.string.is_new);
            }
        });

    }

    private String getAppVersion(String packageName) throws PackageManager.NameNotFoundException {

        PackageInfo packageInfo = getPackageManager().getPackageInfo(packageName, 0);
        String appVersion = packageInfo.versionName;
        return appVersion;
    }
}
