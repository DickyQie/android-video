package com.zhangqie.videosummary.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zhangqie.videosummary.R;
import com.zhangqie.zqvideolibrary.ZQVideoPlayerStandard;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhangqie on 2017/10/11.
 */

public class ZQVideoActivity extends AppCompatActivity {

    @BindView(R.id.zqvideo)
    ZQVideoPlayerStandard zqvideo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zqvideo_layout);
        ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        zqvideo.setUp("https://scb.liaidi.com//data//video//2017//12//20171214235251279358.mp4",  ZQVideoPlayerStandard.SCREEN_WINDOW_LIST, "标题");
        zqvideo.startVideo();

    }
}
