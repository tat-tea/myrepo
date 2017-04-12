<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hybernate Trainning</title>
</head>

<body>
	<h1>エラー画面</h1>
	<p>
		エラー番号：<%=(String) request.getAttribute("errNum")%>
	</p>
	<p>
		エラーメッセージ：<%=(String) request.getAttribute("errMsg")%></p>
	<br>
	<p>
		<a href="http://localhost:8080/HybernateTrainning/index.jsp">戻る</a>
	</p>
</body>
</html>