package com.clb.snackbox.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.clb.clblibrary.activity.RootActivity;
import com.clb.snackbox.R;
import com.clb.snackbox.activity.admin.ControlFragment;
import com.clb.snackbox.activity.admin.MyFragment;

import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Liber on 2018/3/15.
 * <p>
 * 作用：主要是两个fragment的显示，控制显示对应的fragment
 */

public class AdminActivity extends RootActivity {

    private MagicIndicator magicIndicator;

    private final String[] title = new String[]{"管理", "我的"};
    private final int[] iconImages = new int[]{R.mipmap.no_control, R.mipmap.no_admin};
    private final int[] selectIconImages = new int[]{R.mipmap.control, R.mipmap.admin};
    private FragmentContainerHelper fragmentContainerHelper = new FragmentContainerHelper();

    private List<Fragment> fragments = new ArrayList<>();
    private List<String> mDataList = Arrays.asList(title);

    @Override
    protected int loadLayout() {
        return R.layout.ui_admin;
    }

    @Override
    protected void initView() {
        TextView centerTitle = $View(R.id.centerTitle);
        centerTitle.setText(R.string.admin_title);

        fragments.add(new ControlFragment());
        fragments.add(new MyFragment());


        //设置fragment
        initMagicIndicator();
        //打开默认的fragment
        switchPages(0);
    }

    private void switchPages(int index) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment fragment;
        for (int i = 0; i < fragments.size(); i++) {
            if (i == index) {
                continue;
            }
            fragment = fragments.get(i);
            if (fragment.isAdded()) {
                fragmentTransaction.hide(fragment);
            }
        }

        fragment = fragments.get(index);
        if (fragment.isAdded()) {
            fragmentTransaction.show(fragment);
        } else {
            fragmentTransaction.add(R.id.fragment_container, fragment);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void initMagicIndicator() {
        magicIndicator = $View(R.id.magic_indicator);
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int i) {

                CommonPagerTitleView commonPagerTitleView = new CommonPagerTitleView(context);

                View pagerLayout = LayoutInflater.from(context).inflate(R.layout.magic_indicator_title, null);
                final ImageView imageView = pagerLayout.findViewById(R.id.title_image);
                final TextView textView = pagerLayout.findViewById(R.id.title_text);
                textView.setText(mDataList.get(i));
                imageView.setImageResource(iconImages[i]);

                commonPagerTitleView.setContentView(pagerLayout);
                commonPagerTitleView.setOnPagerTitleChangeListener(new CommonPagerTitleView.OnPagerTitleChangeListener() {
                    @Override
                    public void onSelected(int i, int i1) {
                        textView.setTextColor(0xff1296DB);
                    }

                    @Override
                    public void onDeselected(int i, int i1) {
                        textView.setTextColor(0xff353739);
                    }

                    @Override
                    public void onLeave(int i, int i1, float v, boolean b) {
                        imageView.setImageResource(iconImages[i]);
                    }

                    @Override
                    public void onEnter(int i, int i1, float v, boolean b) {
                        imageView.setImageResource(selectIconImages[i]);
                    }
                });

                commonPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fragmentContainerHelper.handlePageSelected(i);
                        switchPages(i);
                    }
                });

                return commonPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        fragmentContainerHelper.attachMagicIndicator(magicIndicator);
    }
}
