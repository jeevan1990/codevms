var app = angular.module('myApp', []);
app.controller('myCtrl',['$scope','$http', function($scope,$http) {

	$scope.Managefields=function(){
		$scope.showServicePerson = false;
	    $scope.showFamily = false;
	    $scope.showGuest = false;
	    $scope.showVendor = false;
	    $scope.showContractor = false;
	    $scope.rank="";
	    $scope.officerId="";
	    $scope.dependentId="";
	    $scope.dependentOfficerId="";
	    $scope.relation="";
	    $scope.personToMeet="";
	    $scope.vendorId="";
	    $scope.vendorName="";
	    $scope.vendorAddress="";
	    $scope.contractorId="";
	    $scope.contractorName="";
	    $scope.contractorAddress="";
		
	};
	$scope.firstName = "";
    $scope.lastName = "";
    $scope.middleName= "";
    $scope.dateOfBirth="";
    $scope.address="";
    $scope.vehicleNumber="";
    $scope.visitorType="Employee";
    $scope.addressProofType="Aadhar Card";
    $scope.successDiv = false;
    $scope.errorDiv = false;
    $scope.errorMessage = "";
    $scope.successMessage = "";
    $scope.Managefields();
   
    
    var addressproofdata={"addresslist":[

                 {
                                          "addressid":1,
                                          "description":"Aadhar Card"
                                           },
                                           {
                                               "addressid":2,
                                               "description":"Naval Dependent Id Card"
                                           },
                                           {
                                              "addressid":3,
                                              "description":"Driving Licence"
                                            },
                                            
                                            {
                                                "addressid":4,
                                                "description":"Pan Card"
                                              },
                                                     
                                           {
                                           "addressid":5,
                                            "description":"Voter Id"
                                           }]
                 };

	var visitordata={"visitorlist":[

			{
			"visitorid":1,
			"description":"Service Personnel"
			},
			{
			"visitorid":2,
			"description":"Employee"
			},
			{
			"visitorid":3,
			"description":"Family"
			},
			{
			"visitorid":4,
			"description":"Guest"
			},
			{
			"visitorid":5,
			"description":"Vendor"
			},
			{
			"visitorid":6,
			"description":"Contractor"
			}
			]
			};
	$scope.visitordatalist=visitordata.visitorlist;
	
	$scope.addressdatalist=addressproofdata.addresslist;
	
	
	$scope.ManageDiv=function(){
		
		$scope.Managefields();
		
		console.log("in manage div");
		
		console.log($scope.visitorType);
		
	    if($scope.visitorType=="Service Personnel")
	    {
	    	$scope.showServicePerson = true;
	    }
	    else if($scope.visitorType=="Family")
	    {
	    	$scope.showFamily = true;
	    }
	    else if($scope.visitorType=="Guest")
	    {
	    	$scope.showGuest = true;
	    }
	    else if($scope.visitorType=="Vendor")
	    {
	    	$scope.showVendor = true;
	    	$scope.showGuest = true;
	    }
	    else if($scope.visitorType=="Contractor")
	    {
	    	$scope.showContractor = true;
	    	$scope.showGuest = true;
	    }
		
	};
		$scope.AddPersonSubmitForm = function (){
			console.log("hi in file");
			
			$scope.successDiv = false;
			 $scope.errorDiv = false;
			 $scope.successMessage="";
			 $scope.errorMessage="";
			
			var firstName,middleName,lastName,dateOfBirth,address,vehicleNumber,visitorType,addressProofType,
			rank,officerId,dependentId,dependentOfficerId,relation,personToMeet,vendorId,
			vendorName,vendorAddress,contractorId,contractorName,contractorAddress;
			
			firstName=$scope.firstName;
			middleName=$scope.middleName;
			lastName=$scope.lastName;
			dateOfBirth=$scope.dateOfBirth;
			address=$scope.address;
			
			vehicleNumber=$scope.vehicleNumber;
			visitorType=$scope.visitorType;
			addressProofType=$scope.addressProofType;
			rank=$scope.rank;
			officerId=$scope.officerId;
			dependentId=$scope.dependentId;
			dependentOfficerId=$scope.dependentOfficerId;
			relation=$scope.relation;
			personToMeet=$scope.personToMeet;
			vendorId=$scope.vendorId;
			vendorName=$scope.vendorName;
			vendorAddress=$scope.vendorAddress;
			contractorId=$scope.contractorId;
			contractorName=$scope.contractorName;
			contractorAddress=$scope.contractorAddress;
			
			if(document.uploadPersonData.profilephoto.value != undefined &&
					document.uploadPersonData.profilephoto.value.length >0){
				
				var formData = new FormData();
				formData.append('firstName', firstName);
				formData.append('middleName', middleName);
				formData.append('lastName', lastName);
				formData.append('dateOfBirth', dateOfBirth);
				formData.append('address', address);
				formData.append('vehicleNumber', vehicleNumber);
				formData.append('visitorType', visitorType);
				formData.append('addressProofType', addressProofType);
				formData.append('rank', rank);
				formData.append('officerId', officerId);
				formData.append('dependentId', dependentId);
				formData.append('dependentOfficerId', dependentOfficerId);
				formData.append('relation', relation);
				formData.append('personToMeet', personToMeet);
				formData.append('vendorId', vendorId);
				formData.append('vendorName', vendorName);
				formData.append('vendorAddress', vendorAddress);
				formData.append('contractorId', contractorId);
				formData.append('contractorName', contractorName);
				formData.append('contractorAddress', contractorAddress);
				formData.append("profilephoto",document.getElementById('profilephoto').files[0]);
				formData.append("addressproof",document.getElementById('addressproof').files[0]);
				formData.append("fingerprint",document.getElementById('fingerprint').files[0]);
				console.log("birthday"+dateOfBirth);
				$http.post(
						'/vms/bulkuploadFile.htm',
						formData,
						{
							transformRequest : function(
									data,
									headerGetterFunction){
								return data;
							},
							headers : {
								'Content-Type' : undefined
							}
						}).
						success(
								function(data,status){
									console.log(data);
									if(data.statCode==0)
									{	
										$scope.link=data.message;
										$scope.successDiv = true;
									}
									else
									{
										$scope.errorMessage=data.message;
										$scope.errorDiv = true;
									}
								}).
								error(function(data,status){
									console.log(data);
								});
			}
		};
	
}]);