### Android------视频播放器（包含全屏播放，快退，快进，腾讯新闻的列表播放等） 
   <p>前段时间做了一个新闻APP，涉及到了列表视频播放，和腾讯新闻APP差不多，总结了一下代码，写了一个Demo来分享给大家。</p> 
<p>用了&nbsp; <strong><span style="color:#6a8759">TabLayout+RecylerView+自定义视频控件 &nbsp;</span></strong><span style="color:#000000">完成的 列表中支持全屏播放</span></p> 
<p><span style="color:#000000">来看看效果图：</span></p> 
<p><span style="color:#000000"><img alt="" height="607" src="http://images2017.cnblogs.com/blog/1041439/201712/1041439-20171224100835881-1982462449.gif" width="360">&nbsp;&nbsp; <img alt="" src="http://images2017.cnblogs.com/blog/1041439/201712/1041439-20171224100917959-488816271.gif" width="360"></span></p> 
<p>&nbsp;</p> 
<p><span style="color:#000000">列表类代码：</span></p> 
<pre><code class="language-java">public class ZQFragmentTabItem extends  BaseFragment{

    RecyclerView recyclerView;
    AdapterRecyclerViewVideo adapterVideoList;

    public static ZQFragmentTabItem newInstance() {
        ZQFragmentTabItem fragment = new ZQFragmentTabItem();
        return fragment;
    }


    private View rootView;
    @Override
    protected View getContentView(LayoutInflater inflater, ViewGroup container) {
        rootView = inflater.inflate(R.layout.recyclerview_video_layout, container, false);
        return rootView;
    }

    @Override
    protected void initViews(View contentView) {

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapterVideoList = new AdapterRecyclerViewVideo(getActivity());
        recyclerView.setAdapter(adapterVideoList);
        recyclerView.addOnChildAttachStateChangeListener(
              new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {
            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
                ZQVideoPlayer jzvd = (ZQVideoPlayer) view.findViewById(R.id.videoplayer);
                if (jzvd != null &amp;&amp; ZQUtils.dataSourceObjectsContainsUri(
                    jzvd.dataSourceObjects, ZQMediaManager.getCurrentDataSource())) {
                    ZQVideoPlayer.releaseAllVideos();
                }
            }
        });

    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initDatas() {
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onPause() {
        super.onPause();
        ZQVideoPlayer.releaseAllVideos();
    }
}</code></pre> 
<p>当然我这也参考了其他小伙伴的案例，然后才写的。</p> 
<p>参考的地址：</p> 
<p>https://gitee.com/nathen/jiecaovideoplayer</p> 
<p>https://gitee.com/weituotian/WeituotianVideoAndroidApp</p> 
<p>https://gitee.com/luorenjiejie/ShiPin</p> 
<p>&nbsp;</p> 
<p>希望对开发者的小伙伴们有帮助。</p> 
<p>&nbsp;</p> 
<span id="OSC_h3_1"></span>
