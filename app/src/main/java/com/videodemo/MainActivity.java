package com.videodemo;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView mVideoView;//原始控件
    String url="http://ocs.maiziedu.com/android_app_sde_1.mp4";

    FllScreenVideoView mFllScreenVideoView;//自定义Video(可全屏播放)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_video);
        initView();
    }


    void  initView()
    {
        // TODO Auto-generated method stub
        Uri uri = Uri.parse(url);  //网络视频
        mVideoView = (VideoView) findViewById(R.id.videoView);
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.setVideoURI(uri);
        mVideoView.start();
        mVideoView.requestFocus();
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "视频播放结束了", 1).show();
            }
        });



        Uri mUri = Uri.parse("android.resource://" + getPackageName() + "/"+ R.raw.qiche);	//本地视频
        mFllScreenVideoView=(FllScreenVideoView) findViewById(R.id.fvideoView);
        mFllScreenVideoView.setMediaController(new MediaController(this));
        mFllScreenVideoView.setVideoURI(mUri);
        mFllScreenVideoView.start();
        mFllScreenVideoView.requestFocus();
    }



}
