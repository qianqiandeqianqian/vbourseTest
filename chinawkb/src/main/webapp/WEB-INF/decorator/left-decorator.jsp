<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/html-tag.tld" prefix="hm"%>
<!DOCTYPE html>
<html>
<head>
	<title><sitemesh:write property='title' /></title>
	<sitemesh:write property='head' />
</head>
<body>
    <div id="list_page">
        <div class="main_menu_nav_line" style="display:none;">
            <div class="wrapper">
                <div style="height:78px;line-height:78px;font-size:25px;color:#333333;padding:0px 20px;">
                    <c:choose>
                        <c:when test="${!empty category.categoryName }">${category.categoryName }</c:when>
                        <c:otherwise><sitemesh:write property='title' /></c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
        <div class='wrapper wrapper_body' style="width:1024px;">
            <c:choose>
            <c:when test="${!empty client_user && userinfo_finish}">
                <div id='menu_nav'>
                    <ul>
                        <li class="${cateCode=='deliverEnter'?'active_menu':''}"><a href="/member/deliverEnter.html">货物入库申请</a></li>
                        <li class="${cateCode=='deliverOut'?'active_menu':''}"><a href="/member/deliverOut.html">货物出库申请</a></li>
                        <li class="${cateCode=='userInfo'?'active_menu':''}"><a href="/member/userInfo.html">货主资料</a></li>
                        <li class="${cateCode=='clientGoods'?'active_menu':''}"><a href="/member/clientGoods.html">我的货物</a></li>
                    </ul>
                </div>
                 <div style="padding-left:120px;margin-bottom:20px;">
                    <div style="background:#f1f1f1;">
                        <sitemesh:write property='body' />
                    </div>
                  </div>
            </c:when>
            <c:otherwise>
                <div class="pd20">
                    <sitemesh:write property='body' />
                </div>
            </c:otherwise>
            </c:choose>
        </div>
    </div>
</body>
</html>