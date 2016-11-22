monApp.factory('prodFactory',function($http){
	
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
	
	function add(prodForm,callback){
		$http({
			method:'POST',
			url:urlString+'addProduit',
			
			//Pour que les elements du formulaire soit transformés en objets JSON
			data:angular.toJson(prodForm),
			
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
	
	function deleteById(id,callback){
		$http({
			method:'DELETE',
			url:urlString+'deleteProduit/'+id
		})
		
		  .success(function(response){
			console.log(response);
			callback(response)
		})
		
		  .error(function(response){
			console.log('Error: '+response.statusText);
		});
	}
	
	function update(prodForm,callback){
		$http({
			method:'PUT',
			url:urlString+'updateProduit',
			
			//Pour que les elements du formulaire soit transformés en objets JSON
			data:angular.toJson(prodForm),
			
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
	
	function getAllCat(callback){
		$http({
			method:'GET',
			url:urlString+'allcategorie'
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
		getAll : getAll,
		add : add,
		deleteById : deleteById,
		update : update,
		
		getAllCat : getAllCat
	}
	
});