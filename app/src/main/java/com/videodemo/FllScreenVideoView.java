package com.videodemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class FllScreenVideoView extends VideoView {

	public FllScreenVideoView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public FllScreenVideoView(Context context, AttributeSet attrs) {
		super(context,attrs);
		// TODO Auto-generated constructor stub
	}
	public FllScreenVideoView(Context context, AttributeSet attrs, int defStyle) {
		super(context,attrs,defStyle);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int width=getDefaultSize(0, widthMeasureSpec);
		int height=getDefaultSize(0, heightMeasureSpec);
		setMeasuredDimension(width, height);
	}
}
