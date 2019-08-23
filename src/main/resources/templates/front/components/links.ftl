<div class="panel panel-default">
  <div class="panel-heading">
    友情链接
  </div>
  <table class="table">
    <@tag_link limit=limit>
      <#list links as link>
        <tr>
          <td><a href="${link.linkUrl}">${link.linkName}</a></td>
        </tr>
      </#list>
    </@tag_link>
  </table>
</div>
