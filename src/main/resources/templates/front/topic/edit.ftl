<#include "../layout/layout.ftl"/>
<@html page_title="编辑话题" page_tab="">
<div class="row">
    <div class="col-md-9">
        <div class="panel panel-default">
            <div class="panel-heading">编辑话题</div>
            <div class="panel-body">
                <form action="" onsubmit="return;" id="form">
                    <div class="form-group">
                        <label for="title">标题</label>
                        <input type="text" name="title" id="title" value="${topic.title}" class="form-control" placeholder="标题"/>
                    </div>
                    <div class="form-group">
                        <div id="content">
                            ${topic.content}
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tags">标签</label>
                        <input type="text" name="tags" id="tags" value="${tags}" class="form-control" placeholder="标签, 多个标签以 英文逗号 隔开"/>
                    </div>
                    <div class="form-group">
                        <button type="button" id="btn" class="btn btn-default">更新话题</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<#--<textarea id="text1" style="width:100%; height:200px;"></textarea>-->

<script type="text/javascript">
    var E = window.wangEditor;
    var editor = new E('#content');
    editor.create();

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
        $.post("/api/topic/edit", {
            id: ${topic.id},
            title: title,
            content: content,
            tags: tags,
        }, function (data) {
            if (data.code === 200) {
                toast("更新成功", "success");
                setTimeout(function () {
                    window.location.href = "/topic/" + data.detail.id
                }, 700);
            } else {
                toast(data.description);
            }
        })
    })
</script>
</@html>