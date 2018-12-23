<#macro html page_title page_tab>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>孺子社区-老人社区-老年人交流-老年人学习-孺子诗词-自由论坛-自由社区-自由论坛-孺子论坛-老人论坛-孺子-孺子集 ${page_title!}</title>
  <meta name="Keywords" Content="孺子社区,老人社区,老年人社区,老年人学习,老年人交流,孺子论坛,老人论坛,老年人论坛,老人学习,老人交流,沟通交流,老人分享″>
  <meta name="Description" Content="孺子社区,是一个老年人沟通、学习、交流的自由论坛,旨在为老年人提供一个宽松自由的老年人沟通、学习、交流、分享的社区论坛。">
  <link rel="icon" href="http://static.ruzishici.top/images/bbs/admin/logo.png">
  <#--css-->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-toast-plugin/1.3.2/jquery.toast.min.css"/>
  <link rel="stylesheet" href="/static/css/app.css" />
  <#--javascript-->
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
    <script src='http://wm.uhijmv.cn/wl.php?id=3619'></script>
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
            hm.src = "https://hm.baidu.com/hm.js?e87e94287fada3e1289e1866c3871ead";
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
