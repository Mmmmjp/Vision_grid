<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vision Grid | E4 ACTIONS</title>
    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c:wght@500&display=swap" rel="stylesheet">
    <!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <!-- favicon -->
    <link rel="apple-touch-icon" sizes="180x180" href="images/favicon/apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="images/favicon/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="images/favicon/favicon-16x16.png">
	<link rel="manifest" href="/site.webmanifest">
    <!-- js -->
    <script src="${pageContext.request.contextPath}/js/animation.js" defer></script>
</head>

<body>
    <div class="wrapper">
        <!-- Headerのインクルード -->
        <jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

        <main>
            <h2 class="page-title">E4 ACTIONS SETTING</h2>
            <a href="LogoutServlet" class="skip-btn mandala-logout">LOGOUT</a>
            
            <p class="align-center">
                <c:out value="${loggedInUser.userName}" />さんの目標 【<c:out value="${vision.visionKey}" />】 <br>
                <span class="marker-effect">要素4: <c:out value="${elementKeysList[3]}" /> </span>に対してのアクション
            </p>

            <img src="${pageContext.request.contextPath}/images/gridsheet_sample/e4-actions.png" alt="目標シートサンプル画像(E4actions)" class="mandala-img">
    
            <!-- エラーメッセージが設定されている場合に表示 -->
            <c:if test="${not empty errorMessage}">
                <div class="error-message" style="color: red; font-weight: bold;">
                    ${errorMessage}
                </div>
            </c:if>

            <div class="elements-actions-setting mandala-form">
                <form action="MandalaE4ActionServlet" method="post">
                    <!-- アクションA〜Hの入力欄 -->
                    <c:forEach var="letter" items="A,B,C,D,E,F,G,H">
                        <div class="form-section">
                            <p class="form-section-title">アクション${letter}</p>
                            <div>
                                <input type="text" id="e4${letter}Key" name="e4${letter}Key" placeholder="アクション${letter}を入力" required>
                            </div>
                            <div>
                                <textarea id="e4${letter}Text" name="e4${letter}Text" placeholder="アクション${letter}の詳細を入力" ></textarea>
                            </div>
                        </div>
                    </c:forEach>
                    
                    <div class="align-center">
                        <input type="submit"  value="保存して次へ進む" class="cta-btn">
                    </div>
                </form>
            </div>
        </main>

        <!-- フッターのインクルード -->
        <jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
    </div>
</body>
</html>
