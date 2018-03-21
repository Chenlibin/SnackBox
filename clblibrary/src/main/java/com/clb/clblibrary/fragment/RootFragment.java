package com.clb.clblibrary.fragment;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.clb.clblibrary.activity.RootActivity;

/**
 * Created by Liber on 2018/3/17.
 */

public abstract class RootFragment extends Fragment {
    private View mView;
    protected RootActivity activity;

    protected BluetoothManager bluetoothManager;
    protected BluetoothAdapter bluetoothAdapter;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (RootActivity) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        if (mView != null) {
            ViewGroup parent = (ViewGroup) mView.getParent();
            if (parent != null) {
                parent.removeView(mView);
            }
        } else {
            mView = inflater.inflate(loadLayout(), container, false);
            initAfterCreate();
            insertInit();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                WindowManager.LayoutParams layoutParams = activity.getWindow().getAttributes();
                layoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | layoutParams.flags);
            }

        }

//        initBlueTooth();

        return mView;
    }

//    private void initBlueTooth() {
//        bluetoothManager = (BluetoothManager) getActivity().getSystemService(getActivity().BLUETOOTH_SERVICE);
//        bluetoothAdapter = bluetoothManager.getAdapter();
//    }

    protected void insertInit() {

    }

    public abstract int loadLayout();

    public abstract void initAfterCreate();

    protected <T extends View> T $View(int id) {
        return (T) mView.findViewById(id);
    }

    protected String $str(int id) {
        return getString(id);
    }

    public final void toast(final String msg) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }

    public final void toast(final int msg) {
        toast(getString(msg));
    }

    public void jumpTo(Class<?> clazz) {
        startActivity(new Intent(getActivity(), clazz));
    }

    public void jumpTo(Intent intent) {
        startActivity(intent);
    }

    public void jumpAndFinish(Class<?> clazz) {
        startActivity(new Intent(getActivity(), clazz));
        getActivity().finish();
    }


}
