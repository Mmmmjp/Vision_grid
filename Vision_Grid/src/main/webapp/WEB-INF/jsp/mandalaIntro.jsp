<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vision Grid | MANDARA-INTRO</title>
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

		<h2 class="page-title">マンダラチャート作成方法</h2>
        <a href="MandalaVisionServlet" class="skip-btn">SKIP→</a>

        <div class="wrapper-center">
            <section>
                <h3 class="intro-title">マンダラチャートとは？</h3>
                <p>マンダラチャートとは、目標やアイデアを整理し、具体的な行動計画を立てるためのツールです。中心に大きな目標を置き、その周りに関連する8つの要素を配置します。さらにそれぞれの要素を細分化して具体的なタスクに落とし込むことで、目標達成に必要な手順を視覚的に整理できます。この方法は、全体像を把握しつつ細かい部分まで具体的に考えられる点が特徴です。</p>
            </section> 

            <section>
                <h3 class="intro-title">作成の進め方</h3>
                <p>所要時間は約10分ほどです。以下の順番で作成が進みます</p>
                <p>目標の設定 > 要素（サブ目標）の設定> 各要素に対するアクションの設定</p>
            </section>
            
            <section>
                <h3 class="intro-title">作成時の注意点</h3>
                <p>万が一目標シートの作成途中でアプリを閉じた場合には、ログイン後続きのページから続けることができます。
                    <br>ただし、途中で閉じたページに入力していた項目があった場合、それらの情報は保存されません。
                </p>

            </section>

            <a href="MandalaVisionServlet" class="cta-btn cta-btn-atag">作成を開始</a>
         </div>
    	<div class="orange-btn-container">
          <a href="MyPageServlet" class="orange-btn">前のページへ戻る</a>
	    </div>
    </main> 

    <!-- フッターのインクルード -->
    <jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
</body>
</html>