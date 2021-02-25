package com.zhangqie.videosummary.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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
