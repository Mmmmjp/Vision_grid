<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vision Grid | LOGIN</title>
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

        <main>
            <h2 class="page-title">ログインページ</h2>
            
            <div class="align-center">
                <c:if test="${not empty errorMsg}">
                    <p style="color: red;">${errorMsg}</p>
                </c:if>
                
                <c:if test="${not empty logoutMessage}">
                    <p class="logout-message">${logoutMessage}</p>
                </c:if>
            </div>  

            <form action="LoginServlet" method="post" class="call-to-action login-form">
                <div class="form-group">
                    <label for="userName">ユーザネーム:</label>
                    <input type="text" id="userName" name="userName" placeholder="Your username" required>
                </div>
                                
                <div class="form-group">
                    <label for="password">パスワード:</label>
                    <input type="password" id="password" name="password" placeholder="Your password" required>
                </div>
                
                <!-- Submit Button -->
                <div class="form-buttons">
                    <input type="submit" value="ログイン" class="cta-btn">
                </div>
            </form>

            <div class="orange-btn-container">
                <a href="index.jsp" class="orange-btn" class="">TOP画面に戻る</a>
            </div>
        </main>

        <!-- フッターのインクルード -->
        <jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
    </div>
</body>
</html>