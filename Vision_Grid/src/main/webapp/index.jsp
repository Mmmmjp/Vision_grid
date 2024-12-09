<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vision Grid</title>
<!-- Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c:wght@500&display=swap" rel="stylesheet">
<!-- CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
<!-- Headerのインクルード -->
<jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

<main>
  	<!-- ログアウトメッセージの表示 -->
    <c:if test="${not empty logoutMessage}">
        <p style="color: green;">
            ${logoutMessage}
        </p>
    </c:if>

	<a href="LoginServlet">ログイン</a>
	<a href="RegisterServlet">新規アカウント作成</a>
</main>
<!-- フッターのインクルード -->
<jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
</body>
</html>