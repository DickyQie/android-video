package com.zhangqie.videosummary.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.view.View;

import com.zhangqie.videosummary.R;
import com.zhangqie.videosummary.widget.MySurfaceView;

/**
 * Created by zhangqie on 2019/8/29
 * Describe:
 */
public class SurfaceViewActivity extends AppCompatActivity implements View.OnClickListener {

    MySurfaceView surfaceView;
    String url = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
    String url1= "https://scb.liaidi.com//data//video//2017//12//20171214235251279358.mp4";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view);
        initView();
    }

    private void initView(){
        //设置分辨率

        surfaceView = (MySurfaceView) findViewById(R.id.surface_view);
        surfaceView.setPivotY(320);
        surfaceView.setPivotX(320);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                //点击播放按钮
                surfaceView.playVideo(url1);
                break;
            case R.id.button2:
                surfaceView.stopVideo();
                break;
            case R.id.button3:

                break;
        }
    }
}
