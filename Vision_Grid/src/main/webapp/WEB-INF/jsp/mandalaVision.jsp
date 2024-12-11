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
</head>

<body>
    <!-- Headerのインクルード -->
    <jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

    <main>
        <h2>VISION SETTING</h2>
        <p>目標の設定！</p>
        <img src="${pageContext.request.contextPath}/images/mandala_sheet.png" alt="目標シート画像1" style="max-width: 100%; height: auto;">

        <form action="MandalaVisionServlet" method="post">
            <div>
                <label for="vision">目標:</label>
                <input type="text" id="vision" name="vision" placeholder="目標を入力" required>
            </div>
            <div>
                <label for="text">詳細:</label>
                <textarea id="text" name="text" placeholder="詳細を入力"></textarea>
            </div>
            <div>
                <button type="submit">保存して次へ進む</button>
            </div>
        </form>

        <a href="MandalaIntroServlet">前のページへ戻る</a>
    </main>

    <!-- フッターのインクルード -->
    <jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
</body>
</html>
