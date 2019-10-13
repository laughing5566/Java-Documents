<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="100">&nbsp;</td>
    <td width="70">验证码：</td>
    <td width="150"><input id="veryCode" name="veryCode" type="text" class="yzm" value="" onmouseout="isRightCode()"/></td>
    <td width="135"><img id="imgObj" alt="" src="DrawImage" /></td>
    <td><a href="#" onclick="changeImg()">换一张</a></td>
    <td></td>
  </tr>
  <tr>
   <td style="line-height: 38px; color: #FF0000; text-align: center;" colspan="4" id="info">&nbsp;</td>
   <td></td>
  </tr>
</table>
   
   
   
   <script type="text/javascript" src="js/jQuery.js"></script>
   <script type="text/javascript" src="js/verifyCode.js"></script>
  </body>
</html>
