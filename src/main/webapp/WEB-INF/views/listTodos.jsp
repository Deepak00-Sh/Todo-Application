<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<h1>Your todos are</h1>

<table class="table">
<thead>
<th>Description</th>
<th>Target</th>
<th>Status</th>
</thead>
<tbody>
<c:forEach items="${todos}" var="todo">
<tr>
<td>${todo.description}</td>
<td>${todo.targetDate}</td>
<td>${todo.done}</td>
<td><a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE</a></td>
<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a></td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="addTodo" class="btn btn-success"> Add Todo</a>
</div>
<%@ include file="common/footer.jspf" %>
