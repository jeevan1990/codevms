
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AdminScreen</title>
    <script src= "resources/myjs.js"></script>
	<script src= "resources/uploadinfo.js"></script>
	<script src= "resources/js/jquery.js"></script>
	<script src= "resources/js/jquery-ui.js"></script>
	<script src= "resources/js/custom.js"></script>
	
	<!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
   
    <link href="resources/css/custom.css" rel="stylesheet">
	<link href="resources/css/jquery-ui.css" rel="stylesheet">
	
    <!-- Custom Fonts -->
    <link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script>
	  $(function() {
	    $( "#datepicker" ).datepicker({
	   		changeMonth: true,
	      	changeYear: true,
	      	selectedYear: 1920
	    });
	  });
  </script>
</head>
<body>
 	<div data-ng-app="myApp" data-ng-controller="myCtrl">
 	<h1 align="center">Visitor Details</h1><hr/>

	<form class="form-horizontal" enctype="multipart/form-data" name="uploadPersonData" data-ng-submit="AddPersonSubmitForm()">

	<input type="hidden" value="create" id="uploadType" />

	<div class="row">
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="fname">First Name:</label>
			<div class="col-md-3" >
			  	<input type="text" name="fname" data-ng-model="firstName" class="form-control" placeholder="Enter first name" >
			</div>
		</div>
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="mname">Middle Name:</label>
			<div class="col-md-3"> 
			  	<input type="text" name="mname" data-ng-model="middleName" class="form-control" placeholder="Enter Middle name">
			</div>
		</div>
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="lname">Last Name:</label>
			<div class="col-md-3"> 
			  	<input type="text" name="lname" data-ng-model="lastName" class="form-control" placeholder="Enter last name">
			</div>
		</div>
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="dob">Date Of Birth:</label>
			<div class="col-md-3"> 
			 	<input type="text" id="datepicker" name="dob" data-ng-model="dateOfBirth" class="form-control" placeholder="Enter Date of Birth">
			</div>
		</div>
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="address">Address:</label>
			<div class="col-md-3"> 
			  	<textarea rows="5" id="address" name="address" data-ng-model="address" class="form-control" placeholder="Enter address"></textarea>
			</div>
		</div>
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="adProof">AddressProof Type:</label>
			<div class="col-md-3"> 
				<select class="form-control selectpicker" id="addressproofId" name="adProof" data-ng-options=" item.description as item.description  for item in addressdatalist" data-ng-model="addressProofType"></select>
			</div>
		</div>
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="addressproof">Address Proof:</label>
			<div class="col-md-3"> 				
				<div class="fileupload fileupload-new" data-provides="fileupload">
					<span class="btn btn-primary btn-file upload">
						<span class="fileupload-new">Select file</span> 
						<span class="fileupload-exists">Change</span> 
						<input name="addressproof" type="file" id="addressproof" value=""> 
					</span> 
					<span class="fileupload-preview"></span> 
					<a href="#" class="close fileupload-exists" data-dismiss="fileupload" style="float: none">×</a>
				</div>			
			</div>
		</div>
		
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="vehicleNum">Vehicle Number:</label>
			<div class="col-md-3"> 
			  	<input type="text" name="vehicleNum" data-ng-model="vehicleNumber" class="form-control" placeholder="Enter Vehicle Number">
			</div>
		</div>
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="visitorType">Visitor Type:</label>
			<div class="col-md-3"> 
				<select class="form-control selectpicker" id="visitortypeId" name="visitorType" data-ng-options=" item.description as item.description  for item in visitordatalist" data-ng-model="visitorType" data-ng-change="ManageDiv()"></select>
			</div>
		</div>
		
		
		<div id="ServicePersonneldiv" data-ng-show="showServicePerson">
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="rank">Rank:</label>
			<div class="col-md-3"> 
			  	<input type="text" name="rank" data-ng-model="rank" class="form-control" placeholder="Enter Officer Rank">
			</div>
		</div>
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="officerId">Service personnel ID:</label>
			<div class="col-md-3"> 
			  	<input type="text" name="officerId" data-ng-model="officerId" class="form-control" placeholder="Enter Officer ID">
			</div>
		</div>
		</div>
		
		<div id="Familydiv" data-ng-show="showFamily">
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="dependentId">Dependent ID:</label>
			<div class="col-md-3"> 
			  	<input type="text" name="dependentId" data-ng-model="dependentId" class="form-control" placeholder="Enter Dependent ID">
			</div>
		</div>
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="dependentofficerId">Dependent Service Personnel ID:</label>
			<div class="col-md-3"> 
			  	<input type="text" name="dependentofficerId" data-ng-model="dependentOfficerId" class="form-control" placeholder="Enter Dependent Officer ID">
			</div>
		</div>
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="relation">Relation:</label>
			<div class="col-md-3"> 
			  	<input type="text" name="relation" data-ng-model="relation" class="form-control" placeholder="Enter relationship with Officer">
			</div>
		</div>
		</div>
		
		<div id="Guestdiv" data-ng-show="showGuest">
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="personToMeet">Person To Meet(Service Personnel Id):</label>
			<div class="col-md-3"> 
			  	<input type="text" name="personToMeet" data-ng-model="personToMeet" class="form-control" placeholder="Enter name of person to meet">
			</div>
		</div>
		</div>
		
		<div id="Vendordiv" data-ng-show="showVendor">
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="vendorId">Vendor ID:</label>
			<div class="col-md-3"> 
			  	<input type="text" name="vendorId" data-ng-model="vendorId" class="form-control" placeholder="Enter Vendor ID">
			</div>
		</div>
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="vendorName">Vendor Name:</label>
			<div class="col-md-3"> 
			  	<input type="text" name="vendorName" data-ng-model="vendorName" class="form-control" placeholder="Enter Vendor Name">
			</div>
		</div>
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="vendorAddress">Vendor Address:</label>
			<div class="col-md-3"> 
			  	<input type="text" name="vendorAddress" data-ng-model="vendorAddress" class="form-control" placeholder="Enter Vendor Address">
			</div>
		</div>
		</div>
		<div id="Contractordiv" data-ng-show="showContractor">
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="contractorId">Contractor ID:</label>
			<div class="col-md-3"> 
			  	<input type="text" name="contractorId" data-ng-model="contractorId" class="form-control" placeholder="Enter Contractor ID">
			</div>
		</div>
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="contractorName">Contractor Name:</label>
			<div class="col-md-3"> 
			  	<input type="text" name="contractorName" data-ng-model="contractorName" class="form-control" placeholder="Enter Contractor Name">
			</div>
		</div>
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="contractorAddress">Contractor Address:</label>
			<div class="col-md-3"> 
			  	<input type="text" name="contractorAddress" data-ng-model="contractorAddress" class="form-control" placeholder="Enter Contractor Address">
			</div>
		</div>
		</div>
		<div class="form-group col-md6">
			<label class="control-label col-sm-2" for="profilephoto">Profile Photo:</label>
			<div class="col-md-3"> 				
				<div class="fileupload fileupload-new" data-provides="fileupload">
					<span class="btn btn-primary btn-file upload">
						<span class="fileupload-new">Select file</span> 
						<span class="fileupload-exists">Change</span> 
						<input name="profilephoto" type="file" id="profilephoto" value=""> 
					</span> 
					<span class="fileupload-preview"></span> 
					<a href="#" class="close fileupload-exists" data-dismiss="fileupload" style="float: none">×</a>
				</div>			
			</div>
		</div>
		  <div class="form-group col-md6" style="display: none">
			<label class="control-label col-sm-2" for="fingerprint">FingerPrint:</label>
			<div class="col-md-3"> 				
				<div class="fileupload fileupload-new" data-provides="fileupload">
					<span class="btn btn-primary btn-file upload">
						<span class="fileupload-new">Select file</span> 
						<span class="fileupload-exists">Change</span> 
						<input name="fingerprint" type="file" id="fingerprint" value=""> 
					</span> 
					<span class="fileupload-preview"></span> 
					<a href="#" class="close fileupload-exists" data-dismiss="fileupload" style="float: none">×</a>
				</div>			
			</div>
		</div>
		<hr/>
	
		<div class="form-group col-md6"> 
			<div class="col-md-2"> 	
			
				<input type="submit" value="Submit" class="btn btn-success pull-right">
			</div>
		</div>
	</div>
		





<div style="width:600px; text-align:center;" data-ng-show="successDiv">
<span style="color:green; display: inline-block;">
Person Id 
<a href="{{'/vms/viewperson.htm?personId=' + link}}" >{{link}}</a> created successfully.
</span>
</div>

<div style="width:600px; text-align:center;" data-ng-show="errorDiv">
<span style="color:red; display: inline-block;">
{{errorMessage}}
</span>
</div>

</form>
</div>
</body>
</html>