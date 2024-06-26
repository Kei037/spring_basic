<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

  <title>Hello, world!</title>
</head>
<body>
<div class="container-fluid">
  <div class="row">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav">
            <a class="nav-link active" aria-current="page" href="#">Home</a>
            <a class="nav-link" href="#">Features</a>
            <a class="nav-link" href="#">Pricing</a>
            <a class="nav-link disabled">Disabled</a>
          </div>
        </div>
      </div>
    </nav>

    <div class="row content">
      <div class="col">
        <div class="card">
          <div class="card-body">

          </div>
        </div>
      </div>
    </div>

    <div class="row content">
      <div class="col">
        <div class="card">
          <div class="card-header">
            Featured
          </div>
          <div class="card-body">

            <h5 class="card-title">Specical title treatment</h5>
            <table class="table">
              <thead>
              <tr>
                <th scope="col">Tno</th>
                <th scope="col">Title</th>
                <th scope="col">Writer</th>
                <th scope="col">DueDate</th>
                <th scope="col">Finished</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="dto" items="${responseDTO.dtoList}">
                <tr>
                  <th scope="row">${dto.tno}</th>
                  <td><a href="/todo/read?tno=${dto.tno}&${pageRequestDTO.link}" class="text-decoration-none"
                          data-tno="${dto.tno}"><c:out value="${dto.title}"/></a></td>
                  <td>${dto.writer}</td>
                  <td>${dto.dueDate}</td>
                  <td>${dto.finished}</td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
            <div class="float-end">
              <ul class="pagination flex-wrap">
                <c:if test="${responseDTO.prev}">
                  <li class="page-item">
                    <a class="page-link" data-num="${responseDTO.start - 1}">Previous</a>
                  </li>
                </c:if>

                <c:forEach var="num" begin="${responseDTO.start}" end="${responseDTO.end}">
                  <li class="page-item ${responseDTO.page == num ? "active" : ""}">
                    <a class="page-link" data-num="${num}">${num}</a>
                  </li>
                </c:forEach>

                <c:if test="${responseDTO.next}"> <!-- 838860 page -->
                  <li class="page-item">
                    <a class="page-link" data-num="${responseDTO.end + 1}">NEXT</a>
                  </li>
                </c:if>
              </ul>
            </div>
            <script>
              document.querySelector('.pagination').addEventListener('click', function (e) {
                e.preventDefault();
                e.stopPropagation();

                const target = e.target;
                if (target.tagName != 'A') {
                  return;
                }
                const num = target.getAttribute('data-num');
                self.location = `/todo/list?page=\${num}`; // 백틱을 이용해서 템플릿 처리
              })
            </script>

          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="row content">
    <h1></h1>
  </div>
  <!-- <h1>Footer</h1> -->
  <div class="row footer">
    <div class="row fixed-bottom" style="z-index: -100">
      <footer class="py=1 my-1">
        <p class="text-center text-muted">footer</p>
      </footer>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>