<%--
  Created by IntelliJ IDEA.
  User: tb
  Date: 15/9/9
  Time: 上午10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>用户登录</title>
  </head>
  <body>
  <%--<s:form action="login" method="post">--%>
    <%--<s:textfield name="userName" label="用户名"></s:textfield>--%>
    <%--<s:submit value="提交"></s:submit>--%>
  <%--</s:form>--%>
  <s:form action="reg" method="POST">
      <s:textfield name="userName" label="姓名" />
      <s:password name="password" label="密码" />
      <s:textfield name="email"  label ="邮箱"/>
      <s:submit value="注册"/>
  </s:form>
  </body>
</html>
