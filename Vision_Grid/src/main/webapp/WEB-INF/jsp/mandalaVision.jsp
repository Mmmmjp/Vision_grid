<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vision Grid | VISION SETTING</title>
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
            <h2 class="page-title">VISIONの設定</h2>
            
            <img src="${pageContext.request.contextPath}/images/gridsheet_sample/mandala_vision.png" alt="目標シート画像1" class="mandala-img">

            <form action="MandalaVisionServlet" method="post" class="mandala-form form-vision">
                <div>
                    <label for="vision">目標:</label>
                    <input type="text" id="vision" name="vision" placeholder="目標を入力" required>
                </div>
                <div>
                    <label for="text">詳細:</label>
                    <textarea id="text" name="text" placeholder="詳細を入力"></textarea>
                </div>
                <div>
                    <input type="submit"  value="保存して次へ進む" class="cta-btn">
                </div>
            </form>
            <div class="orange-btn-container">
                <a href="MandalaIntroServlet" class="orange-btn">前のページへ戻る</a>
            </div>
        </main>

        <!-- フッターのインクルード -->
        <jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
    </div>
</body>
</html>
