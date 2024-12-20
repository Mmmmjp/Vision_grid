<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vision Grid | MY PAGE</title>
    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c:wght@500&display=swap" rel="stylesheet">
    <!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/gridSheet.css">
    <!-- favicon -->
    <link rel="apple-touch-icon" sizes="180x180" href="images/favicon/apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="images/favicon/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="images/favicon/favicon-16x16.png">
	<link rel="manifest" href="/site.webmanifest">
     <!-- js -->   
    <script src="${pageContext.request.contextPath}/js/print.js" defer></script>

</head>

<body>
    <div class="wrapper">
        <!-- Headerのインクルード -->
        <jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

        <main>

            <h2 class="page-title"><c:out value="${loggedInUser.userName}" />さんの目標:【<c:out value="${vision.visionKey}" />】</h2>
            
            <!-- 印刷ボタン -->
            <div class="print-btn-container">
                <button id="print-btn" class="print-btn">シートを印刷</button>
            </div>    
            
            <!-- fLOATING NAV -->
            <div class="floating-menu">
                <a href="HubPostIntroServlet">📋 掲示板</a>
                <a href="/日記">📖 日記</a>
                <a href="/目標達成チャート">📊 チャート</a>
                <a href="AccountSettingServlet">⚙️ 設定</a>
            </div>

            <!-- GridSheetのインクルード -->
            <div id="printArea">
                <jsp:include page="/WEB-INF/jsp/includes/gridSheet.jsp" />
            </div>

            <div class="orange-btn-container">
                <a href="LogoutServlet" class="orange-btn">ログアウト</a>
            </div>
        </main>

        <!-- フッターのインクルード -->
        <jsp:include page="/WEB-INF/jsp/includes/footer.jsp" /> 
    </div>
</body>
</html>
