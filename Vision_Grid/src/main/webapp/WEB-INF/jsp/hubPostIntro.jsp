<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vision Grid | VISION GRID HUB INTRO</title>
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
            <h2 class="page-title">VISION GRID HUB イントロ</h2>
            <a href="HubPostMainServlet" class="skip-btn">SKIP→</a>

			  <div class="wrapper-center">
                <section class="intro-section">
                    <h3 class="intro-title">VISION GRID HUBとは？</h3>
                    <p>ユーザー同士が自由につぶやきを共有し、応援し合える場所です。<br>
                    目標に向けて頑張ったことや気づきを投稿し、他のユーザーからの「応援」でモチベーションをさらに高めましょう。</p>
                </section> 
            
                <section class="intro-section">
                    <h3 class="intro-title">投稿時のポイント</h3>
                    <p>なるべくポジティブな気持ちでつぶやきを投稿してみましょう！<br>
                    たとえ思うようにいかなかった日でも、「こんな反省点があったから、明日からこうしよう！」と前向きな姿勢で共有することで、自分自身の成長につながります。<br>
                    他のユーザーにも元気や励ましを与える投稿を心がけてみてください。
                    </p>
                </section>

                <section class="intro-section">
                    <h3 class="intro-title">応援機能📢</h3>
                    <p>目標に向かって頑張っている仲間の投稿に、応援を送ることができます。<br>
                    皆で応援を送りあって一緒に頑張りましょう。
                     <br>※なお、同じアカウントからは一投稿につき一回のみ応援を送ることができます。
                    </p>
                </section>

                <a href="HubPostMainServlet" class="cta-btn cta-btn-atag">みんなで目標を応援</a>
            </div>
            
            <div class="orange-btn-container">
         	   <a href="MyPageServlet" class="orange-btn">MY PAGEへ戻る</a>
            </div>
        </main>

        <!-- フッターのインクルード -->
        <jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
    </div>
</body>
</html>