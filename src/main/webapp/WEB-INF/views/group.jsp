<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/resources/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/operation.js"></script>
    <title>create or join in</title>

</head>
<style>
    * {
        list-style: none;
        text-decoration: none;
    }

    .groupStyle {
        border: 2px solid goldenrod;
        box-shadow: 0 0 2px 2px gainsboro;
        width: 200px;
        height: 150px;
        float: left;
        margin-left: 20px;
    }
</style>
<body>

<div style="width: 80%;height: 80%;border: 1px solid red;">
    <h2>
        hello ${user.name} ,you id is "${user.id}"
        ${user.groupId}
        <c:if test="${empty user.groupId}">
            <a href="/msg/createGroup" style="font-size: 14px;color: red;float: right;margin-right: 100px">创建分组</a>
        </c:if>
    </h2>
    <hr>
    <div>
        <div class="groupCon">
            <c:if test="${ not empty groups}">
                <c:forEach items="${groups}" var="group">
                    <div class="groupId${group.key} groupStyle">
                        <p>groupName："test"
                            <c:choose>
                                <c:when test="${group.key == user.groupId}">
                                    <a href="/msg/deleteGroup"
                                       style="font-size: 12px;color: darkolivegreen">解散分组</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/msg/joinGroup?id=${group.key}" style="font-size: 12px;color: red">加入分组</a>
                                </c:otherwise>
                            </c:choose>
                        </p>
                        <hr/>
                        groupNumber:
                        <ul class="groupNumber${group.key}">
                            <li>${group.value.firstUserName}</li>
                            <li>${group.value.lastUserName}</li>
                        </ul>
                    </div>

                </c:forEach>
            </c:if>
        </div>
    </div>
</div>
</body>

</html>
