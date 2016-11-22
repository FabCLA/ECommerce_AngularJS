monApp.factory('clientFactory',function($http){
	
	var urlString="http://localhost:8080/WS_ECommerce_AgularJS_Gestionnaire/gestionnaire/";
	
	function getAllClient(callback){
		$http({
			method:'GET',
			url:urlString+'allClient'
		})
		
		  .success(function(response){
			console.log(response);
			callback(response)
		})
		
		  .error(function(response){
			console.log('Error: '+response.statusText);
		});
	}
	
	
	function addClient(clientForm,callback){
		$http({
			method:'POST',
			url:urlString+'addClient',
			
			//Pour que les elements du formulaire soit transformés en objets JSON
			data:angular.toJson(clientForm),
			
			headers:{'Content-Type':'application/json'}
		})
		
		  .success(function(response){
			console.log(response);
			callback(response)
		})
		
		  .error(function(response){
			console.log('Error: '+response.statusText);
		});
	}
	
	function deleteClientById(id,callback){
		$http({
			method:'DELETE',
			url:urlString+'deleteClient/'+id
		})
		
		  .success(function(response){
			console.log(response);
			callback(response)
		})
		
		  .error(function(response){
			console.log('Error: '+response.statusText);
		});
	}
	
	function updateClient(clientForm,callback){
		$http({
			method:'PUT',
			url:urlString+'updateClient',
			
			//Pour que les elements du formulaire soit transformés en objets JSON
			data:angular.toJson(clientForm),
			
			headers:{'Content-Type':'application/json'}
		})
		
		  .success(function(response){
			console.log(response);
			callback(response)
		})
		
		  .error(function(response){
			console.log('Error: '+response.statusText);
		});
	}
		
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
	
	
	
	return {
		getAllClient : getAllClient,
		addClient : addClient,
		deleteClientById : deleteClientById,
		updateClient : updateClient,		
		
		getCmdByIdCli : getCmdByIdCli
	}
	
});