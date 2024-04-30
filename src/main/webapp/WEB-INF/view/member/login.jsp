<%--
  Created by IntelliJ IDEA.
  User: junyoung
  Date: 4/30/24
  Time: 12:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/member/login" method="post">
        <div>
            <span>아이디</span>
            <input type="text" name="memberId">
        </div>
        <div>
            <span>비밀번호</span>
            <input type="text" name="memberPass">
        </div>
        <div>
            <div>
                <button type="submit">로그인</button>
                <button type="reset">취소</button>
            </div>
        </div>
    </form>
</body>
</html>
