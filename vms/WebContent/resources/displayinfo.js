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
   
    $scope.successDiv = false;
    $scope.errorDiv = false;
    $scope.errorMessage = "";
    $scope.successMessage = "";
    $scope.Managefields();
   
    
	 $scope.visitorType="Employee";
	 $scope.addressProofType="Voter Id";
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
	    	$scope.showGuest = true;
	    	$scope.showVendor = true;
	    }
	    else if($scope.visitorType=="Contractor")
	    {
	    	$scope.showGuest = true;
	    	$scope.showContractor = true;
	    }
		
	};
	
			
		$scope.SetValues=function(response){
			var name=response.firstName;
			if(response.middleName != null)
				{
					name= name+" "+response.middleName;
				}
			if(response.lastName != null)
				{
				name= name+" "+response.lastName;
				}
			$scope.firstName=name;
			
			/*$scope.middleName=response.middleName;
			$scope.lastName=response.lastName;*/
			$scope.dateOfBirth=response.dateOfBirth;
			$scope.address=response.address;
			
			$scope.vehicleNumber=response.vehicleNumber;
			$scope.visitorType=response.visitorType;
			$scope.addressProofType=response.addressProofType;
			$scope.rank=response.rank;
			$scope.officerId=response.officerId;
			$scope.dependentId=response.dependentId;
			$scope.dependentOfficerId=response.dependentOfficerId;
			$scope.relation=response.relation;
			$scope.personToMeet=response.personToMeet;
			$scope.vendorId=response.vendorId;
			$scope.vendorName=response.vendorName;
			$scope.vendorAddress=response.vendorAddress;
			$scope.contractorId=response.contractorId;
			$scope.contractorName=response.contractorName;
			$scope.contractorAddress=response.contractorAddress;
			
		};
		
		var prsId=window.location.href.split('=')[1];
		
			$http.get("/vms/personDetails.htm",
					{
						params : {
							personId : prsId	
						}
			
					}	
			).success(
					function(response,status){
						
						console.log("data got",response);
						
						$scope.visitorType=response.visitorType;
						$scope.addressProofType=response.addressProofType;
						$scope.ManageDiv();
						$scope.SetValues(response);
						
						
											
					}
					).error(function(response,status){
						
					});
			
			
	
	
}]);