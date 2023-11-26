<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>login</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">
<h1>Your todos are</h1>

<table class="table">
<thead>
<th>Id</th>
<th>Description</th>
<th>Target</th>
<th>Status</th>
</thead>
<tbody>
<c:forEach items="${todos}" var="todo">
<tr>
<td>${todo.id}</td>
<td>${todo.description}</td>
<td>${todo.targetDate}</td>
<td>${todo.done}</td>
<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a></td>
</tr>
</c:forEach>
</tbody>

</table>

<a href="addTodo" class="btn btn-success"> Add Todo</a>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.4/jquery.min.js"></script>
</body>
</html>
