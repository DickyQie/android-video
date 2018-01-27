#### android之视频播放系统VideoView和自定义VideoView控件的应用
<div id="article_content" class="article_content">

<p><span style="font-size:14px">Android播放视频，包含系统自带VideoView控件，和自定义VideoView控件，可全屏播放，案例包含了本地视频和网络视频。</span></p>
<p>直接上代码：</p>
<p><span style="font-size:18px; color:#cc0000">1：自定义VideoView控件</span></p>
<p><img src="http://img.blog.csdn.net/20160719170431802?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center" alt=""><br>
</p>
<p><span style="font-size:18px; color:#cc0000">2：布局代码</span></p>
<p><span style="font-size:18px; color:#cc0000"><img src="http://img.blog.csdn.net/20160719170701303?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center" alt=""><br>
</span></p>
<p><span style="font-size:18px; color:#cc0000">3：Activity代码：</span></p>
<p><span style="font-size:18px; color:#cc0000"><img src="http://img.blog.csdn.net/20160719170818647?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center" alt=""><br>
</span></p>
<p><span style="font-size:18px; color:#cc0000"><br>
</span></p>
<p><span style="font-size:18px; color:#cc0000">4：网络权限</span></p>
<p><span style="font-size:18px; color:#cc0000"><img src="http://img.blog.csdn.net/20160719170914241?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center" alt=""><br>
</span></p>
<p>5：效果图</p>
<p style="text-align:center"><img src="http://img.blog.csdn.net/20160720105121847?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center" alt=""><br>
</p>
<p><span style="font-size:24px">小结：</span><span style="font-size:14px">其中的</span><span style="font-size:14px">Uri mUri = Uri.parse(<span style="color:#3333ff">&quot;android.resource://&quot;</span> &#43; getPackageName() &#43;<span style="color:#3333ff">&quot;/&quot;</span>&#43; R.raw.<span style="color:#3333ff">qiche</span>);<span style="white-space:pre"></span>//本地视频</span></p>
<p><span style="font-size:14px"><span style="white-space:pre"></span>是加载的本地视频，可以下载一个视频，在res目录下建立文件夹raw，将其放入其中。</span></p>

   

   
</div>
