<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>交易所网站-<sitemesh:write property='title'/></title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
    <jsp:include page="../view/home_header.jsp"/>
	<sitemesh:write property='head' />
    <script type="text/javascript">
        var rightCountTime=null,count=0;
        $(function(){
            LCombase.mouseToggle("language");
            $(document).keydown(function(e){
                var e=window.event || e;
                var keyCode=e.keyCode;
                if(keyCode==39){
                    count++;
                    console.log(count);
                    if(count==3) {
                        LCombase.toLoginPage();
                    }
                    if(rightCountTime==null) {
                        rightCountTime = setTimeout(function () {
                            count = 0;
                            if(rightCountTime!=null){
                                clearTimeout(rightCountTime);
                                rightCountTime=null;
                            }
                            console.log(count);
                        },600);
                    }
                }
            });
        });
        function toHome(){
            window.location.href="/";
        }
    </script>
</title>
</head>
<body>
	<div class="main_decorator">
        <div class="layout-header">
            <div style="height:50px;padding:10px;background:#000;color:#FFF;">
                <div class="language" style="display:inline-block;*display:inline-block;height:30px;padding:0px 15px;line-height:30px;outline:solid 1px #FFF;position:relative;">
                    <c:choose>
                        <c:when test="${pageContext.response.locale=='zh_CN' }"><spring:message code="language.cn" /></c:when>
                        <c:when test="${pageContext.response.locale=='en_US' }"><spring:message code="language.en" /></c:when>
                    </c:choose>
                    <div class="language_item" style="display: none;position:absolute;left:0px;top:30px;outline:solid 1px #FFF;background:#000;color:#FFF;">
                       <ul class="lang_ul">
                           <li><a href="?lang=zh_CN"><spring:message code="language.cn" /></a></li>
                           <li><a href="?lang=en_US"><spring:message code="language.en" /></a></li>
                       </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="layout-body">
            <sitemesh:write property='body'/>
        </div>
        <div class="layout-footer">
            <div style="height:50px;padding:10px;background:#000;color:#FFF;text-align: center;">
                备案：沪000001
            </div>
        </div>
    </div>
</body>
</html>