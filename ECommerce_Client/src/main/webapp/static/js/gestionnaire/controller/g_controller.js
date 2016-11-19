monApp
		.controller('getAllCtrl',function($scope,paysFactory){
	
		
		paysFactory.getAll(function(callback){
			$scope.pays=callback;			
		});
})