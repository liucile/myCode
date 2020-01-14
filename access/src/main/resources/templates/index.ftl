<html>
<body>

<#if Session.privilages?exists>
    <#list Session.privilages as privilage>
        <#if privilage.remark == "/access/index/user">
            <button id="user" type="button">user</button>
        </#if>
        <#if privilage.remark == "/access/index/admin">
            <button id="admin" type="button">admin</button>
        </#if>
    </#list>
</#if>

</body>
<script type=text/javascript src="http://localhost:8080/access/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" language="JavaScript">
    $("#user").click(function () {
        $.ajax({
            type:"get",
            url:"http://localhost:8080/access/index/user",
            success:function(data){
                console.log(data);
                alert(data);
            },
            error:function(){
                alert("fail");
            }
        });
    });

    $("#admin").click(function () {
        $.ajax({
            type:"get",
            url:"http://localhost:8080/access/index/admin",
            success:function(data){
                console.log(data);
                alert(data);
            },
            error:function(){
                alert("fail");
            }
        });
    });

</script>
</html>