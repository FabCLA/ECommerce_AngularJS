package fr.adaming.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IPanierService;
import fr.adaming.service.IProduitService;

@RestController
@RequestMapping(value="/user")
public class UserRestController {
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
	@Autowired
	IProduitService produitServ;
	
	@Autowired
	ICategorieService categorieServ;
	
	@Autowired
	IPanierService panierServ;
	
	@Autowired
	IClientService clientServ;
	
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
	
	/**
	 * @param categorieServ the categorieServ to set
	 */
	public void setCategorieServ(ICategorieService categorieServ) {
		this.categorieServ = categorieServ;
	}
	
	/**
	 * @param panierServ the panierServ to set
	 */
	public void setPanierServ(IPanierService panierServ) {
		this.panierServ = panierServ;
	}
	
	/**
	 * @param clientServ the clientServ to set
	 */
	public void setClientServ(IClientService clientServ) {
		this.clientServ = clientServ;
	}

	//----------------------------------------------------------------------------------------------------------------
//---------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */
//============================================ Produit ===========================================================
//==																										   ==
	/*@RequestMapping(value="/addProduit",method=RequestMethod.POST,consumes="application/json")
	public void addProduit(@RequestBody Produit produit){
		produitServ.addProduitService(produit);
	}
	
	@RequestMapping(value="/deleteProduit/{id}",method=RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id")long id_produit){
		produitServ.deleteProduitService(id_produit);
	}
	
	@RequestMapping(value="/updateProduit",method=RequestMethod.PUT,consumes="application/json")
	public void updateProduit(@RequestBody Produit produit){
		produitServ.updateProduitService(produit);
	}*/
	
	@RequestMapping(value="/allproduit",method=RequestMethod.GET,produces="application/json")
	public List<Produit> getAllProduit(){
		return produitServ.getAllProduitService();
	}
	
	@RequestMapping(value="/produitByCategorie/{id}",method=RequestMethod.GET,produces="application/json")
	public List<Produit> getProduitByCategorie(@PathVariable("id") int id){
		Categorie categorie=new Categorie(id,"cat");
		return produitServ.getProduitByCategorieService(categorie);
	}
	
	@RequestMapping(value="/produitById/{id}",method=RequestMethod.GET,produces="application/json")
	public Produit getProduitById(@PathVariable("id")long id){
		return produitServ.getProduitByIdService(id);	
	}
	
	@RequestMapping(value="/idProduitByNom/{nom}",method=RequestMethod.GET,produces="application/json")
	public long getIdProduitByNom(@PathVariable("nom")String nomProduit){
		return produitServ.getIdProduitByNomService(nomProduit);
	}
//==																										   ==
//===============================================================================================================
	
//============================================ Catégorie ========================================================
//==																										   ==	
	@RequestMapping(value="/allcategorie",method=RequestMethod.GET,produces="application/json")
	public List<Categorie> getAllCategorie(){
		return categorieServ.getAllCategorieService();
	}
	
	@RequestMapping(value="/categorieByNom/{nom}",method=RequestMethod.GET,produces="application/json")
	public Categorie getCategorieByNomService(@PathVariable("nom")String nom_cat){
		System.out.println(categorieServ.getCategorieByNomService(nom_cat));
		return categorieServ.getCategorieByNomService(nom_cat);
	}
//==																										   ==
//===============================================================================================================

//============================================ Panier ===========================================================
//==																										   ==	
	@RequestMapping(value="/addPanier",method=RequestMethod.POST,consumes="application/json")
	public void addPanier(@RequestBody Panier panier){
		panierServ.addPanierService(panier);
	}
	
	@RequestMapping(value="/deletePanier/{id}",method=RequestMethod.DELETE)
	public void deletePanier(@PathVariable("id")long id_panier){
		panierServ.deletePanierService(id_panier);
	}
	
	@RequestMapping(value="/updatePanier",method=RequestMethod.PUT,consumes="application/json",produces="application/json")
	public void updatePanier(@RequestBody Panier panier){
		panierServ.updatePanierService(panier);
	}
	
	@RequestMapping(value="/isExistPanier")
	public int isExist(){
		return panierServ.isExistService();
	}
	
	@RequestMapping(value="/getActivePanier",method=RequestMethod.GET,produces="application/json")
	public Panier getActivePanier(){
		return panierServ.getActivePanierService();
	}
//==																										   ==
//===============================================================================================================

//============================================ CLient ===========================================================
//==																										   ==	
	@RequestMapping(value="/addClient",method=RequestMethod.POST,consumes="application/json")
	public void addClient(@RequestBody Client client){
		clientServ.addClientService(client);
	}
	
	@RequestMapping(value="/deleteClient/{id}",method=RequestMethod.DELETE)
	public void deleteClient(@PathVariable("id")long id_client){
		clientServ.deleteClientService(id_client);
	}
	
	@RequestMapping(value="/updateClient",method=RequestMethod.PUT,consumes="application/json")
	public void updateProduit(@RequestBody Client client){
		clientServ.updateClientService(client);
	}
	
//==																										   ==
//===============================================================================================================
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
}
