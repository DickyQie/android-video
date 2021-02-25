package com.zhangqie.videosummary.activity;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zhangqie.videosummary.MainActivity;
import com.zhangqie.videosummary.R;
import com.zhangqie.videosummary.widget.CircleProgressButton;

import java.io.File;

/**
 * Created by zhangqie on 2019/8/29
 * Describe:
 */
public class SurfaceViewCarmaActivity extends AppCompatActivity {


    CircleProgressButton circleProgressButton;


    private static final String TAG = "MainActivity";
    private SurfaceView surfaceView;
    private MediaRecorder mediaRecorder;
    private boolean record;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surfaceview_carma_activity);
        initView();
    }

    private void initView(){
        circleProgressButton = (CircleProgressButton) findViewById(R.id.cpb_record_video_record);

        circleProgressButton.setIdleCircleColor(getColor(R.color.colorAccent));

        circleProgressButton.setIdleRingColor(getColor(R.color.coclorN));

        circleProgressButton.setPressedCircleColor(getColor(R.color.coclorN));

        circleProgressButton.setPressedRingColor(getColor(R.color.colorAccent));


        mediaRecorder = new MediaRecorder();
        surfaceView = (SurfaceView) this.findViewById(R.id.surface_view_carma);
        /*下面设置Surface不维护自己的缓冲区，而是等待屏幕的渲染引擎将内容推送到用户面前*/
        this.surfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        this.surfaceView.getHolder().setFixedSize(320, 240);//设置分辨率

        ButtonClickListener listener = new ButtonClickListener();
        Button stopButton = (Button) this.findViewById(R.id.stop);
        Button recordButton = (Button) this.findViewById(R.id.record);
        stopButton.setOnClickListener(listener);
        recordButton.setOnClickListener(listener);

    }



    //https://blog.csdn.net/qq_28946307/article/details/51429657
    private void initCirle(){

    }



    private final class ButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                Toast.makeText(SurfaceViewCarmaActivity.this, "没有sdcarderror", 1).show();
                return ;
            }
            try {
                switch (v.getId()) {
                    case R.id.record:
                        mediaRecorder.reset();
                        mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA); //从照相机采集视频
                        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                        mediaRecorder.setVideoSize(320, 240);
                        mediaRecorder.setVideoFrameRate(3); //每秒3帧
                        mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.H263); //设置视频编码方式
                        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                        File videoFile = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis()+".3gp");
                        mediaRecorder.setOutputFile(videoFile.getAbsolutePath());
                        mediaRecorder.setPreviewDisplay(surfaceView.getHolder().getSurface());
                        mediaRecorder.prepare();//预期准备
                        mediaRecorder.start();//开始刻录
                        record = true;
                        break;

                    case R.id.stop:
                        if(record){
                            mediaRecorder.stop();
                            record = false;
                        }
                        break;
                }
            } catch (Exception e) {
                Toast.makeText(SurfaceViewCarmaActivity.this,"error", 1).show();
                Log.e(TAG, e.toString());
            }
        }

    }



}
