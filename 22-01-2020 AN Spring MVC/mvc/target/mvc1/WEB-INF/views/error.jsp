<%@ page isErrorPage="true" %>
<html>
<head>
<title>Error Page</title>
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
</head>
<body>
<div>
<ul>
  <li><a class="active" href="/mvc/">Home</a></li>
  <li><a href="create">Create</a></li>
  <li><a href="update">Update</a></li>
  <li><a href="delete">Delete</a></li>
</ul>
<br>
<h1>Exception occurred!</h1>
<p><%= exception %><p>
</div>
</body>
</html>