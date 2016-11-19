monApp.config(function($routeProvider){
	$routeProvider
					.when('/liste',{
						templateUrl:"partials/gestionnaire/getAll.html",
						controller:"getAllCtrl"
					})
					
					.otherwise({
						redirectTo: '/liste'
					});
})