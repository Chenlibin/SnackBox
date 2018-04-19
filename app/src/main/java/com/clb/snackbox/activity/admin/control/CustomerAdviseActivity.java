package com.clb.snackbox.activity.admin.control;

import android.support.v7.widget.LinearLayoutManager;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.clb.clblibrary.activity.RootActivity;
import com.clb.clblibrary.utils.ViewUtil;
import com.clb.snackbox.R;
import com.clb.snackbox.domain.CustomerAdviseData;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liber on 2018/3/17.
 * <p>
 * 作用：管理所有用户的意见
 */

public class CustomerAdviseActivity extends RootActivity {

    private ImageView leftIcon;

    private SwipeMenuRecyclerView recyclerView;
    private CustomerAdviseAdapter adapter;
    List<CustomerAdviseData> list = new ArrayList<CustomerAdviseData>();

    @Override
    protected int loadLayout() {
        return R.layout.ui_admin_customer_advise;
    }

    @Override
    protected void initView() {

        TextView centerTitle = $View(R.id.centerTitle);
        centerTitle.setText(R.string.admin_customer_advise);
        leftIcon = $View(R.id.leftImage);
        leftIcon.setImageResource(R.mipmap.left_icon);

        recyclerView = $View(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setSwipeMenuCreator(swipeMenuCreator);
        recyclerView.setSwipeMenuItemClickListener(listener);
        recyclerView.setHasFixedSize(true);

        makeData();

        adapter = new CustomerAdviseAdapter(list, this);
        recyclerView.setAdapter(adapter);

    }

    private void makeData() {

        list.clear();
        //后台获取数据

    }

    //侧滑菜单
    private SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
            SwipeMenuItem delectItem = new SwipeMenuItem(getUI())
                    .setBackgroundColor(0xffff555b)
                    .setText(R.string.delect)
                    .setTextColor(0xffffffff)
                    .setWeight(ViewUtil.dip2px(70.0f))
                    .setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
            swipeRightMenu.addMenuItem(delectItem);
        }
    };

    //监听侧滑菜单的点击
    private SwipeMenuItemClickListener listener = new SwipeMenuItemClickListener() {
        @Override
        public void onItemClick(SwipeMenuBridge menuBridge) {

            // RecyclerView的Item的position。就是adapter对应的item
            int position = menuBridge.getAdapterPosition();
            // 菜单在RecyclerView的Item中的Position。就是滑动是点击的position
            int menuPosition = menuBridge.getPosition();
            if (menuPosition == 0) {
                //删除对应后台数据
            }
        }
    };

}
