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
    <!-- js -->
    <script src="${pageContext.request.contextPath}/js/animation.js" defer></script>
</head>

<body>
    <!-- Loading Screen -->
    <div id="loading-screen">
        <div class="loading-text">マンダラチャート作成中...</div>
        <div class="dots">
            <div></div>
            <div></div>
            <div></div>
        </div>
    </div>
    
    <div class="wrapper loading-wrapper">
        <!-- Headerのインクルード -->
        <jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

        <main>
            <h2 class="page-title">MANDARA - COMPLETED</h2>

            <!-- progress bar  -->
            <ol class="timeline">
                <li class="prev">イントロ</li>
                <li class="prev">目標</li>
                <li class="prev">要素</li>
                <li class="prev">アクション E1~E8</li>
                <li class="current">シート作成完成</li>
            </ol>

            <div class="call-to-action">
                <p class="strong-message"><span class="marker-effect"><c:out value="${loggedInUser.userName}" />さん</span>の目標シート作成が完了しました</p>
                
                <p>早速、マイページより確認してみてください♪</p>
                <a href="MyPageServlet" class="cta-btn cta-btn-atag">MY PAGEへ</a>
            </div>
            
        </main>

        <!-- フッターのインクルード -->
        <jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
    </div>
</body>
</html>