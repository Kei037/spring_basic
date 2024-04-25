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

  <title>Hello, world!</title>
</head>
<body>
<div class="card-body">

  <form method="post">
    <div class="input-group mb-3">
      <span class="input-group-text">Title</span>
      <input type="text" name="title" class="form-control" placeholder="Title">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">DueDate</span>
      <input type="date" name="dueDate" class="form-control">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">Writer</span>
      <input type="text" name="writer" class="form-control" placeholder="Writer">
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
