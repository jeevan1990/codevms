<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>Authentication Screen</title>
	
	<!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/css/freelancer.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <script src= "resources/myjs.js"></script>
	<script src= "resources/indexController.js"></script>
</head>
<body id="page-top" class="index">
<div data-ng-app="myApp" data-ng-controller="indexController">
<!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#page-top">Visitor Portal</a>
            </div>
			
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li class="page-scroll">
                        <a href="addnewperson.htm">Admin</a>
                    </li>
                    
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
    <!-- Header -->
    <header>
        <div class="container">
        <form enctype="multipart/form-data" name="uploadPersonData" data-ng-submit="FindPersonSubmitForm()">
            <div class="row">
                <div class="col-lg-6 col-sm-12 col-xs-12" ng-show="showFingerPrintImage">
                    <a href="#"><img class="img-responsive" src="resources/img/fingerprint.png"  height="200" alt="fingerprint image" ng-click="fingerprintCheck()"></a>
                    
                </div>
				<div class="col-lg-6 col-sm-12 col-xs-12" ng-show="showPasscodeImage">
                    <a href="#"><img class="img-responsive" src="resources/img/keypad.png" height="200" alt="keypad image" ng-click="passcodeCheck()"></a>
                   
                </div>
                <div class="col-lg-6 col-sm-12 col-xs-12" ng-show="showIdBox">
                   <input type="text" name="personId" data-ng-model="personId" class="form-control" placeholder="Enter Person ID">
                   <br/>                   
                   <input type="text" name="passcode" data-ng-model="passcode" ng-show="showPasscodeBox" class="form-control" placeholder="Enter passcode">
                   <br/>
                   <input class="btn btn-block btn-success" type="submit" value="submit" >
                   <button class="btn btn-block btn-danger" ng-click="cancelCheck()" >Cancel</button>
                </div>
            </div>
            
            <div class="row">
                <div class="col-md-3 col-sm-12 col-xs-12">
                </div>
                <div class="col-md-6 col-sm-12 col-xs-12" data-ng-show="successDiv">
                	<label class="form-control text-white">
                		{{successMessage}}
					 	<a href="{{'/vms/viewperson.htm?personId=' + link}}" >Click here to get details</a>
                	</label>
                </div>
                <div class="col-md-3 col-sm-12 col-xs-12">
                </div>
            <!-- <div style="width:600px; text-align:center;" data-ng-show="successDiv">
				<span style="color:white; display: inline-block;">
					{{successMessage}}
					 <a href="{{'/vms/viewperson.htm?personId=' + link}}" >Click here to get details</a>
				</span>
			</div> -->
			
			<div style="width:600px; text-align:center;" data-ng-show="errorDiv">
				<span style="color:red; display: inline-block;">
				{{errorMessage}}
				</span>
			</div>
            </form>
        </div>
    </header>
    </div>
<!-- We are in authentication..... -->

   <!-- jQuery -->
    <script src="resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resources/js/bootstrap.min.js"></script>
</body>
</html>