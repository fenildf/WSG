<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="${pageContext.request.contextPath}/resources/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/game.js"></script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Title</title>
</head>
<body>

<p>
    <span id="enemyId">敌方id:${group.firstUserId == user.id ? group.lastUserId : group.firstUserId}</span>
    <span id="enemyName">敌方Name:${group.firstUserName == user.name ? group.lastUserName: group.firstUserName}</span>
</p>
<hr>
<div style="width: 80%;height:80%;margin: 0 auto;border: 1px solid red">
    <span class="word" style="position: relative;top: 250px;left: 40%;font-size: 20px;">
        a
    </span>
</div>

<p>
    <span id="ownId">己方id:${user.id }</span>
    <span id="ownName">己方Name:${ user.name}</span>
</p>
</body>
</html>
