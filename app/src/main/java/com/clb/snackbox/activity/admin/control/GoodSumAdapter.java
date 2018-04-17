package com.clb.snackbox.activity.admin.control;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.clb.clblibrary.adapter.BaseListAdapter;
import com.clb.snackbox.R;
import com.clb.snackbox.domain.GoodData;

import java.util.List;

public class GoodSumAdapter extends BaseListAdapter<GoodData, GoodSumAdapter.ThisTag> {

    public GoodSumAdapter(Context context, List<GoodData> datas) {
        super(context, datas);
    }

    @Override
    public int loadItemView() {
        return R.layout.item_good_sum;
    }

    @Override
    public ThisTag instanceTag(View convertView) {
        return new ThisTag(convertView);
    }

    @Override
    public void handDataAndView(ThisTag thisTag, GoodData goodSumData, int position) {

        thisTag.goodName.setText(goodSumData.getGoodName());
        thisTag.saleNumber.setText(goodSumData.getSaleNumber());
        
    }

    public class ThisTag extends BaseListAdapter.Tag {

        public TextView goodName;
        public TextView saleNumber;

        public ThisTag(View view) {
            super(view);
            goodName = $View(R.id.good_name);
            saleNumber = $View(R.id.sale_number);

        }
    }
}
