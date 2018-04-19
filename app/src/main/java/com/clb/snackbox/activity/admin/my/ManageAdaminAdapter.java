package com.clb.snackbox.activity.admin.my;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.clb.clblibrary.adapter.RecycleAdapter;
import com.clb.snackbox.R;
import com.clb.snackbox.domain.ManagementAdaminData;

import java.util.List;

public class ManageAdaminAdapter extends RecycleAdapter<ManagementAdaminData, ManageAdaminAdapter.ThisTag> {

    public ManageAdaminAdapter(List<ManagementAdaminData> data, Context context) {
        super(data, context);
    }

    @Override
    public int loadItemView() {
        return R.layout.item_management_admin;
    }

    @Override
    public ThisTag instanceTag(View convertView) {
        return new ThisTag(convertView);
    }

    @Override
    public void handDataAndView(ThisTag t, ManagementAdaminData managementAdaminData, int position) {

        t.resgisterName.setText(managementAdaminData.getAdminName());
        t.resgisterPhone.setText(managementAdaminData.getAdminPhone());

    }

    public class ThisTag extends RecycleAdapter.RecycleTag {

        public TextView resgisterName;
        public TextView resgisterPhone;

        public ThisTag(View itemView) {
            super(itemView);

            resgisterName = $View(R.id.resigist_name);
            resgisterPhone = $View(R.id.resigist_phone);

        }
    }
}
