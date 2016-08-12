<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File upload</title>
    <script src= "resources/myjs.js"></script>
	<script src= "resources/code.js"></script>
</head>
<body>
<div data-ng-app="myApp" data-ng-controller="myCtrl">
<form  name="uploadDetails"  enctype="multipart/form-data" data-ng-submit="fileupload()">
Person Id: <input type="text" name="personId" data-ng-model="personId" > <br>
Finger index: <input type="text" name="fingerindex" data-ng-model="fingerindex" > <br>
FingerPrint: <input name="fingerprint" type="file" id="fingerprint" value=""><br>

<input type="submit" value="submit" >
</form>
<br/>
<div style="width:600px; text-align:center;" data-ng-show="errorDiv">
<span style="color:red; display: inline-block;">
{{successMessage}}
</span>
</div>
</div>
</body>
</html>