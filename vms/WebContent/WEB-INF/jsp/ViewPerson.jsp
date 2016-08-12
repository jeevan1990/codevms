<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>PersonDetailsScreen</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    
    <script src= "resources/myjs.js"></script>
	<script src= "resources/displayinfo.js"></script>
</head>
<body>


<br>

 <div data-ng-app="myApp" data-ng-controller="myCtrl">

<form enctype="multipart/form-data" name="uploadPersonData" data-ng-submit="AddPersonSubmitForm()">

<input type="hidden" value="create" id="uploadType" />
<div class="container">
<div class="row">
<div class="col-md-3 col-xs-12">
	<img src="/vms/picture.htm?personId=${personId}" class="img-responsive"  width="252px" height="353px"><br/>
</div>
<div class="col-md-6 col-xs-12">
<table class="table">
    
    <tbody>
	<tr>
        <td width="30%">Name: </td>
        <td width="70%"><input type="text" class="form-control" data-ng-model="firstName"></td>
      </tr>
      <!--<tr>
        <td width="30%">First Name: </td>
        <td width="70%"><input type="text" class="form-control" data-ng-model="firstName"></td>
      </tr>
      <tr>
        <td>Middle Name: </td>
        <td><input type="text" class="form-control" data-ng-model="middleName"></td>
      </tr>
      <tr>
        <td>Last Name: </td>
        <td><input type="text" class="form-control" data-ng-model="lastName"></td>
      </tr>-->
      <tr>
        <td>Date Of Birth:</td>
        <td><input type="text" class="form-control" data-ng-model="dateOfBirth"></td>
      </tr>
      <tr>
        <td>Address:</td>
        <td><input type="text" class="form-control" data-ng-model="address"></td>
      </tr>
      <tr>
        <td>Vehicle Number:</td>
        <td><input type="text" class="form-control" data-ng-model="vehicleNumber"></td>
      </tr>
      <tr>
        <td>AddressProof Type:</td>
        <td>
        	<select class="form-control selectpicker" id="addressproofId" data-ng-options=" item.description as item.description  for item in addressdatalist" data-ng-model="addressProofType">
			</select>
		</td>
      </tr>
      <tr>
        <td>Visitor Type:</td>
        <td>
        	<select class="form-control selectpicker" id="visitortypeId" data-ng-options=" item.description as item.description  for item in visitordatalist" data-ng-model="visitorType" data-ng-change="ManageDiv()">
			</select>
        </td>
      </tr>
      </tbody>
  </table>
  
  <table class="table" id="ServicePersonneldiv" data-ng-show="showServicePerson">
    <tbody>   
      	<tr >
        	<td width="30%">Rank:</td>
        	<td width="70%"><input type="text" class="form-control" data-ng-model="rank"></td>
     	</tr>
     	<tr>
	        <td>Service Personnel Id:</td>
	        <td><input type="text" class="form-control" data-ng-model="officerId"></td>
	  	</tr>	
    </tbody>
  </table>

 <table class="table" id="Familydiv" data-ng-show="showFamily">
    <tbody>   
      	<tr >
        	<td width="30%">Dependent Id:</td>
        	<td width="70%"><input type="text" class="form-control" data-ng-model="dependentId"></td>
     	</tr>
     	<tr>
	        <td>Dependent Service Personnel:</td>
	        <td><input type="text" class="form-control" data-ng-model="dependentOfficerId"></td>
	  	</tr>
	  	<tr>
	        <td>Relation:</td>
	        <td><input type="text" class="form-control" data-ng-model="relation"></td>
	  	</tr>	
    </tbody>
  </table>

<table class="table" id="Guestdiv" data-ng-show="showGuest">
    <tbody>   
      	<tr >
        	<td width="30%">Person To Meet:</td>
        	<td width="70%"><input type="text" class="form-control" data-ng-model="personToMeet"></td>
     	</tr>
    </tbody>
  </table>

<table class="table" id="Vendordiv" data-ng-show="showVendor">
    <tbody>   
      	<tr >
        	<td width="30%">Vendor Id:</td>
        	<td width="70%"><input type="text" class="form-control" data-ng-model="vendorId"></td>
     	</tr>
     	<tr>
	        <td>Vendor Name:</td>
	        <td><input type="text" class="form-control" data-ng-model="vendorName"></td>
	  	</tr>
	  	<tr>
	        <td>Vendor Address:</td>
	        <td><input type="text" class="form-control" data-ng-model="vendorAddress"></td>
	  	</tr>	
    </tbody>
  </table>

<table class="table" id="Contractordiv" data-ng-show="showContractor">
    <tbody>   
      	<tr >
        	<td width="30%">Contractor Id:</td>
        	<td width="70%"><input type="text" class="form-control" data-ng-model="contractorId"></td>
     	</tr>
     	<tr>
	        <td>Contractor Name:</td>
	        <td><input type="text" class="form-control" data-ng-model="contractorName"></td>
	  	</tr>
	  	<tr>
	        <td>Contractor Address:</td>
	        <td><input type="text" class="form-control" data-ng-model="contractorAddress"></td>
	  	</tr>	
    </tbody>
  </table>
	<a href="/vms/authenticateview.htm"><span class="btn btn-success pull-right">BACK</span></a>
<!--  Profile Photo:<input name="profilephoto" type="file" id="profilephoto" value=""><br>
Address Proof:<input name="addressproof" type="file" id="addressproof" value=""><br>
FingerPrint:<input name="fingerprint" type="file" id="fingerprint" value=""><br>



<input type="submit" value="submit" >

-->
</div>
<br/><br/>
<a href="/vms/fingerprintview.htm" >Click here to add fingerprint details</a>
<div class="col-md-3 col-xs-12"></div>
</div>
</div>
<div style="width:600px; text-align:center;" data-ng-show="successDiv">
<span style="color:green; display: inline-block;">
{{successMessage}}
</span>
</div>

<div style="width:600px; text-align:center;" data-ng-show="errorDiv">
<span style="color:red; display: inline-block;">
{{errorMessage}}
</span>
</div>

</form>
</div>

	<!-- jQuery -->
    <script src="resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resources/js/bootstrap.min.js"></script>
    
</body>
</html>