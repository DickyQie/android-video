package com.zhangqie.videosummary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zhangqie.videosummary.activity.VideoViewActivity;
import com.zhangqie.videosummary.activity.ZQFullVideoActivity;
import com.zhangqie.videosummary.activity.ZQVideoActivity;
import com.zhangqie.videosummary.activity.ZQVideoStyleActivity;
import com.zhangqie.videosummary.fragment.ZQFragmentActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    String[] strings={"系统和自定义视频控件","自定义视频控件","视频播放样式","全屏播放","TabLayout+RecylerView+自定义视频"};
    @BindView(R.id.listview)
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        ArrayAdapter<String>  adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,strings);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    startActivity(new Intent(MainActivity.this, VideoViewActivity.class));
                }else if (position==1){
                    startActivity(new Intent(MainActivity.this, ZQVideoActivity.class));
                }else if (position==2){
                    startActivity(new Intent(MainActivity.this, ZQVideoStyleActivity.class));
                }else if (position==3){
                    startActivity(new Intent(MainActivity.this, ZQFullVideoActivity.class));
                }else if (position==4){
                    startActivity(new Intent(MainActivity.this, ZQFragmentActivity.class));

                }
            }
        });
    }
}
