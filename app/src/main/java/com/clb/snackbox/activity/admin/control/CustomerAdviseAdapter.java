package com.clb.snackbox.activity.admin.control;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.clb.clblibrary.adapter.RecycleAdapter;
import com.clb.snackbox.R;
import com.clb.snackbox.domain.CustomerAdviseData;

import java.util.List;

public class CustomerAdviseAdapter extends RecycleAdapter<CustomerAdviseData, CustomerAdviseAdapter.ThisTag> {


    public CustomerAdviseAdapter(List<CustomerAdviseData> data, Context context) {
        super(data, context);
    }

    @Override
    public int loadItemView() {
        return R.layout.item_customer_advise;
    }

    @Override
    public ThisTag instanceTag(View convertView) {
        return new ThisTag(convertView);
    }

    @Override
    public void handDataAndView(ThisTag t, CustomerAdviseData customerAdviseData, int position) {
        t.scanId.setText(customerAdviseData.getScanId());
        t.time.setText(customerAdviseData.getTime());
        t.content.setText(customerAdviseData.getContent());
    }

    public static class ThisTag extends RecycleAdapter.RecycleTag {

        public TextView scanId;
        public TextView time;
        public TextView content;

        public ThisTag(View itemView) {
            super(itemView);

            scanId = $View(R.id.scanId);
            time = $View(R.id.time);
            content = $View(R.id.content);

        }
    }
}
