package com.zhangqie.videosummary.fragment;

import android.content.res.Configuration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhangqie.videosummary.R;
import com.zhangqie.videosummary.adapter.AdapterRecyclerViewVideo;
import com.zhangqie.zqvideolibrary.ZQMediaManager;
import com.zhangqie.zqvideolibrary.ZQUtils;
import com.zhangqie.zqvideolibrary.ZQVideoPlayer;


/**
 * Created by zhangqie on 2017/10/12.
 */

public class ZQFragmentTabItem extends  BaseFragment{

    RecyclerView recyclerView;
    AdapterRecyclerViewVideo adapterVideoList;

    public static ZQFragmentTabItem newInstance() {
        ZQFragmentTabItem fragment = new ZQFragmentTabItem();
        return fragment;
    }


    private View rootView;
    @Override
    protected View getContentView(LayoutInflater inflater, ViewGroup container) {
        rootView = inflater.inflate(R.layout.recyclerview_video_layout, container, false);
        return rootView;
    }

    @Override
    protected void initViews(View contentView) {

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapterVideoList = new AdapterRecyclerViewVideo(getActivity());
        recyclerView.setAdapter(adapterVideoList);
        recyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {
            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
                ZQVideoPlayer jzvd = (ZQVideoPlayer) view.findViewById(R.id.videoplayer);
                if (jzvd != null && ZQUtils.dataSourceObjectsContainsUri(jzvd.dataSourceObjects, ZQMediaManager.getCurrentDataSource())) {
                    ZQVideoPlayer.releaseAllVideos();
                }
            }
        });

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

    @Override
    public void onPause() {
        super.onPause();
        ZQVideoPlayer.releaseAllVideos();
    }
}


