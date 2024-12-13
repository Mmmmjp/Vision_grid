<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vision Grid | REGISTER-CONFIRM</title>
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

	<main class="register-main">
	    <h2 class="page-title">新規登録 - 内容確認ページ</h2>
	    
	    <c:if test="${not empty errorMsg}">
          <p style="color: red;">${errorMsg}</p>
        </c:if>
 		
 		<div class="register-form">
        	<p><span class="form-item">ユーザ名:</span> <c:out value="${pendingAccount.userName}" /></p>
          	<p><span class="form-item">パスワード:</span> <c:out value="${pendingAccount.password}" /></p>
          	<p><span class="form-item">名前:</span> <c:out value="${pendingAccount.realName}" /></p>
            <p><span class="form-item">生年月日:</span> <c:out value="${pendingAccount.dob}" /></p>
            <p><span class="form-item">性別:</span> <c:out value="${pendingAccount.gender}" /></p>
        
            <form action="RegCompleteServlet" method="post" class="form-buttons">
                <input type="submit" value="この内容で登録する">
            </form>
        </div>
            
        
        </div>
        
    	<a href="RegisterServlet" class="orange-btn">登録画面へ戻る</a>
	</main>

    <!-- フッターのインクルード -->
    <jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
</body>
</html>