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
    <div class="wrapper">
        <!-- Headerのインクルード -->
        <jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

        <main>

            <h2 class="page-title">マンダラチャート作成方法</h2>
            <a href="MandalaVisionServlet" class="skip-btn">SKIP→</a>

            <!-- progress bar  -->
            <ol class="timeline">
                <li class="current">イントロ</li>
                <li>目標</li>
                <li>要素</li>
                <li>アクション E1~E8</li>
                <li>シート作成完成</li>
            </ol>

            <div class="wrapper-center">
                <section class="intro-section">
                    <h3 class="intro-title">マンダラチャートとは？</h3>
                    <p>マンダラチャートとは、目標やアイデアを整理し、具体的な行動計画を立てるためのツールです。中心に大きな目標を置き、その周りに関連する8つの要素を配置します。さらにそれぞれの要素を細分化して具体的なタスクに落とし込むことで、目標達成に必要な手順を視覚的に整理できます。この方法は、全体像を把握しつつ細かい部分まで具体的に考えられる点が特徴です。</p>
                    <img src="${pageContext.request.contextPath}/images/grid-sheet-sample.png" alt="目標シートサンプル画像" class="mandala-img">
                </section> 

                <section class="intro-section">
                    <h3 class="intro-title">作成の進め方</h3>
                    <p>所要時間は約10分ほどです。以下の順番で作成が進みます</p>
                    <ol class="breadcrumb">
                        <li>目標の設定</li>
                        <li>目標に対する要素の設定</li>
                        <li>各要素に対するアクションの設定 E1 ~ E8</li> 
                    </ol>

                    <p>目標を達成するためは、何が必要か【要素8つ】<br>  
                        またその必要な各要素を実現するためには日々のどんな行動が必要【アクション8つ】<br>
                        達成したい目標をしっかりと意識しながらマンダラチャートの作成にあたってください。<br>
                        なお、キーワードだけでは設定の時に物足りない、また見返しの際に自分がどのような考えや意思でそれぞれの設定をしたのかということを見返せるように、詳細を記述できる欄を設けております。
                        こちらは必須項目ではありませんが、ぜひご活用ください。
                    </p>
                </section>
                
                <section class="intro-section">
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
    </div>
</body>
</html>