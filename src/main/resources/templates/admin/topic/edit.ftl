<#include "../layout/layout.ftl">
<@html page_title="话题编辑" page_tab="topic">
  <section class="content-header">
    <h1>
      话题
      <small>编辑</small>
    </h1>
    <ol class="breadcrumb">
      <li><a href="/admin/index"><i class="fa fa-dashboard"></i> 首页</a></li>
      <li><a href="/admin/topic/list">话题</a></li>
      <li class="active">编辑</li>
    </ol>
  </section>
  <section class="content">
    <div class="box box-info">
      <div class="box-header with-border">
        <h3 class="box-title">话题编辑</h3>
      </div>
      <!-- /.box-header -->
      <div class="box-body">
        <form action="" onsubmit="return;" id="form">
          <div class="form-group">
            <label for="title">标题</label>
            <input type="text" name="title" id="title" value="${topic.title}" class="form-control" placeholder="标题"/>
          </div>
          <div id="content">
            ${topic.content!?html}
          </div>
          <div class="form-group">
            <label for="tags">标签</label>
            <input type="text" name="tags" id="tags" value="${tags}" class="form-control" placeholder="标签, 多个标签以 英文逗号 隔开"/>
          </div>
          <div class="form-group">
            <button type="button" id="btn" class="btn btn-primary">更新话题</button>
          </div>
        </form>
      </div>
    </div>
  </section>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="/static/js/wangEditor.min.js"></script>

<script>
  var E = window.wangEditor;
  var editor = new E('#content');
  editor.create();

  $(function () {
    $("#btn").click(function () {
      var title = $("#title").val();
      var content = editor.txt.html();
      var tags = $("#tags").val();
      if (!title || title.length > 120) {
        toast("请输入标题，且最大长度在120个字符以内");
        return;
      }
      if (!tags || tags.split(",").length > 5) {
        toast("请输入标签，且最多只能填5个");
        return;
      }
      $.post("/admin/topic/edit", {
        id: ${topic.id},
        title: title,
        content: content,
        tags: tags,
      }, function (data) {
        if (data.code === 200) {
          toast("更新成功", "success");
          setTimeout(function () {
            window.location.href = "/admin/topic/list";
          }, 700);
        } else {
          toast(data.description);
        }
      })
    })
  })
</script>
</@html>
