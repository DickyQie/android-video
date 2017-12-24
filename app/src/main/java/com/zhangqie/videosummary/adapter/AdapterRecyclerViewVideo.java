package com.zhangqie.videosummary.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.zhangqie.videosummary.R;
import com.zhangqie.zqvideolibrary.ZQVideoPlayer;
import com.zhangqie.zqvideolibrary.ZQVideoPlayerStandard;


public class AdapterRecyclerViewVideo extends RecyclerView.Adapter<AdapterRecyclerViewVideo.MyViewHolder> {

    public static final String TAG = "AdapterRecyclerViewVideo";
    private Context context;
    private String[] strings={"https://scb.liaidi.com//data//image//photo//2017//12//20171214205200832660.jpg",
            "https://scb.liaidi.com//data//image//photo//2017//12//20171214204955317939.jpg",
    "https://scb.liaidi.com//data//image//photo//2017//12//20171214205008812743.jpg",
            "http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png"};
    private String[] video={"https://scb.liaidi.com//data//video//2017//12//20171214212407880750.mp4",
            "https://scb.liaidi.com//data//video//2017//12//20171214234546834418.mp4",
            "https://scb.liaidi.com//data//video//2017//12//20171214235251279358.mp4",
    "http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4"};

    private String[] title={"玉舍","玫瑰庄园","火把节","boy"};

    public AdapterRecyclerViewVideo(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_videoview, parent,
                false));
        return holder;
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder [" + holder.jzVideoPlayer.hashCode() + "] position=" + position);

        holder.jzVideoPlayer.setUp(
                video[position], ZQVideoPlayer.SCREEN_WINDOW_LIST,
                title[position]);
        Picasso.with(holder.jzVideoPlayer.getContext())
                .load(strings[position])
                .into(holder.jzVideoPlayer.thumbImageView);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ZQVideoPlayerStandard jzVideoPlayer;

        public MyViewHolder(View itemView) {
            super(itemView);
            jzVideoPlayer = ( ZQVideoPlayerStandard) itemView.findViewById(R.id.videoplayer);
        }
    }

}
