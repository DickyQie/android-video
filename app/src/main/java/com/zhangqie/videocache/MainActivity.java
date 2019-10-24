package com.zhangqie.videocache;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.danikula.videocache.HttpProxyCacheServer;

/***
 * https://github.com/danikula/AndroidVideoCache
 *
 */

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_WRITE_EXTERNAL_STORAGE = 1;

    String url = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = findViewById(R.id.videoView);

        //检查版本是否大于M
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_WRITE_EXTERNAL_STORAGE);
            } else {
                Log.i("aaa", "权限已申请");
                initVideo();
            }
        }
    }

    private void initVideo() {
        HttpProxyCacheServer proxy = VideoApplication.getProxy(this);
        //1.我们会将原始url注册进去
        // proxy.registerCacheListener(, bean.getVideo_url());
        //2.我们播放视频的时候会调用以下代码生成proxyUrl
        String proxyUrl = proxy.getProxyUrl(url);
        if (proxy.isCached(url)) {
            Log.i("aaaa", "已缓存");
        } else {
            Log.i("aaaa", "未缓存");
        }
        Log.i("aaaapath", proxyUrl);
        videoView.setVideoPath(proxyUrl);
        videoView.start();
        videoView.findFocus();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        if (requestCode == MY_PERMISSIONS_WRITE_EXTERNAL_STORAGE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initVideo();
            } else {
                //"权限已拒绝";
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}
