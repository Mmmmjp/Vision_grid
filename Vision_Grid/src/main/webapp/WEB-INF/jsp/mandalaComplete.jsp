<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vision Grid | MANDARA-COMPLETED</title>
    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c:wght@500&display=swap" rel="stylesheet">
    <!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <!-- favicon -->
    <link rel="apple-touch-icon" sizes="180x180" href="images/favicon/apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="images/favicon/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="images/favicon/favicon-16x16.png">
	<link rel="manifest" href="/site.webmanifest">
</head>

<body>
    <!-- Headerのインクルード -->
    <jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

	<main>
		<h2>MANDARA - COMPLETED</h2>
         <p><c:out value="${loggedInUser.userName}" />さんの目標達成シート作成が完了しました</p>
         
         <p>早速、MyPageより確認してみてください♪</p>
         <a href="MyPageServlet">My pageへ</a>
    	
	</main>

    <!-- フッターのインクルード -->
    <jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
</body>
</html>