monApp.factory('paysFactory',function($http){
	
	var urlString="http://localhost:8080/WS_ECommerce_AgularJS_Gestionnaire/gestionnaire/";
	
	function getAll(callback){
		$http({
			method:'GET',
			url:urlString+'allProduit'
		})
		
		  .success(function(response){
			console.log(response);
			callback(response)
		})
		
		  .error(function(response){
			console.log('Error: '+response.statusText);
		});
	}
	
	return {
		getAll : getAll
	}
	
});