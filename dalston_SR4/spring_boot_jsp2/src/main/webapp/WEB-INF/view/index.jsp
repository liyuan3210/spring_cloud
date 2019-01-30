<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>spring_framework_web</title>
</head>
<body>
this is index JSP<br>
页面跳转(负载)<br>
<a href="/page/sysName/action/index">index</a>
<a href="/page/sysName/action/menu1">menu1</a>
<a href="/page/sysName/action/menu2">menu2</a>
<br>
service服务端页面跳转(负载)<br>
<a href="/service/sysName/test">服务端页面跳转</a><br>
JSP控制器调用服务提供者请参照如下demo:<br>
ribbon_consumer
feign_consumer

</body>
</html>