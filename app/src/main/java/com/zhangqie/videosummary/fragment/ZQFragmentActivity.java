package com.zhangqie.videosummary.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.zhangqie.videosummary.R;



/**
 * Created by zhangqie on 2017/10/11.
 */

public class ZQFragmentActivity extends AppCompatActivity {

    private Fragment onlineVideoFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);
        initView();
    }
    private void initView(){
        try {
            onlineVideoFragment = ZQTabFragment.newInstance(ZQFragmentActivity.this);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.contentLayout , onlineVideoFragment);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
