<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试@ModelAttribute</title>
</head>
<body>
<h3>测试@ModelAttribute的不同用法</h3>
<a href="loginForm1">测试Model</a><br><br>
<a href="loginForm2">测试ModelMap</a><br><br>
<a href="loginForm3">测试ModelAndView</a><br><br>
<h3>数据绑定测试</h3>
<a href="/user/register/1">测试PathVariable</a><br><br>
<a href="/user/requestHeader">测试requestHeader</a><br><br>
<a href="/user/cookies">测试cookies</a><br><br>
</body>
</html>