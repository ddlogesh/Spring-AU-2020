<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*"%>
<%@ page import="config.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="obj" class="config.DBConfig" scope="application"/> 
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
<%
	try{
		Connection connection = obj.getConnection();
		Statement statement = connection.createStatement();
	
		String sql = "SELECT * FROM employee";
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next())
			out.println("<tr><td>" + rs.getString("id")  + "</td><td>" + rs.getString("fname") + "</td><td>" + rs.getString("lname") + "</td><td>" + rs.getString("mobile") + "</td></tr>");
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>