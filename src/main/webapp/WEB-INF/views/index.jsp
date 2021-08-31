<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    helloworld
    <h1>kako login test</h1>
    <span th:if=${userId == null}>
        
        <a href="https://kauth.kakao.com/oauth/authorize?client_id=7f195a0dbcf6fbebab277c68c6909907&redirect_uri=http://localhost:8000/kakao/login&response_type=code">
            <img src = "/img/kakao_login_medium_narrow.png">
        </a>
    </span>
    <span th:if="${userId!=null}">
        <form name="logout" action="http://localhost:8000/kakao/logout">
            <input type="submit" value="로그아웃"/>
        </form>
    </span>
</body>
</html>
