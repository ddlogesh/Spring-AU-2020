<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Employee Portal</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
  color: white;
  text-decoration: none;
}

.active {
  background-color: #f5cb40;
}
</style>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>

<ul>
  <li><a class="active" href="#">Home</a></li>
  <li><a href="create">Create</a></li>
  <li><a href="update">Update</a></li>
  <li><a href="delete">Delete</a></li>
</ul>
<br>

<div class="d-flex justify-content-center align-items-center container">
	<div class="row ">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>First name</th>
					<th>Last name</th>
					<th>Mobile</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="emp" items="${emp}">
	                <tr>
	                    <td>${emp.id}</td>
	                    <td>${emp.fname}</td>
	                    <td>${emp.lname}</td>
	                    <td>${emp.mobile}</td>
	                </tr>
                </c:forEach> 
			</tbody>
		</table>
	</div>
</div>
</body>
</html>