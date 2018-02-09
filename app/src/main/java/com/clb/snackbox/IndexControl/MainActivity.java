package com.clb.snackbox.IndexControl;

import android.app.Activity;
import android.os.Bundle;

import com.vondear.rxtools.RxTool;

;


/**
 * Created by 幻 on 2018/1/29.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxTool.init(this);


    }
}
