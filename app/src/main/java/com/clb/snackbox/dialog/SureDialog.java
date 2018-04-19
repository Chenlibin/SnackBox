package com.clb.snackbox.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.clb.clblibrary.dialog.RootDialog;
import com.clb.snackbox.R;

public abstract class SureDialog extends RootDialog {

    private TextView tips;
    private Button cancelButton;
    private Button okDoneButton;

    public SureDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int loadLayout() {
        return R.layout.dialog_sure;
    }

    @Override
    protected void initView() {

        tips = $View(R.id.tips);
        cancelButton = $View(R.id.cancel);
        okDoneButton = $View(R.id.okDone);

        tips.setText(R.string.isSure);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
        okDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
                sureToDo();
            }
        });

    }

    protected abstract void sureToDo();
}
