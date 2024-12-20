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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/postHub.css">
    <!-- favicon -->
    <link rel="apple-touch-icon" sizes="180x180" href="images/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="images/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="images/favicon/favicon-16x16.png">
    <link rel="manifest" href="/site.webmanifest">
    <!-- JS -->
    <script src="${pageContext.request.contextPath}/js/hub_animation.js" defer></script>
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
                <form action="HubPostMainServlet" method="post" class="form-wrapper tweet-form">
                    <input type="text" name="text" placeholder="今日の頑張りを共有する...">
                    <input type="submit" value="つぶやく">
                </form>
            </div>

            <div class="align-center">
                <c:if test="${not empty errorMsg}">
                    <p style="color: red;"><c:out value="${errorMsg}" /></p>
                </c:if>
            </div>

            <!-- ドロップダウンメニュー -->
			 <div class="date-select-wrapper">
				<form method="get" action="HubPostMainServlet">
					<label for="year-select">年:</label>
					<select id="year-select" name="year">
						<c:forEach var="year" items="${years}">
							<option value="${year}" ${year eq selectedYear ? 'selected="selected"' : ''}>${year}</option>
						</c:forEach>
					</select>
 
					<label for="month-select">月:</label>
					<select id="month-select" name="month">
						<c:forEach var="month" items="${months}">
							<option value="${month}" ${month eq selectedMonth ? 'selected="selected"' : ''}>${month}</option>
						</c:forEach>
					</select> 

					<button type="submit" class="display-btn">表示</button>
				</form>
			</div>

            <!-- 現在の月の投稿を表示 -->
            <div class="post-wrapper">
                <h3 class="post-month">${selectedYear}年 ${selectedMonth}月の投稿</h3>
                <div class="tweets-container">
                    <c:forEach var="mutter" items="${currentMonthMutters}">
                        <div class="tweet-wrapper">
                            <div class="post-title-section">
                                <p class="userName"><c:out value="${mutter.userName}" /></p>
                                <p class="post-date"><c:out value="${mutter.getFormattedPostDate()}" /></p>
                            </div>
                            <p class="tweet-text"><c:out value="${mutter.postText}" /></p>
                            <div class="tweet-actions">
                                <span>
                                    <img class="likes" src="${pageContext.request.contextPath}/images/megaphone.png" alt="megaphone-icon">
                                    <c:out value="${mutter.likeCount}" default="0" />
                                </span>
                                <form action="HubLikesServlet" method="post" class="like-form" style="display: inline;">
                                    <input type="hidden" name="postId" value="${mutter.postId}" />
                                    <button type="submit" class="like-button" aria-label="応援する">応援する</button>
                                </form>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </main>

        <jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
    </div>
</body>
</html>
