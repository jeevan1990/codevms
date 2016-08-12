var app = angular.module('myApp', []);
app.controller('myCtrl',['$scope','$http', function($scope,$http) {
	
	$scope.personId="";
	$scope.fingerindex="";
	$scope.errorDiv = false;
			
	$scope.fileupload = function (){
		console.log("hi in fingerprint file");
		$scope.errorDiv = false;
		
		var formData = new FormData();
		formData.append('personId', $scope.personId);
		formData.append('fingerindex', $scope.fingerindex);
		formData.append("fingerprint",document.getElementById('fingerprint').files[0]);
		
		$http.post(
				'/vms/uploadFingerprint.htm',
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
							console.log("success");
							$scope.successMessage=data;
							$scope.errorDiv = true;
						}).
						error(function(data,status){
							console.log("failed");
						});
		
	};
	
}]);