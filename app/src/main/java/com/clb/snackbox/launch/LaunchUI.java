package com.clb.snackbox.launch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.clb.snackbox.R;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import static android.R.attr.data;


/**
 * 引导界面，可以显示打开app的界面。。然后正式进入app
 */
public class LaunchUI extends Activity {
    private int REQUEST_CODE;
    private int requestCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        ZXingLibrary.initDisplayOpinion( this );
        Intent intent = new Intent( LaunchUI.this, CaptureActivity.class );
        startActivityForResult( intent, REQUEST_CODE );

        //处理扫描结果（在界面上显示）
        if (requestCode == REQUEST_CODE) if (0!= data) {

            if (data == 0) {
                return;
            }
            if (data == CodeUtils.RESULT_SUCCESS) {
                setContentView( R.layout.activity_main );
            } else if (data == CodeUtils.RESULT_FAILED) {
                Toast.makeText( LaunchUI.this, "解析二维码失败", Toast.LENGTH_LONG ).show();
            }
        }
    }}