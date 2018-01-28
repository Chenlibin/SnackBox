package com.clb.snackbox.launch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.clb.snackbox.R;
import com.dtr.zxing.activity.CaptureActivity;
/**
 * 引导界面，可以显示打开app的界面。。然后正式进入app
 */
public class LaunchUI extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}


