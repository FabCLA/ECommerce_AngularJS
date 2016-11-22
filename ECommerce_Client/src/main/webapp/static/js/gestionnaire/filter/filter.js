monApp.filter('lowerThan',function(){
		return function(input, searchPrix) {
			var tableauAffiche = [];
			input.forEach(function(p){
				if(p.prix <searchPrix){tableauAffiche.push(p);}
			});
			return tableauAffiche;
		}
});