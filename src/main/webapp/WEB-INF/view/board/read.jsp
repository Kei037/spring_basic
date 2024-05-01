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
      <span class="input-group-text">tno</span>
      <input type="text" name="tno" class="form-control" value="${dto.no}" readonly>
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">Title</span>
      <input type="text" name="title" class="form-control" value="${dto.title}" readonly>
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">content</span>
      <input type="textarea" name="content" class="form-control" style="height: 200px;" value="${dto.content}" readonly>
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">Writer</span>
      <input type="text" name="writer" class="form-control" value="${dto.writer}" readonly>
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">마지막 수정일</span>
      <input type="text" name="addDate" class="form-control" value="${dto.addDate}" readonly>
    </div>
    <div class="my-4">
      <div class="float-end">
        <button type="button" class="btn btn-primary">modify</button>
        <button type="button" class="btn btn-secondary">List</button>
      </div>
    </div>
    <script>
      document.querySelector(".btn-primary").addEventListener("click", () => {
        self.location = "/board/modify?no=" + ${dto.no};
      });

      document.querySelector(".btn-secondary").addEventListener("click", () => {
        self.location = "/board/list";
      });
    </script>
  </form>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>
