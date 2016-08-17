<%@ page  pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" autoFlush="false"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%	System.out.println("------------请求被"+this.getServletName()+"执行"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>过滤器测试,郑州蜂鸟科技  www.ntcsoft.com QQ:38185498 电话：0371-63839606</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  </head>
  <body>
	<form name="loginForm" method="post" action="<%=request.getContextPath()%>/TestFilter">
<%--		<form name="loginForm" method="post" action="<%=request.getContextPath()%>/TestFilter">--%>
			<table>
				<tr>
					<td>
						<div align="right">
				                                测试数据：
						</div>
					</td>
					<td>
						<input type="text" name="test" style="width: 200px">
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="Submit" name="Submit" value="测试">
					</td>
				</tr>
			</table>
		</form>
	   <a href="TestFilter?test=哀伤的发生地方" >测试</a>
	</body>
</html>