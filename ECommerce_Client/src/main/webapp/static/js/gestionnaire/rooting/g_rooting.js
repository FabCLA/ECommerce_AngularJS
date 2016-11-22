monApp.config(function($routeProvider){
	$routeProvider
					.when('/liste',{
						templateUrl:"partials/gestionnaire/getAll.html",
						controller:"getAllCtrl"
					})
					
					.when('/listeCat',{
						templateUrl:"partials/gestionnaire/getAllCat.html",
						controller:"getAllCatCtrl"
					})
					
					.when('/listeClient',{
						templateUrl:"partials/gestionnaire/getAllClient.html",
						controller:"getAllClientCtrl"
					})
					
					.when('/listeCmd/',{
						templateUrl:"partials/gestionnaire/getCmdByIdCli.html",
						controller:"getCmdByIdCli"
					})
					
					.when('/listeLC/',{
						templateUrl:"partials/gestionnaire/getLCByIdCmd.html",
						controller:"getLCByIdCmd"
					})
					
					.when('/identification',{
						templateUrl:"partials/gestionnaire/identification.html",
						controller:"identificationCtrl"
					})
										
					.otherwise({
						redirectTo: '/liste'
					});
})