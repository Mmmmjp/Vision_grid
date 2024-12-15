<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vision Grid | E5 ACTIONS</title>
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
    <!-- Headerのインクルード -->
    <jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

    <main>
        <h2>E5 ACTIONS SETTING</h2>
        <p>
            <c:out value="${loggedInUser.userName}" />さんの目標 【<c:out value="${vision.visionKey}" />】 <br>
            要素5: <c:out value="${elementKeysList[4]}" /> に対してのアクション！
        </p>

        <img src="${pageContext.request.contextPath}/images/mandala_sheet.png" alt="目標シート画像" style="max-width: 100%; height: auto;">
  
        <!-- エラーメッセージが設定されている場合に表示 -->
		<c:if test="${not empty errorMessage}">
		    <div class="error-message" style="color: red; font-weight: bold;">
		        ${errorMessage}
		    </div>
		</c:if>

        <form action="MandalaE5ActionServlet" method="post">
            <!-- アクションA〜Hの入力欄 -->
            <c:forEach var="letter" items="A,B,C,D,E,F,G,H">
                <div style="margin-bottom: 20px;">
                    <label for="e5${letter}Key">アクション${letter}:</label>
                    <input type="text" id="e5${letter}Key" name="e5${letter}Key" placeholder="アクション${letter}を入力" required>
                </div>
                <div style="margin-bottom: 20px;">
                    <label for="e5${letter}Text">アクション${letter}詳細:</label>
                    <textarea id="e5${letter}Text" name="e5${letter}Text" placeholder="アクション${letter}の詳細を入力" ></textarea>
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
