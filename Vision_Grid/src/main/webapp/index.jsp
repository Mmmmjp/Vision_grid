<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vision Grid</title>
    <!-- Google Fonts -->
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
    <div class="wrapper">
        <!-- ヘッダーのインクルード -->
        <jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

        <!-- メインコンテンツ -->
        <main>

            <h2 class="page-title">Vision Gridへようこそ</h2>

            <div class="wrapper-center">
                <section class="introduction">
                    <h3 class="sub_title">アプリケーションについて</h3>
                    <p>
                        Vision Gridは、目標の設定から達成までをサポートするWebアプリケーションです。  
                        Mandalaチャートを採用し、目標を具体的なタスクに分解して管理できます。  
                        作成したシートはいつでも確認や振り返りが可能です。  
                        このアプリ一つで、目標達成に必要なすべての機能が揃っています。  
                        Vision Gridは、あなたの目標達成を全力で応援します。
                    </p>
                </section>
                
                <section class="wrapper-center">
                    <h3 class="sub_title">こんな方におすすめ</h3>
                    <div class="target-users">
                        <ul>
                            <li>目標を達成するための具体的なプロセスを明確にしたい方。</li>
                            <li>就職活動やキャリアの転換期にいる方。</li>
                            <li>学びの目的を明確化し、継続的に振り返りたい方。</li>
                        </ul>
                    </div>
                </section>
            </div>
                    
            <section class="call-to-action animate-section">
                <p class="strong-message">
                    さっそくアカウントを作成して、Vision Gridであなたの目標達成を始めましょう。
                </p>
                <div class="cta-buttons">
                    <a href="RegisterServlet" class="cta-btn cta-btn-atag">新規アカウント作成</a>
                    <a href="LoginServlet" class="cta-btn cta-btn-atag">ログイン</a>
                </div>
            </section>
        </main>

        <!-- フッターのインクルード -->
        <jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
    </div>
</body>
</html>
