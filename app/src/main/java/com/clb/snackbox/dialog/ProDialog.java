package com.clb.snackbox.dialog;

import android.content.Context;
import android.support.annotation.NonNull;

import com.clb.clblibrary.dialog.RootDialog;
import com.clb.snackbox.R;

public class ProDialog extends RootDialog {

    public ProDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int loadLayout() {
        return R.layout.dialog_progress;
    }

    @Override
    protected void initView() {

    }
}
