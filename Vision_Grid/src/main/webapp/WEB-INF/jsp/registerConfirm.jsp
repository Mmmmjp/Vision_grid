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

	<main>
	    <h2>REGISTER - CONFIRMATION</h2>
	    
	    <c:if test="${not empty errorMsg}">
          <p style="color: red;">${errorMsg}</p>
        </c:if>
 		
 		<div>
        	<p><strong>ユーザ名:</strong> <c:out value="${pendingAccount.userName}" /></p>
          	<p><strong>パスワード:</strong> <c:out value="${pendingAccount.password}" /></p>
          	<p><strong>名前:</strong> <c:out value="${pendingAccount.realName}" /></p>
            <p><strong>生年月日:</strong> <c:out value="${pendingAccount.dob}" /></p>
            <p><strong>性別:</strong> <c:out value="${pendingAccount.gender}" /></p>
        </div>
            
        <form action="RegCompleteServlet" method="post">
                <input type="submit" value="この内容で登録する">
        </form>
        </div>
        
    	<a href="RegisterServlet">登録画面へ戻る</a>
	</main>

    <!-- フッターのインクルード -->
    <jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
</body>
</html>