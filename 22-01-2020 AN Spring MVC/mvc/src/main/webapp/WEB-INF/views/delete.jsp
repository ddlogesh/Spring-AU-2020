<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*"%>
<%@ page import="config.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="obj" class="config.DBConfig" scope="application"/> 
<html>
<head>
<title>Delete Employee</title>
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

<%
if(request.getParameter("id") != null){
	int id = Integer.parseInt(request.getParameter("id"));
	
	Connection connection = obj.getConnection();
	Statement statement = connection.createStatement();

	String sql = "DELETE FROM employee where id='" + id + "'";
	if(statement.executeUpdate(sql) > 0)
		out.println("<script>swal({title: 'Success',text: 'Successfully deleted!',icon: 'success',dangerMode: true,}).then((willDelete) => {window.location.href = '/mvc/';})</script>");
	else
		throw new Exception("Delete failure");
}
%>

<ul>
  <li><a href="/mvc/">Home</a></li>
  <li><a href="create">Create</a></li>
  <li><a href="update">Update</a></li>
  <li><a class="active" href="#">Delete</a></li>
</ul>
<br>
<div class="d-flex justify-content-center align-items-center container">
	<div class="row ">
		<form method="post" action="delete">
			<label for="id">Id</label><br>
			<input type="number" name="id" placeholder="1" required/><br><br>
			
			<input type="submit" value="Delete"/>
		</form>
	</div>
</div>

</body>
</html>
