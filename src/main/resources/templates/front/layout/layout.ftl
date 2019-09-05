<#macro html page_title page_tab>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>健康管理论坛-健康管理社区-健康管理-健康咨询-健康交流-健康管理师-樵夫 ${page_title!}</title>
  <meta name="Keywords" Content="健康管理师论坛-健康管理社区-健康管理-健康咨询-健康交流-樵夫″>
  <meta name="Description" Content="樵夫社区,是一个关于健康管理的社区，主要为一些对健康管理，交流，学习，有兴趣的朋友们提供一个沟通交流的渠道！">
  <link rel="icon" href="http://static.lyqiaofu.top/images/bbs/admin/logo.png">
  <#--css-->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-toast-plugin/1.3.2/jquery.toast.min.css"/>
  <link rel="stylesheet" href="/static/css/app.css" />
  <#--javascript-->
  <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  <script type="text/javascript" src="/static/js/wangEditor.min.js"></script>
  <!--<script type="text/javascript" src="http://unpkg.com/wangeditor/release/wangEditor.min.js"></script>-->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-toast-plugin/1.3.2/jquery.toast.min.js"></script>
  <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
    <script>
        (adsbygoogle = window.adsbygoogle || []).push({
            google_ad_client: "ca-pub-6488119633221249",
            enable_page_level_ads: true
        });
    </script>
    <#--<script src="http://wm.lrswl.com/page/?s=291107"></script>-->
    <#--<script src='http://wm.uhijmv.cn/wl.php?id=3619'></script>-->
  <script>
    function toast(txt, icon) {
      $.toast({
        text: txt, // Text that is to be shown in the toast
        heading: '系统提醒', // Optional heading to be shown on the toast
        icon: icon || 'error', // Type of toast icon warning, info, success, error
        showHideTransition: 'slide', // fade, slide or plain
        allowToastClose: true, // Boolean value true or false
        hideAfter: 2000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
        stack: false, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time
        position: 'top-right', // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values
      });
    }
  </script>
  <script>
    var _hmt = _hmt || [];
    (function() {
      var hm = document.createElement("script");
      hm.src = "https://hm.baidu.com/hm.js?8e0a77715e9b02a8cdf83824756b7a71";
      var s = document.getElementsByTagName("script")[0];
      s.parentNode.insertBefore(hm, s);
    })();
  </script>
</head>
<body>
<div class="wrapper">
  <#include "header.ftl"/>
  <@header page_tab=page_tab/>
  <div class="container">
    <#nested />
  </div>
</div>
<#include "footer.ftl"/>
</body>
</html>
</#macro>
