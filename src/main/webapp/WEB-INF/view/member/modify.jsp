<%--
  Created by IntelliJ IDEA.
  User: junyoung
  Date: 4/23/24
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>회원가입</title>
</head>
<body>
<div class="card-body">

    <form method="post">
        <div class="input-group mb-3">
            <span class="input-group-text">아이디</span>
            <input type="text" name="memberId" value="${dto.memberId}" class="form-control">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">이름</span>
            <input type="text" name="name" value="${dto.name}" class="form-control">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">이메일</span>
            <input type="text" name="email" value="${dto.email}" class="form-control">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">휴대폰번호</span>
            <input type="text" name="phone1" value="${dto.phone1}" class="form-control">-
            <input type="text" name="phone2" value="${dto.phone2}" class="form-control">-
            <input type="text" name="phone3" value="${dto.phone3}" class="form-control">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">우편번호</span>
            <input type="text" name="zipcode" value="${dto.zipcode}" class="form-control">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">주소1</span>
            <input type="text" name="address1" value="${dto.address1}" class="form-control">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">주소2</span>
            <input type="text" name="address2" value="${dto.address2}" class="form-control">
        </div>
        <div class="my-4">
            <div class="float-end">
                <button type="submit" class="btn btn-primary">Submit</button>
                <button type="reset" class="btn btn-secondary">Reset</button>
            </div>
        </div>
    </form>
    <script>
        const serverValidResult = {};
        <c:forEach items="${errors}" var="error">
        serverValidResult['${error.getField()}'] = '${error.defaultMessage}';
        </c:forEach>
        console.log(serverValidResult)
    </script>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>
