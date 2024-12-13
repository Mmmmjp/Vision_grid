<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vision Grid | REGISTER</title>
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

    <main class="register-main">
        <h2 class="page-title">新規登録ページ</h2>

        <!-- エラーメッセージ -->
        <c:if test="${not empty errorMsg}">
            <p class="error-message">${errorMsg}</p>
        </c:if>

        <!-- 新規登録フォーム -->
        <form action="RegisterServlet" method="post" class="register-form">
            <!-- User Name -->
            <label for="userName" class="form-title">ユーザ名</label>
            <input type="text" id="userName" name="userName" placeholder="Username" required>

            <!-- Real Name -->
            <label for="realName" class="form-title">名前</label>
            <input type="text" id="realName" name="realName" placeholder="Your name" required>

            <!-- Password -->
            <label for="password" class="form-title">パスワード</label>
            <input type="password" id="password" name="password" placeholder="Password" required>

            <!-- Date of Birth -->
            <label for="dob" class="form-title">生年月日</label>
            <input type="date" id="dob" name="dob" required>

            <!-- Gender -->
            <label for="gender" class="form-title">性別</label>
            <label for="male" class="radio-label">
                <input type="radio" id="male" name="gender" value="男性" required> 男性
            </label>
            <label for="female" class="radio-label">
                <input type="radio" id="female" name="gender" value="女性"> 女性
            </label>
            <label for="secret" class="radio-label">
                <input type="radio" id="secret" name="gender" value="秘密"> 秘密
            </label>

            <!-- Submit Button -->
            <div class="form-buttons">
                <input type="submit" value="登録内容を確認する" class="cta-btn">
            </div>
        </form>

		<div class="top-link-container">
			<a href="index.jsp" class="orange-btn">TOPへ</a>
		</div>
    </main>

    <!-- フッターのインクルード -->
    <jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
</body>
</html>
