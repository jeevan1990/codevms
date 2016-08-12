var app = angular.module('myApp', []);
app.controller('myCtrl',['$scope','$http', function($scope,$http) {
	 $scope.successDiv = false;
	 $scope.errorDiv = false;
	 $scope.personId="";
	
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
										$scope.errorDiv = true;
									}
								}).
								error(function(data,status){
									console.log(data);
								});
		
			    }
		};
	
}]);