<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Log In</title>
<link rel="stylesheet" href="css/style.css">
<script>
function myFunction() {
    var url = window.location.href;
    url = url.split("?");
    if(url[1] !=null && url[1] != "")
    {
		url = url[1].split("=");
		url = url[1].replace(/[+]/g, " ");
		document.getElementById("demo").innerHTML = url;
	}
}
</script>
</head>
<body>
<form name="login" action="/vms/authenticateview.htm" method="POST">
  <section class="container">
	<div class="warning-bar">
      <h1 style="color:red;" >Session Expired! Please login again...</h1>
	</div>
    <div class="login">
      <h1  >Login to Visitor  Management System</h1>
      <form method="post" action="index.html">
        <p><input type="text" name="username" value="" placeholder="Username"></p>
        <p><input type="password" name="password" value="" placeholder="Password"></p>
        <p class="remember_me">
          <label>
            <input type="checkbox" name="remember_me" id="remember_me">
            Remember me on this computer
          </label>
        </p>
        <p class="submit"><input type="submit" name="submit" value="Login"></p>
      </form>
    </div>

    <div class="login-help">
      <p>Forgot your password? <a href="index.html">Click here to reset it</a></p>
    </div>
  </section>

  <section class="about">
    
    <p class="about-author">
      &copy; 2016 <a href="" target="_blank">Actron</a> -
      <a href="" target="_blank">Software unit</a><br>
      Developed for <a href="" target="_blank">Vajrkosh naval unit</a>
  </section>


<span style="color:red;" id="demo"></span><br>
<script>
myFunction();
</script>
</form>
</body>
</html>