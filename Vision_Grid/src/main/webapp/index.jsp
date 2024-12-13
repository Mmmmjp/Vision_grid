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
</head>
<body>
    <!-- ヘッダーのインクルード -->
    <jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

    <!-- メインコンテンツ -->
    <main class="top-main">

        <h2 class="page-title">Vision Gridへようこそ</h2>
        <section class="introduction">
            <h3 class="sub_title">アプリケーションについて</h3>
            <p>
                Vision Gridは、目標設定と達成をサポートするために設計されたWebアプリケーションです。
                <br>Mandalaチャートにインスパイアされた構造を採用し、ユーザーが大きな目標を具体的な要素やタスクに分解し、
                達成への道筋を視覚的かつ効率的に管理できる仕組みを提供します。
            </p>
        </section>
        
        <section class="target-users">
            <h3 class="sub_title">こんな方におすすめ</h3>
            <ul>
                <li>目標を達成するための具体的なプロセスを明確にしたい方。</li>
                <li>就職活動やキャリアの転換期にいる方。</li>
                <li>学びの目的を明確化し、継続的に振り返りたい方。</li>
            </ul>
        </section>
                
        <section class="call-to-action">
            <p>
                さっそくアカウントを作成して、Vision Gridであなたの目標達成を始めましょう。
            </p>
            <div class="cta-buttons">
                <a href="RegisterServlet" class="green-cta-btn">新規アカウント作成</a>
                <a href="LoginServlet" class="green-cta-btn">ログイン</a>
            </div>
        </section>
    </main>

    <!-- フッターのインクルード -->
    <jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
</body>
</html>
