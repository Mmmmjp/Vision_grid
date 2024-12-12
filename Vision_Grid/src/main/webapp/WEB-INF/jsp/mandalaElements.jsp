<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vision Grid | ELEMENTS SETTING</title>
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
        <h2>ELEMENTS SETTING</h2>
        <p><c:out value="${loggedInUser.userName}" />さんの目標 【<c:out value="${vision.visionKey}" />】 に対する要素</p>
        <img src="${pageContext.request.contextPath}/images/mandala_sheet.png" alt="目標シート画像" style="max-width: 100%; height: auto;">

        <!-- エラーメッセージが設定されている場合に表示 -->
		<c:if test="${not empty errorMessage}">
		    <div class="error-message" style="color: red; font-weight: bold;">
		        ${errorMessage}
		    </div>
		</c:if>
		
        <form action="${pageContext.request.contextPath}/MandalaElementsServlet" method="post">
            <!-- 要素1〜8の入力欄 -->
            <c:forEach var="i" begin="1" end="8">
                <div style="margin-bottom: 20px;">
                    <label for="e${i}Key">要素${i}:</label>
                    <input type="text" id="e${i}Key" name="e${i}Key" placeholder="要素${i}を入力" required>
                </div>
                <div style="margin-bottom: 20px;">
                    <label for="e${i}Text">要素${i}詳細:</label>
                    <textarea id="e${i}Text" name="e${i}Text" placeholder="要素${i}の詳細を入力" ></textarea>
                </div>
            </c:forEach>
            
            <div>
                <button type="submit">保存して次へ進む</button>
            </div>
        </form>
    </main>

    <!-- フッターのインクルード -->
    <jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
</body>
</html>
