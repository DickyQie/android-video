package com.zhangqie.videosummary.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import com.zhangqie.videosummary.R;
import com.zhangqie.videosummary.widget.FllScreenVideoView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhangqie on 2017/10/11.
 */

public class VideoViewActivity extends AppCompatActivity {


    @BindView(R.id.videoView)
    VideoView videoView;
    @BindView(R.id.fvideoView)
    FllScreenVideoView fvideoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_layout);
        ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        Uri mUri = Uri.parse("https://scb.liaidi.com//data//video//2017//12//20171214235251279358.mp4");
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(mUri);
        videoView.start();
        videoView.requestFocus();

        // videoView.start();  // 开始播放
        // videoView.pause(); // 暂停
        // videoView.seekTo(3 * 1000);//3秒处


        fvideoView.setMediaController(new MediaController(this));
        fvideoView.setVideoURI(mUri);
       
        fvideoView.requestFocus();
    }

    @Override
    protected void onPause() {
        videoView.pause();
        super.onPause();
    }



}
