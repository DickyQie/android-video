package com.zhangqie.videosummary.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zhangqie.videosummary.R;
import com.zhangqie.zqvideolibrary.ZQVideoPlayer;
import com.zhangqie.zqvideolibrary.ZQVideoPlayerStandard;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhangqie on 2017/10/11.
 */

public class ZQVideoStyleActivity extends AppCompatActivity {

    @BindView(R.id.zqvideo)
    ZQVideoPlayerStandard zqvideo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zqvideo_style_layout);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        zqvideo.setUp("https://scb.liaidi.com//data//video//2017//12//20171214235251279358.mp4",  ZQVideoPlayerStandard.SCREEN_WINDOW_LIST, "标题");
        zqvideo.startVideo();
    }


    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                ZQVideoPlayer.setTextureViewRotation(90);
                break;
            case R.id.button2:
                ZQVideoPlayer.setVideoImageDisplayType(ZQVideoPlayer.VIDEO_IMAGE_DISPLAY_TYPE_FILL_PARENT);
                break;
            case R.id.button3:
                ZQVideoPlayer.setVideoImageDisplayType(ZQVideoPlayer.VIDEO_IMAGE_DISPLAY_TYPE_FILL_SCROP);
                break;
            case R.id.button4:
                ZQVideoPlayer.setVideoImageDisplayType(ZQVideoPlayer.VIDEO_IMAGE_DISPLAY_TYPE_ORIGINAL);
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        ZQVideoPlayer.releaseAllVideos();
        ZQVideoPlayer.setVideoImageDisplayType(ZQVideoPlayer.VIDEO_IMAGE_DISPLAY_TYPE_ADAPTER);
    }

}
