<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vision Grid | REGISTER</title>
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
    	<h2>REGISTRATION</h2>
    	
    	 <c:if test="${not empty errorMsg}">
            <p style="color: red;">${errorMsg}</p>
        </c:if>
    	
		<form action="RegisterServlet" method="post">
		    <!-- User Name -->
		    <label for="userName">ユーザ名</label>
		    <input type="text" id="userName" name="userName" placeholder="Username" required>
		    <br>
		    
		    <!-- Real Name -->
		    <label for="realName">名前</label>
		    <input type="text" id="realName" name="realName" placeholder="Your name" required>
		    <br>
		    
		    <!-- Password -->
		    <label for="password">パスワード</label>
		    <input type="password" id="password" name="password" placeholder="Password" required>
		    <br>
		    
		    <!-- Date of Birth -->
		    <label for="dob">生年月日</label>
		    <input type="date" id="dob" name="dob" required>
		    <br>
		    
		    <!-- Gender -->
		    <label for="gender">性別</label>
		    <br>
		    <label for="male" class="radio-label">
		        <input type="radio" id="male" name="gender" value="男性" required> 男性
		    </label>
		    <label for="female" class="radio-label">
		        <input type="radio" id="female" name="gender" value="女性"> 女性
		    </label>
		    <label for="secret" class="radio-label">
		        <input type="radio" id="secret" name="gender" value="秘密"> 秘密
		    </label>
		    <br>
		    
		    <!-- Submit Button -->
		    <input type="submit" value="登録内容を確認する"> 
		</form>
		
		<a href="index.jsp" class="custom-button">TOPへ</a>

	</main>

    <!-- フッターのインクルード -->
    <jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
</body>
</html>