<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vision Grid | Account setting</title>
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
    <div class="wrapper">
        <!-- Headerのインクルード -->
        <jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

        <main class="register-main">
            <h2 class="page-title">アカウント設定</h2>
            
            <div class="register-form">
            	<h3>アカウント登録情報</h3>
                <p><span class="form-item">ユーザ名:</span> <c:out value="${loggedInUser.userName}" /></p>
                <p><span class="form-item">パスワード:</span> <c:out value="${loggedInUser.password}" /></p>
                <p><span class="form-item">名前:</span> <c:out value="${loggedInUser.realName}" /></p>
                <p><span class="form-item">生年月日:</span> <c:out value="${loggedInUser.dob}" /></p>
                <p><span class="form-item">性別:</span> <c:out value="${loggedInUser.gender}" /></p>
            </div>
                 
            <a href="MyPageServlet" class="orange-btn">MYPAGEへ戻る</a>
        </main>

        <!-- フッターのインクルード -->
        <jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
    </div>
</body>
</html>