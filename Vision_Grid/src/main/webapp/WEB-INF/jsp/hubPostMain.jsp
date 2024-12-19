<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vision Grid | VISION GRID HUB</title>
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
            <h2 class="page-title">VISION GRID HUB</h2>
			<a href="LogoutServlet" class="skip-btn mandala-logout">LOGOUT</a>
            
            <div class="align-center">
    			<a href="HubPostMainServlet" class="sub-button">更新</a>
    			<a href="MyPageServlet" class="sub-button">MYPAGEに戻る</a>
			</div>

			<div style="position: relative; max-width: 600px; margin: 0 auto;">
    			<form action="Main" method="post" class="form-wrapper tweet-form">
        			<input type="text" name="text" placeholder="今日は何頑張った？...">
        			<input type="submit" value="つぶやく">
    			</form>
			</div>


			<c:if test="${not empty errorMsg}">
    			<p style="color: red;"><c:out value="${errorMsg}" /></p>
			</c:if>

			<div class="tweets-container">
    			<c:forEach var="mutter" items="${mutterList}">
        			<div class="tweet-wrapper">
            		<p class="userName"><c:out value="${mutter.userName}" /></p>
            		<p class="date"><c:out value="${mutter.getFormattedPostDate()}" /></p>
            		<p class="tweet-text"><c:out value="${mutter.postText}" /></p>
        			</div>
    			</c:forEach>
			</div>
        </main>

        <!-- フッターのインクルード -->
        <jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
    </div>
</body>
</html>