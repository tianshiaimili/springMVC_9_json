<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript">
		</script>
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="jquery-1.7.2.min.js">
	
</script>
<script type="text/javascript">
	function response1() {
		$.ajax( {
			url : "getShopJson.do",
			type : "post",
			success : function(data) {
				alert("Data Saved: " + data.name);
			}
		});
	}
	function json2() {
		$.ajax( {
			url : "getjson.do",
			type : "post",
			success : function(data) {
			/* data相当于control处理后返回的数据 */
			alert("----"+data);
			alert("----"+eval(data));
				var arr = eval('(' + data + ')');
				
				for(var i=0; i <arr.length; i++){
					alert(arr[i]);
				}
				var aa = arr[3].staffName;
				for(var i=0; i <aa.length; i++){
					alert(aa[i]);
				}
			}
		});
	}
</script>

<script type="text/javascript">
function myjson(){
$.ajax(

{url:"getShopJson.do",type:"post",
success : function(data){open( 'http://www.w3school.com.cn/js/js_window_location.asp?flag=0','top')}
}

)};

function jsonk(){

$.ajax(
{url : "jsonk.do",type : "post",success : function(data){
open( 'http://www.w3school.com.cn/js/js_window_location.asp?flag=0','top')



}}
);

}

</script>

</head>

<body>
	<a href="hellow.do">Hello!</a>
	<br />
	<a href="contact.do">Contacts</a>
	<br />
	<a href="javascript:myjson();">JSON Response</a>
	<br />
	<br />
	<a href="javascript:json2();">JSON toString()</a>
	<br />
	<a href="javascript:jsonk();">JSON Object</a>
</body>
</html>
