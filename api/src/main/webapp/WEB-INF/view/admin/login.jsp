<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>后台登录界面</title>
    <jsp:include page="../admin_header.jsp"/>
</head>
<body>
<div>
    <ul class="layui-nav">
        <li class="layui-nav-item" lay-unselect="">
            <img src="${pageContext.request.contextPath}/images/slogo.png">
        </li>
    </ul>
    <div style="max-width:400px;margin:200px auto 0px;">
        <form class="layui-form" action="#" method="post">
            <div class="layui-form-item">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-block">
                    <input type="text" name="username" lay-verify="required" autocomplete="off" placeholder="用户名" class="layui-input" maxlength="20" style="max-width:90%;">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-block">
                    <input type="password" name="password" lay-verify="required" placeholder="密码" autocomplete="off" class="layui-input" maxlength="20" style="max-width:90%;">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">验证码</label>
                <div class="layui-input-block">
                    <input type="text" name="rqcode" lay-verify="required" placeholder="验证码" autocomplete="off" class="layui-input" maxlength="4" style="width:80px;">
                    <img src="/kaptchaImg" onclick="this.src='/kaptchaImg?r='+new Date()" class='cur inbk' title="点击刷新" style="    position: absolute;left: 100px;top: 0px;width:120px;vertical-align: middle;"/>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit="" lay-filter="loginForm">登录</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/layui.v2.2.3/layui.js"></script>
<script>
    layui.use(['form'], function(){
        var form = layui.form;
        //监听提交
        form.on('submit(loginForm)', function(data){
            LCombase.http.post("/admin/security_login",data.field,function(res){
                if(res.code=="0"){
                    W.msg(res.message);
                    LCombase.toMainPage();
                }else if(res.code=='2') {
                    W.check(res.message);
                }else{
                    W.err(res.message);
                }
            });
            return false;
        });


    });

</script>
</body>
</html>
