<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<style>
.matain{
width:800px;
height:600px;

}
iframe{
display:none;
}
.ifra{
display:block;
}
</style>
<script type="text/javascript">
 $(function(){
	$(".btn").bind("click","",function(){
		
		$("#book").toggleClass("ifra");
	})

	
	
}); 

</script>
<body>
<a href="Book/index.html">aaaaBook</a>
<a href="Type/index.html">aaaaType</a>

<button class="btn"><a href="Book/index.jsp" target="ntf">Book</a></button>
<button class="btn"><a href="Type/index.jsp" target="ntf">Type</a></button>
<div class="matain">
<iframe style="width:1800px;height:1000px;" id="book" src="" name="ntf"></iframe> 
</div>


</body>
</html>