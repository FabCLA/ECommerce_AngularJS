package fr.adaming.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@RestController
public class ProduitRestController {
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
	@Autowired
	IProduitService produitServ;
//----------------------------------------------------------------------------------------------------------------
//---------------------------------2_Les constructeurs------------------------------------------------------------	
	/**
	 * 2_Les constructeurs
	 */
//----------------------------------------------------------------------------------------------------------------
//---------------------------------3_Les Getters et Setters-------------------------------------------------------
	/**
	 * 3_Les Getters et Setters
	 */

	/**
	 * @param produitServ the produitServ to set
	 */
	public void setProduitServ(IProduitService produitServ) {
		this.produitServ = produitServ;
	}
//----------------------------------------------------------------------------------------------------------------
//---------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */
	@RequestMapping(value="/allproduit",method=RequestMethod.GET,produces="application/json")
	public List<Produit> getAllProduit(){
		return produitServ.getAllProduitService();
	}
	
	@RequestMapping(value="/produitByCategorie/{id}",method=RequestMethod.GET,produces="application/json")
	public List<Produit> getProduitByCategorie(@PathVariable("id") int id){
		Categorie categorie=new Categorie(id,"eeeeeee");
		System.out.println(produitServ.getProduitByCategorieService(categorie).size());
		return produitServ.getProduitByCategorieService(categorie);
	}
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
}
