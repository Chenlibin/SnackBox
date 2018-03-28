package com.clb.snackbox.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.clb.clblibrary.activity.RootActivity;
import com.clb.snackbox.R;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.camera.CameraManager;

/**
 * Created by Liber on 2018/3/7.
 */

/**
 * 扫描二维码进入买买买界面
 */
public class QRActivity extends RootActivity {

    private final int REQUEST_CODE = 111;

    @Override
    protected int loadLayout() {
        return R.layout.ui_qr;
    }

    @Override
    protected void initView() {
        CameraManager.init(this);
        Intent intent = new Intent(QRActivity.this, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //处理扫描结束
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String title = bundle.getString(CodeUtils.RESULT_STRING);
//                    Toast.makeText(this, "解析结果:" + title, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, AfterQRActivity.class);
                    intent.putExtra("title", title);
                    startActivity(intent);
                    finish();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(QRActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }

    }
}
