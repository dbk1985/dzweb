<%--
  Created by IntelliJ IDEA.
  User: alan
  Date: 15/10/11
  Time: 下午4:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="keyword" content="">
  <meta name="description" content="">
  <meta http-equiv="x-ua-compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>用户登录</title>
  <link rel="icon" href="">
  <!-- 新 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <!-- 可选的Bootstrap主题文件（一般不用引入） -->
  <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
  <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
  <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
  <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
  <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<div class="container">
  <div>
    <form action="login.do" method="post">
      <div>
        <label for="inputUserName">用户名</label>
        <input type="text" id="inputUserName" class="form-control" placeholder="请输入用户名" name="account" required autofocus>
      </div>
      <div>
        <label for="inputPassword">密  码</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="请输入登录密码" required>
      </div>
      <div class="checkbox">
        <label>
          <input type="checkbox" value="remember-me">记住密码
        </label>
      </div>
      <div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </div>
    </form>
  </div>
</div>
</body>
</html>
