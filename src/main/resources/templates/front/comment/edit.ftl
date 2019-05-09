<#include "../layout/layout.ftl"/>
<@html page_title="编辑话题" page_tab="">
<div class="row">
  <div class="col-md-12">
    <div class="panel panel-default">
      <div class="panel-heading">
        <a href="/">主页</a> / <a href="/topic/${topic.id}">${topic.title}</a> / 编辑评论
      </div>
      <div id = "content">
        ${comment.content?html}
      </div>
      <div class="panel-body">
        <button type="button" id="btn" class="btn btn-default">
          <span class="glyphicon glyphicon-send"></span> 更新
        </button>
      </div>
    </div>
  </div>
</div>

<script>
  var E = window.wangEditor;
  var editor = new E('#content');
  editor.create();

  $(function () {

    $("#btn").click(function () {
      var content = editor.txt.html();
      if (!content) {
        toast("请输入内容");
        return ;
      }
      $.post("/api/comment/update", {
        id: ${comment.id},
        content: content
      }, function (data) {
        if (data.code === 200) {
          toast("更新成功", "success");
          setTimeout(function () {
            window.location.href = "/topic/${comment.topicId}";
          }, 700);
        } else {
          toast(data.description);
        }
      })
    })
  });
</script>
</@html>
