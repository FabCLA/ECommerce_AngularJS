monApp.factory('catFactory',function($http){
	
	var urlString="http://localhost:8080/WS_ECommerce_AgularJS_Gestionnaire/gestionnaire/";
	
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
	
	
	function addCat(catForm,callback){
		$http({
			method:'POST',
			url:urlString+'addCategorie',
			
			//Pour que les elements du formulaire soit transformés en objets JSON
			data:angular.toJson(catForm),
			
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
	
	function deleteCatById(id,callback){
		$http({
			method:'DELETE',
			url:urlString+'deleteCategorie/'+id
		})
		
		  .success(function(response){
			console.log(response);
			callback(response)
		})
		
		  .error(function(response){
			console.log('Error: '+response.statusText);
		});
	}
	
	function updateCat(catForm,callback){
		$http({
			method:'PUT',
			url:urlString+'updateCategorie',
			
			//Pour que les elements du formulaire soit transformés en objets JSON
			data:angular.toJson(catForm),
			
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
	
	
	return {
		getAllCat : getAllCat,
		addCat : addCat,
		deleteCatById : deleteCatById,
		updateCat : updateCat		
		
	}
	
});