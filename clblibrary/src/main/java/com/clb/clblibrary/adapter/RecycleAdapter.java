package com.clb.clblibrary.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clb.clblibrary.utils.ViewUtil;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.List;

/**
 * Created by nopointer on 2018/1/5.
 */

public abstract class RecycleAdapter<D, H extends RecycleAdapter.RecycleTag> extends SwipeMenuRecyclerView.Adapter<H> {

    protected List<D> data = null;
    protected Context context = null;
    private LayoutInflater layoutInflater;

    protected DisplayMetrics dm = new DisplayMetrics();


    public RecycleAdapter(List<D> data, Context context) {
        this.data = data;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        ViewUtil.load(context);
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
    }

    @Override
    public H onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = layoutInflater.inflate(loadItemView(), parent, false);
        return instanceTag(convertView);
    }

    @Override
    public void onBindViewHolder(H holder, int position) {
        D d = data.get(position);
        handDataAndView(holder, d, position);
    }


    public abstract int loadItemView();

    public abstract H instanceTag(View convertView);

    public abstract void handDataAndView(H t, D d, int position);

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class RecycleTag extends RecyclerView.ViewHolder {
        public View view;

        public RecycleTag(View itemView) {
            super(itemView);
            this.view = itemView;
        }

        protected <V extends View> V $View(int id) {
            return (V) view.findViewById(id);
        }
    }
}
