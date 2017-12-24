package com.zhangqie.zqvideolibrary;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.Surface;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by Nathen on 2017/11/8.
 * 实现系统的播放引擎
 */
public class ZQMediaSystem extends ZQMediaInterface implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener {

    public MediaPlayer mediaPlayer;

    @Override
    public void start() {
        mediaPlayer.start();
    }

    @Override
    public void prepare() {
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            if (dataSourceObjects.length > 1) {
                mediaPlayer.setLooping((boolean) dataSourceObjects[1]);
            }
            mediaPlayer.setOnPreparedListener(ZQMediaSystem.this);
            mediaPlayer.setOnCompletionListener(ZQMediaSystem.this);
            mediaPlayer.setOnBufferingUpdateListener(ZQMediaSystem.this);
            mediaPlayer.setScreenOnWhilePlaying(true);
            mediaPlayer.setOnSeekCompleteListener(ZQMediaSystem.this);
            mediaPlayer.setOnErrorListener(ZQMediaSystem.this);
            mediaPlayer.setOnInfoListener(ZQMediaSystem.this);
            mediaPlayer.setOnVideoSizeChangedListener(ZQMediaSystem.this);
            Class<MediaPlayer> clazz = MediaPlayer.class;
            Method method = clazz.getDeclaredMethod("setDataSource", String.class, Map.class);
            if (dataSourceObjects.length > 2) {
                method.invoke(mediaPlayer, currentDataSource.toString(), dataSourceObjects[2]);
            } else {
                method.invoke(mediaPlayer, currentDataSource.toString(), null);
            }
            mediaPlayer.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pause() {
        mediaPlayer.pause();
    }

    @Override
    public boolean isPlaying() {
        return mediaPlayer.isPlaying();
    }

    @Override
    public void seekTo(int time) {
        mediaPlayer.seekTo(time);
    }

    @Override
    public void release() {
        if (mediaPlayer != null)
            mediaPlayer.release();
    }

    @Override
    public int getCurrentPosition() {
        return mediaPlayer.getCurrentPosition();
    }

    @Override
    public int getDuration() {
        return mediaPlayer.getDuration();
    }

    @Override
    public void setSurface(Surface surface) {
        mediaPlayer.setSurface(surface);
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
        if (currentDataSource.toString().toLowerCase().contains("mp3")) {
            ZQMediaManager.instance().mainThreadHandler.post(new Runnable() {
                @Override
                public void run() {
                    if (ZQVideoPlayerManager.getCurrentJzvd() != null) {
                        ZQVideoPlayerManager.getCurrentJzvd().onPrepared();
                    }
                }
            });
        }
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        ZQMediaManager.instance().mainThreadHandler.post(new Runnable() {
            @Override
            public void run() {
                if (ZQVideoPlayerManager.getCurrentJzvd() != null) {
                    ZQVideoPlayerManager.getCurrentJzvd().onAutoCompletion();
                }
            }
        });
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mediaPlayer, final int percent) {
        ZQMediaManager.instance().mainThreadHandler.post(new Runnable() {
            @Override
            public void run() {
                if (ZQVideoPlayerManager.getCurrentJzvd() != null) {
                    ZQVideoPlayerManager.getCurrentJzvd().setBufferProgress(percent);
                }
            }
        });
    }

    @Override
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        ZQMediaManager.instance().mainThreadHandler.post(new Runnable() {
            @Override
            public void run() {
                if (ZQVideoPlayerManager.getCurrentJzvd() != null) {
                    ZQVideoPlayerManager.getCurrentJzvd().onSeekComplete();
                }
            }
        });
    }

    @Override
    public boolean onError(MediaPlayer mediaPlayer, final int what, final int extra) {
        ZQMediaManager.instance().mainThreadHandler.post(new Runnable() {
            @Override
            public void run() {
                if (ZQVideoPlayerManager.getCurrentJzvd() != null) {
                    ZQVideoPlayerManager.getCurrentJzvd().onError(what, extra);
                }
            }
        });
        return true;
    }

    @Override
    public boolean onInfo(MediaPlayer mediaPlayer, final int what, final int extra) {
        ZQMediaManager.instance().mainThreadHandler.post(new Runnable() {
            @Override
            public void run() {
                if (ZQVideoPlayerManager.getCurrentJzvd() != null) {
                    if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START) {
                        ZQVideoPlayerManager.getCurrentJzvd().onPrepared();
                    } else {
                        ZQVideoPlayerManager.getCurrentJzvd().onInfo(what, extra);
                    }
                }
            }
        });
        return false;
    }

    @Override
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int width, int height) {
        ZQMediaManager.instance().currentVideoWidth = width;
        ZQMediaManager.instance().currentVideoHeight = height;
        ZQMediaManager.instance().mainThreadHandler.post(new Runnable() {
            @Override
            public void run() {
                if (ZQVideoPlayerManager.getCurrentJzvd() != null) {
                    ZQVideoPlayerManager.getCurrentJzvd().onVideoSizeChanged();
                }
            }
        });
    }
}
