<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
    <%
    	SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String s = sim.format(new Date(System.currentTimeMillis()));
     %>
     <%=s %>
  </body>
</html>
