<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="${pageContext.request.contextPath}/resources/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/game.js"></script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Title</title>
</head>
<style>
    * {
        list-style: none;
    }

    ul {
        position: absolute;
        padding: 0px;
        margin: 0 0 0 50%;
    }

    li {
        float: left
    }
</style>
<body>

<p style="float:left">
    <span id="enemyId"
          style="display: none">敌方id:${group.firstUserId == user.id ? group.lastUserId : group.firstUserId}</span>
    <span id="enemyName">敌方Name:${group.firstUserName == user.name ? group.lastUserName: group.firstUserName}</span>
</p>
<div style="width: 450px;height:600px;margin: 0 auto;border: 1px solid red">
    <span style="border: 1px solid red;position: absolute;margin-top: 290px;width: 449px">
        <ul>
            <li>a</li>
            <li>b</li>
            <li>c</li>
            <li>d</li>
        </ul>
    </span>

</div>

<p style="margin-top: -140px;position:absolute;">
    <span id="ownId" style="display: none">己方id:${user.id }</span>
    <span id="ownName">己方Name:${ user.name}</span>
</p>
</body>
</html>
