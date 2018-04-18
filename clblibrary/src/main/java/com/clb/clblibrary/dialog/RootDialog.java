package com.clb.clblibrary.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.clb.clblibrary.R;


public abstract class RootDialog extends Dialog {

    private Context context;

    public RootDialog(@NonNull Context context) {
        super(context, R.style.dialog_style);
        _init_(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(loadLayout());
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        initView();
    }

    protected abstract int loadLayout();

    protected abstract void initView();

    private void _init_(Context context) {
        this.context = context;
    }

    protected void closeDialog() {
        cancel();
        onCancel();
    }

    protected RootDialog showDialog() {
        show();
        return this;
    }

    public void onCancel() {
    }

    protected <T extends View> T $View(int id) {
        return (T) findViewById(id);
    }

    protected String $str(int id) {
        return context.getString(id);
    }


    public final void toast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
    }

    public final void toast(int msg) {
        toast(getContext().getString(msg));
    }

}
