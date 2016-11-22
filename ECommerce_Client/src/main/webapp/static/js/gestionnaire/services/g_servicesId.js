monApp.factory('idFactory',function($http){
	
	var urlString="http://localhost:8080/WS_ECommerce_AgularJS_Gestionnaire/gestionnaire/";
	
	function identification(login,mdp,callback){
		$http({
			method:'GET',
			url:urlString+'authentGest/'+login+'/'+mdp
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
		identification : identification
	}
	
});