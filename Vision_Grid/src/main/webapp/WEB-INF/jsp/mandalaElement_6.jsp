<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vision Grid | E6 ACTIONS</title>
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
            <h2 class="page-title">E6 ACTIONS SETTING</h2>
            <a href="LogoutServlet" class="skip-btn mandala-logout">LOGOUT</a>
 
             <!-- progress bar  -->
             <ol class="timeline">
                <li class="prev">イントロ</li>
                <li class="prev">目標</li>
                <li class="prev">要素</li>
                <li class="current">アクション E1~E8</li>
                <li>シート作成完成</li>
            </ol>
                       
            <p class="align-center">
                <c:out value="${loggedInUser.userName}" />さんの目標 【<c:out value="${vision.visionKey}" />】 <br>
                <span class="marker-effect">要素6: <c:out value="${elementKeysList[5]}" /></span> に対してのアクション
            </p>

            <img src="${pageContext.request.contextPath}/images/gridsheet_sample/e6-actions.png" alt="目標シートサンプル画像(E6actions)" class="mandala-img">
    
            <!-- エラーメッセージが設定されている場合に表示 -->
            <c:if test="${not empty errorMessage}">
                <p class="error-message align-center">${errorMessage}</p>
            </c:if>

            <div class="elements-actions-setting mandala-form">
                <form action="MandalaE6ActionServlet" method="post">
                    <!-- アクションA〜Hの入力欄 -->
                    <c:forEach var="letter" items="A,B,C,D,E,F,G,H">
                        <div class="form-section">
                            <p class="form-section-title">アクション${letter}</p>
                            <div class="form-group" >
                                <div>
                                    <input type="text" id="e6${letter}Key" name="e6${letter}Key" placeholder="アクション${letter}を入力" required>
                                </div>
                                <div>
                                    <textarea id="e6${letter}Text" name="e6${letter}Text" placeholder="アクション${letter}の詳細を入力" ></textarea>
                                </div>
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
