<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vision Grid | E2 ACTIONS</title>
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
        <h2>E2 ACTIONS SETTING</h2>
        <p>
            <c:out value="${loggedInUser.userName}" />さんの目標 【<c:out value="${vision.visionKey}" />】 <br>
            要素2: <c:out value="${elementKeysList[1]}" /> に対してのアクション！
        </p>

        <img src="${pageContext.request.contextPath}/images/mandala_sheet.png" alt="目標シート画像" style="max-width: 100%; height: auto;">
  
        <!-- エラーメッセージが設定されている場合に表示 -->
		<c:if test="${not empty errorMessage}">
		    <div class="error-message" style="color: red; font-weight: bold;">
		        ${errorMessage}
		    </div>
		</c:if>

        <form action="MandalaE2ActionServlet" method="post">
            <!-- アクションA〜Hの入力欄 -->
            <c:forEach var="letter" items="A,B,C,D,E,F,G,H">
                <div style="margin-bottom: 20px;">
                    <label for="e2${letter}Key">アクション${letter}:</label>
                    <input type="text" id="e2${letter}Key" name="e2${letter}Key" placeholder="アクション${letter}を入力" required>
                </div>
                <div style="margin-bottom: 20px;">
                    <label for="e2${letter}Text">アクション${letter}詳細:</label>
                    <textarea id="e2${letter}Text" name="e2${letter}Text" placeholder="アクション${letter}の詳細を入力" ></textarea>
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
