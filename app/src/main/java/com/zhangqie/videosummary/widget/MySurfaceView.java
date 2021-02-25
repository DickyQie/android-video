package com.zhangqie.videosummary.widget;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by zhangqie on 2019/8/29
 * Describe:
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback, MediaPlayer.OnCompletionListener {
    private SurfaceHolder holder;
    private MediaPlayer mediaPlayer;

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }//快进

    public void setprogress(int progress) {
        int currentPosition = mediaPlayer.getCurrentPosition();
        mediaPlayer.seekTo(currentPosition + progress);
        Toast.makeText(getContext(), "快进" + progress, Toast.LENGTH_SHORT).show();
    }
    //暂停/播放方法
    public void stopVideo() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        } else {
            mediaPlayer.start();
        }
    }

    //播放视频方法
    public void playVideo(String path) {
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();//设置surfaceview不维护自己的缓冲区，而是等待屏幕的渲染引擎将内容推送到用户面前
            mediaPlayer.setOnCompletionListener(this);
        }
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(path);
            mediaPlayer.setDisplay(holder);
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() {
        holder = this.getHolder();
        //重写SurfaceHolder.Callback方法
        holder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }//缓冲完成播放

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
    }
}
