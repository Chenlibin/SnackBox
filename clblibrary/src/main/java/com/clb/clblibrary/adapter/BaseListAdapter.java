package com.clb.clblibrary.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.clb.clblibrary.utils.ViewUtil;

import java.util.List;


/**
 * Created by nopointer on 2017/4/8.
 */

public abstract class BaseListAdapter<D, T extends BaseListAdapter.Tag> extends BaseAdapter {

    protected Context context;
    protected List<D> datas = null;
    protected DisplayMetrics dm = new DisplayMetrics();

    public BaseListAdapter(Context context, List<D> datas) {
        this.context = context;
        this.datas = datas;
        ViewUtil.load(context);
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public D getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final D d = datas.get(position);
        T t;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(loadItemView(), parent,false);
            t = instanceTag(convertView);
        } else {
            t = (T) convertView.getTag();
        }
        handDataAndView(t, d, position);
        return convertView;
    }

    public abstract int loadItemView();

    public abstract T instanceTag(View convertView);

    public abstract void handDataAndView(T t, D d, int position);

    public static class Tag {
        public View view;

        public Tag(View view) {
            this.view = view;
            view.setTag(this);
        }

        protected <V extends View> V $View(int id) {
            return (V) view.findViewById(id);
        }
    }

}
