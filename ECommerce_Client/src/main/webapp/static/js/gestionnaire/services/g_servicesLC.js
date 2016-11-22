monApp.factory('lcFactory',function($http){
	
	var urlString="http://localhost:8080/WS_ECommerce_AgularJS_Gestionnaire/gestionnaire/";
	
	function getLCByIdPanier(id,callback){
		$http({
			method:'GET',
			url:urlString+'getLCByIdPanier/'+id
		})
		
		  .success(function(response){
			console.log(response);
			callback(response)
		})
		
		  .error(function(response){
			console.log('Error: '+response.statusText);
		});
	}
	
		
	function deleteLCById(id,callback){
		$http({
			method:'DELETE',
			url:urlString+'deleteLC/'+id
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
		getLCByIdPanier : getLCByIdPanier,
		deleteLCById : deleteLCById
		
	}
	
});