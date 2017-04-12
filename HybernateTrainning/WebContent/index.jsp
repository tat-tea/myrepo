<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.UserInfoBean"%>

<%
	//リクエストスコープからインスタンスを取得する
	List<UserInfoBean> usr = (List<UserInfoBean>) request.getAttribute("usrlist");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script type="text/javascript">
	//登録ボタン押下時入力チェック
	function check() {
		var errorflg = 0;

		window.alert('チェック開始');

		if (Document.form1.loginid.value == "") {
			errorflg = 1;
		} else if (Document.form1.password.value == "") {
			errorflg = 1;
		}

		//MSG表示
		if (errorflg == 1) {
			window.alert('必須項目に未入力の項目があります。');
			return false;
		} else {
			return true;
		}

	}

	function search() {
		window.alert('ユーザ情報の一覧を表示します。');
		return true;

	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel"stylesheet"href="/CSS/Test.css">
<title>Hybernate Trainning</title>
</head>

<body>
	<h1>ユーザ情報登録更新画面</h1>
	<form method="POST"
		action="http://localhost:8080/HybernateTrainning/Regist" name="form1"
		onSubmit="return check()">
		<p>
			ログインＩＤ：（必須）<br> <input type="text" size="30" name="loginid"></input>
		</p>
		<p>
			パスワード：（必須）<br> <input type="password" size="30" name="password"></input>
		</p>
		<p>
			備考：（任意）<br>
			<textarea rows="5" cols="30" name="memo"></textarea>
		</p>
		<br> <input type="submit" value="登録" name="regist"></input>
	</form>

	<p>
		検索結果
		<%
		if (usr != null) {
		%>
		<%=
		 usr.size()
		%>
		<%
			} else {
		%>
		0
		<%
			}
		%>
		件
	</p>
	<table border="1">
		<tr>
			<th>id</th>
			<th>ユーザID</th>
			<th>パスワード</th>
		</tr>
		<%
			if (usr != null) {
				for (UserInfoBean bean : usr) {
		%>

		<tr>
			<td><%=
					bean.getId()
				%></td>
			<td><%=
					bean.getLogin_id()
				%></td>
			<td><%=
					bean.getPassword()
				%></td>
		</tr>

		<%

			}
			}
		%>

	</table>
	<form method="POST"
		action="http://localhost:8080/HybernateTrainning/Search" name="form2"
		onSubmit="return search()">
		<input type="submit" value="ユーザ一覧検索" name="search"></input>
	</form>
</body>
</html>