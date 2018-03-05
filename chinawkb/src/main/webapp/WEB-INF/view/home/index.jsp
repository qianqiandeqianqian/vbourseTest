<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
    <h2 id="test">Admin Index
    <br/>系统版本：${system_version}
        <button class="form-controll" onclick="W.success('hahah')">提示</button>
        <button class="form-controll" onclick="W.err('hahah')">提示</button>
        <button class="form-controll" onclick="W.check('hahah')">提示</button>
        <button class="form-controll" onclick='W.openWin("","#test","200px","300px")'>加载</button>
        <button class="form-controll" onclick="W.uloading()">关闭加载</button>
    </h2>

    国际化：<spring:message code="language.cn" />
    <spring:message code="language.en" />

    Locale: ${pageContext.response.locale }
</body>
</html>
