<%--
  Created by IntelliJ IDEA.
  User: fighting
  Date: 15/9/13
  Time: 下午5:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>
<c:out value="这是jstl el 输出："/><h1>${userInfo.userName}</h1>
<s:property value="userInfo.userName"/>
</body>
</html>
