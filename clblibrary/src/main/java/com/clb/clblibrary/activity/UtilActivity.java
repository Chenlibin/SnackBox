package com.clb.clblibrary.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Liber on 2018/3/8.
 */

public class UtilActivity extends FragmentActivity {

    protected <T extends View> T $View(int id) {
        return (T) findViewById(id);
    }

    protected String $str(int id) {
        return getString(id);
    }

    public FragmentActivity getUI() {
        return this;
    }

    public final void toast(final int msg) {
        toast(getString(msg));
    }

    public final void toast(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getUI(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public final void toast(final String msg, int after) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toast(msg);
            }
        }, after);
    }

    public final void toast(int msg, int after) {
        toast(getString(msg), after);
    }



    public void jump(Class<?> clz) {
        if (clz != null)
            startActivity(new Intent(this, clz));
    }

    public void jump(Intent intent) {
        startActivity(intent);

    }

    public void jumpAndFish(Class<?> clazz) {
        startActivity(new Intent(this, clazz));
        finish();
    }

    public void jumpAndFinsh(Class<?> clz) {
        jump(clz);
        finish();
    }
}
