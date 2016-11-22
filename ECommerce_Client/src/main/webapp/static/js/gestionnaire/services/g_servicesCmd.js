monApp.factory('cmdFactory',function($http){
	
	var urlString="http://localhost:8080/WS_ECommerce_AgularJS_Gestionnaire/gestionnaire/";
	
	function getCmdByIdCli(id,callback){
		$http({
			method:'GET',
			url:urlString+'getCommandeByIdClient/'+id
		})
		
		  .success(function(response){
			console.log(response);
			callback(response)
		})
		
		  .error(function(response){
			console.log('Error: '+response.statusText);
		});
	}
	
		
	function deleteCmdById(id,callback){
		$http({
			method:'DELETE',
			url:urlString+'deleteCommande/'+id
		})
		
		  .success(function(response){
			console.log(response);
			callback(response)
		})
		
		  .error(function(response){
			console.log('Error: '+response.statusText);
		});
	}
		
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
	
	return {
		getCmdByIdCli : getCmdByIdCli,
		deleteCmdById : deleteCmdById,
		
		getLCByIdPanier : getLCByIdPanier
	}
	
});