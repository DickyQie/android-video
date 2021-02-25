package com.zhangqie.videosummary.activity;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zhangqie.videosummary.R;
import com.zhangqie.zqvideolibrary.ZQVideoPlayerStandard;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhangqie on 2017/10/11.
 */

public class ZQFullVideoActivity extends AppCompatActivity {


    @BindView(R.id.btn_full)
    Button btnFull;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_video_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_full)
    public void onClick() {
        ZQVideoPlayerStandard.startFullscreen(this,  ZQVideoPlayerStandard.class, "https://scb.liaidi.com//data//video//2017//12//20171214235251279358.mp4", "我是标题");
    }
}
