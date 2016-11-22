monApp
		.controller('getAllCtrl',function($scope,prodFactory){
	
		$scope.searchPrix=2000;
			prodFactory.getAll(function(callback){
			$scope.produit=callback;			
		});
		
			prodFactory.getAllCat(function(callback){
			$scope.categorie=callback;			
		});
		
		
		$scope.doDeleteByIdLien=function(p){
			
			prodFactory.deleteById(p.id_produit,function(callback){
				prodFactory.getAll(function(callback){
					$scope.produit=callback;			
				});
			});		
		}
		
		
		$scope.modifierLien=function(p){
			
			prodFactory.update(p,function(callback){
				prodFactory.getAll(function(callback){
					$scope.produit=callback;			
				});
			});		
		}
		
		$scope.prodForm={
				nom:"",
				description:"",
				prix:"",
				quantite:""
		}

		$scope.ajouter=function(){
			
			prodFactory.add($scope.prodForm,function(callback){			
				prodFactory.getAll(function(callback){
					$scope.produit=callback;			
				});
			});		
		}
		
		
		
})
		.controller('getAllCatCtrl',function($scope,catFactory){
			
			
			catFactory.getAllCat(function(callback){
			$scope.categorie=callback;			
		});
		
		
		$scope.doDeleteCatByIdLien=function(cat){
			
			catFactory.deleteCatById(cat.id_categorie,function(callback){
				catFactory.getAllCat(function(callback){
					$scope.categorie=callback;			
				});
			});		
		}
		
		
		$scope.modifierCatLien=function(cat){
			
			catFactory.updateCat(cat,function(callback){
				catFactory.getAllCat(function(callback){
					$scope.categorie=callback;			
				});
			});		
		}
		
		$scope.catForm={
				nom:"",
				description:"",
				prix:"",
				quantite:""
		}

		$scope.ajouterCat=function(){
			
			catFactory.addCat($scope.catForm,function(callback){			
				catFactory.getAllCat(function(callback){
					$scope.categorie=callback;			
				});
			});		
		}
		
})
	  .controller('getAllClientCtrl',function($scope,$rootScope,clientFactory,$location){
			
			
			clientFactory.getAllClient(function(callback){
			$rootScope.client=callback;			
		});
		
		
		$scope.doDeleteClientByIdLien=function(client){
			
			clientFactory.deleteClientById(client.id_client,function(callback){
				clientFactory.getAllClient(function(callback){
					$scope.client=callback;			
				});
			});		
		}
		
		
		$scope.modifierClientLien=function(client){
			
			clientFactory.updateClient(client,function(callback){
				clientFactory.getAllClient(function(callback){
					$scope.client=callback;			
				});
			});		
		}
		
		$scope.clientForm={
				nom:"",
				description:"",
				prix:"",
				quantite:""
		}

		$scope.ajouterClient=function(){
			
			clientFactory.addClient($scope.clientForm,function(callback){			
				clientFactory.getAllClient(function(callback){
					$scope.client=callback;			
				});
			});		
		}
		
				
		$scope.doGetCmdByIdCliLien=function(client){
			
			clientFactory.getCmdByIdCli(client.id_client,function(callback){
				$rootScope.commande=callback;
				$location.path("/listeCmd");
				
			});
				
		}
		
})

	  .controller('getCmdByIdCli',function($scope,$rootScope,cmdFactory,$location){
			
		$scope.commande=$rootScope.commande;
		$scope.client=$rootScope.client;
			
		$scope.doGetCmdByIdCliLien=function(client){
			
			cmdFactory.getCmdByIdCli(client.id,function(callback){
				$scope.commande=callback;
				$location.path("/listeCmd");
			});
				
		}
		
		$scope.doDeleteCmdByIdLien=function(commande){
			
			cmdFactory.deleteCmdById(commande.id_commande,function(callback){
				$scope.doGetCmdByIdCliLien=function(client){
					
					cmdFactory.getCmdByIdCli($scope.client.id_client,function(callback){
						$scope.commande=callback;
						$location.path("/listeCmd/");
					});
						
				}
			});		
		}
		
		
		$scope.doGetLCByIdCmdLien=function(commande){
			
			cmdFactory.getLCByIdPanier(commande.panier.id_panier,function(callback){
				$rootScope.lignecommande=callback;
				$location.path("/listeLC");
				
			});
				
		}
				
})

	  .controller('getLCByIdCmd',function($scope,$rootScope,lcFactory,$location){
			
		$scope.lignecommande=$rootScope.lignecommande;
		$scope.commande=$rootScope.commande;
			
		$scope.doGetLCByIdCmdLien=function(commande){
			
			lcFactory.getLCByIdCmd(commande.panier,function(callback){
				$scope.lignecommande=callback;
				$location.path("/listeLC/");
			});
				
		}

		$scope.doDeleteLCByIdLien=function(lignecommande){
			
			lcFactory.deleteLCById(lignecommande.id_LC,function(callback){
				$scope.doGetLCByIdCmdLien=function(commande){
					
					cmdFactory.getLCByIdPanier(commande.panier.id_panier,function(callback){
						$rootScope.lignecommande=callback;						
					});
						
				}
			});		
		}		
				
})

	.controller('identificationCtrl',function($scope,idFactory,$location){
		
		$scope.g=undefined;
				
		$scope.doAuthent=function(g){
			
			idFactory.identification(g.login,g.mdp,function(callback){
				if(callback==1){
					$location.path("/liste");
				}else{
					$location.path("/identification/");
				}
				
			});
				
		}
})
