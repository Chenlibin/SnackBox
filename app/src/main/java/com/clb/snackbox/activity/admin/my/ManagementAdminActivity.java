package com.clb.snackbox.activity.admin.my;

import android.support.v7.widget.LinearLayoutManager;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.clb.clblibrary.activity.RootActivity;
import com.clb.clblibrary.utils.ViewUtil;
import com.clb.snackbox.R;
import com.clb.snackbox.domain.ManagementAdaminData;
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
 * 作用：管理管理员，删除、添加
 */

public class ManagementAdminActivity extends RootActivity {

    private TextView centerTitle;
    private ImageView leftIcon;

    private SwipeMenuRecyclerView addManagement;
    private SwipeMenuRecyclerView delectManagement;

    List<ManagementAdaminData> addlist = new ArrayList<>();
    List<ManagementAdaminData> delectlist = new ArrayList<>();

    private ManageAdaminAdapter addAdapter;
    private ManageAdaminAdapter delectAdapter;

    @Override
    protected int loadLayout() {
        return R.layout.ui_admin_control_admin;
    }

    @Override
    protected void initView() {
        centerTitle = $View(R.id.centerTitle);
        leftIcon = $View(R.id.leftImage);

        centerTitle.setText(R.string.admin_control_admin);
        leftIcon.setImageResource(R.mipmap.left_icon);
        addManagement = $View(R.id.add_management);
        delectManagement = $View(R.id.delect_management);

        initRecyclerView();
        //获取添加的数据
        makeAddData();
        //获取可以删除的数据
        makeDelectData();

        addAdapter = new ManageAdaminAdapter(addlist, this);
        delectAdapter = new ManageAdaminAdapter(delectlist, this);

        addManagement.setAdapter(addAdapter);
        delectManagement.setAdapter(delectAdapter);

    }

    private void makeDelectData() {
        delectlist.clear();
    }

    private void makeAddData() {
        addlist.clear();
    }

    private void initRecyclerView() {

        addManagement.setLayoutManager(new LinearLayoutManager(this));
        addManagement.setSwipeMenuCreator(addMangementMenuCreator);
        addManagement.setSwipeMenuItemClickListener(addlistener);
        addManagement.setHasFixedSize(true);


        delectManagement.setLayoutManager(new LinearLayoutManager(this));
        delectManagement.setSwipeMenuCreator(delectMangementMenuCreator);
        delectManagement.setSwipeMenuItemClickListener(delectlistener);
        delectManagement.setHasFixedSize(true);

    }

    //添加管理员的侧滑菜单
    private SwipeMenuCreator addMangementMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
            SwipeMenuItem addItem = new SwipeMenuItem(getUI())
                    .setBackgroundColor(0xff00ee00)
                    .setText(R.string.add)
                    .setTextColor(0xffffffff)
                    .setWidth(ViewUtil.dip2px(70.0f))
                    .setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
            swipeRightMenu.addMenuItem(addItem);
        }
    };
    //监听侧滑菜单
    private SwipeMenuItemClickListener addlistener = new SwipeMenuItemClickListener() {
        @Override
        public void onItemClick(SwipeMenuBridge menuBridge) {
            // RecyclerView的Item的position。
            int position = menuBridge.getAdapterPosition();
            // 菜单在RecyclerView的Item中的Position。
            int menuPosition = menuBridge.getPosition();
            if (menuPosition == 0) {
                //执行添加的操作
            }
        }
    };


    //删除管理员的侧滑菜单
    private SwipeMenuCreator delectMangementMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
            SwipeMenuItem delectItem = new SwipeMenuItem(getUI())
                    .setBackgroundColor(0xffFF555B)
                    .setText(R.string.delect)
                    .setTextColor(0xffffffff)
                    .setWidth(ViewUtil.dip2px(70.0f))
                    .setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
            swipeRightMenu.addMenuItem(delectItem);
        }
    };
    //监听侧滑菜单
    private SwipeMenuItemClickListener delectlistener = new SwipeMenuItemClickListener() {
        @Override
        public void onItemClick(SwipeMenuBridge menuBridge) {
            // RecyclerView的Item的position。
            int position = menuBridge.getAdapterPosition();
            // 菜单在RecyclerView的Item中的Position。
            int menuPosition = menuBridge.getPosition();
            if (menuPosition == 0) {
                //执行删除的操作
            }
        }
    };


}
