package com.zhangqie.videosummary.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhangqie.videosummary.R;


/**
 * Created by zhangqie on 2017/10/11.
 */

public class ZQTabFragment extends BaseFragment {

    TabLayout tablayout;
    ViewPager viewPager;
    private View rootView;
    private Fragment[] mFragmentArrays = new Fragment[2];

    private String[] mTabTitles = new String[2];


    /***
     * 全屏播放器放在MainActivity中
     */
    private static ZQFragmentActivity mainActivity;

    public static ZQTabFragment newInstance(Context context) {
        ZQTabFragment fragment = new ZQTabFragment();
        mainActivity = (ZQFragmentActivity)context;
        return fragment;
    }


    @Override
    protected View getContentView(LayoutInflater inflater, ViewGroup container) {
        rootView = inflater.inflate(R.layout.tab_layout, container, false);
        return rootView;
    }

    @Override
    protected void initViews(View contentView) {
        tablayout = (TabLayout) rootView.findViewById(R.id.tablayout);
        viewPager = (ViewPager) rootView.findViewById(R.id.tab_viewpager);
        initView();
    }


    private void initView() {
        mTabTitles[0] = "推荐";
        mTabTitles[1] = "热点";
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        mFragmentArrays[0] = ZQFragmentTabItem.newInstance();
        mFragmentArrays[1] = ZQFragmentTabItem.newInstance();
        PagerAdapter pagerAdapter = new MyViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        //将ViewPager和TabLayout绑定
        tablayout.setupWithViewPager(viewPager);
    }

    final class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentArrays[position];
        }


        @Override
        public int getCount() {
            return mFragmentArrays.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabTitles[position];

        }
    }


    @Override
    protected void initListeners() {

    }

    @Override
    protected void initDatas() {
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }




    /**
     * 下面的这几个Activity的生命状态很重要
     */
    @Override
    public void onPause() {
        super.onPause();
        }
    }




