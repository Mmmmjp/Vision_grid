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
</head>

<body>
    <!-- Headerのインクルード -->
    <jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

    <main>
        <h2 class="page-title">ログインページ</h2>
        
        <c:if test="${not empty errorMsg}">
            <p style="color: red;">${errorMsg}</p>
        </c:if>
        
        <c:if test="${not empty logoutMessage}">
            <p style="color: green;">${logoutMessage}</p>
        </c:if>

        <form action="LoginServlet" method="post">
            <label for="userName">ユーザネーム</label>
            <input type="text" name="userName" placeholder="Your username" required>
            <br>
                    
            <label for="password">パスワード</label>
            <input type="password" name="password" placeholder="Your password" required>
            <br>
                    
            <input type="submit" value="ログイン"> 
        </form>
        
        <a href="index.jsp" class="orange-btn">TOP画面に戻る</a>
    </main>

    <!-- フッターのインクルード -->
    <jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
</body>
</html>