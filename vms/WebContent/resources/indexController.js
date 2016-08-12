var app = angular.module('myApp', []);
app.controller('indexController',['$scope','$http', function($scope,$http) {
	$scope.showFingerPrintImage = true;
	$scope.showPasscodeImage = true;
	$scope.showIdBox = false;
	$scope.showPasscodeBox = false;
	$scope.successDiv = false;
	 $scope.errorDiv = false;
	 $scope.personId="";
	
	$scope.fingerprintCheck = function(){
		console.log("In fingerprint check");
		$scope.showFingerPrintImage = true;
		$scope.showPasscodeImage = false;
		$scope.showIdBox = true;
		$scope.showPasscodeBox = false;
	};
	
	$scope.passcodeCheck = function(){
		console.log("In passcode check");
		$scope.showPasscodeImage = true;
		$scope.showFingerPrintImage = false;
		$scope.showIdBox = true;
		$scope.showPasscodeBox = true;
	};
	
	$scope.cancelCheck = function(){
		console.log("In cancel check");
		$scope.showFingerPrintImage = true;
		$scope.showPasscodeImage = true;
		$scope.showIdBox = false;
		$scope.showPasscodeBox = false;
	};
	
	$scope.FindPersonSubmitForm = function (){
		$scope.successDiv = false;
		 $scope.errorDiv = false;
		 $scope.successMessage="";
		 $scope.errorMessage="";
		 
		 
		    var personId =$scope.personId;
		    
		    if(personId!=""){
		    	
			var formData = new FormData();
			formData.append('personId', personId);
			
			$http.post(
					'/vms/findPerson.htm',
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
									$scope.successMessage="Match found for given Person Id";
									//$scope.successDiv = true;
									window.location = '/vms/viewperson.htm?personId=' + data.message;
								}
								else
								{
									$scope.errorMessage="No Details found";
									alert("No Details found for entered Person Id");
									//$scope.errorDiv = true;
								}
							}).
							error(function(data,status){
								console.log(data);
							});
	
		    }
	};
}]);