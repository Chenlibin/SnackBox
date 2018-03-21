package com.clb.snackbox.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.clb.clblibrary.activity.RootActivity;
import com.clb.snackbox.R;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

/**
 * Created by Liber on 2018/3/7.
 */

/**
 * 扫描二维码进入买买买界面
 */
public class QRActivity extends RootActivity {

    private final int QRCODE = 111;

    @Override
    protected int loadLayout() {
        return R.layout.ui_qr;
    }

    @Override
    protected void initView() {
        Intent intent = new Intent(this, CaptureActivity.class);
        startActivityForResult(intent, QRCODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //处理扫描结束
        if (requestCode == QRCODE) {
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    toast("解析结果:" + result);
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    toast("解析二维码失败");
                }
            }
        }

    }
}
