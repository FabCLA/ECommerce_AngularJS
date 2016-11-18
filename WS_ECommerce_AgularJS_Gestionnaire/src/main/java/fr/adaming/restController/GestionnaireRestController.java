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
import fr.adaming.model.Commande;
import fr.adaming.model.Gestionnaire;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICommandeService;
import fr.adaming.service.IGestionnaireService;
import fr.adaming.service.ILigneCommandeService;
import fr.adaming.service.IProduitService;

@RestController
@RequestMapping(value="/gestionnaire")
public class GestionnaireRestController {
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
	@Autowired
	IProduitService produitServ;
	
	@Autowired
	IGestionnaireService gestServ;
	
	@Autowired
	ICategorieService catServ;
	
	@Autowired
	IClientService clientServ;
	
	@Autowired
	ICommandeService commandeServ;
	
	@Autowired
	ILigneCommandeService LCServ;
	
	
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
	
	
	public void setGestServ(IGestionnaireService gestServ) {
		this.gestServ = gestServ;
	}	


	public void setCatServ(ICategorieService catServ) {
		this.catServ = catServ;
	}


	public void setClientServ(IClientService clientServ) {
		this.clientServ = clientServ;
	}


	public void setLCServ(ILigneCommandeService lCServ) {
		LCServ = lCServ;
	}


	//----------------------------------------------------------------------------------------------------------------
//---------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */
//============================================ Gestionnaire ========================================================
//==
	
	@RequestMapping(value="/authentGest/{login}/{mdp}",method=RequestMethod.GET,produces="application/json")
	public int authentGest(@PathVariable("login") String login, @PathVariable("mdp") String mdp){
		return gestServ.isExistService(login, mdp);
	}
	
	
	

//============================================ Produit ========================================================
//==
	
	@RequestMapping(value="/allProduit",method=RequestMethod.GET,produces="application/json")
	public List<Produit> getAllProduit(){
		return produitServ.getAllProduitService();
	}
	
	@RequestMapping(value="/produitById/{id}",method=RequestMethod.GET,produces="application/json")
	public Produit getProduitById(@PathVariable("id")long id){
		return produitServ.getProduitByIdService(id);	
	}
	
	@RequestMapping(value="/produitByCategorie/{id}",method=RequestMethod.GET,produces="application/json")
	public List<Produit> getProduitByCategorie(@PathVariable("id") int id){
		Categorie categorie=new Categorie(id,"cat");
		return produitServ.getProduitByCategorieService(categorie);
	}
	
	@RequestMapping(value="/addProduit",method=RequestMethod.POST,consumes="application/json")
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
	}
	
	@RequestMapping(value="/idProduitByNom/{nom}",method=RequestMethod.GET,produces="application/json")
	public long getIdProduitByNom(@PathVariable("nom")String nomProduit){
		return produitServ.getIdProduitByNomService(nomProduit);
	}
	
	
	
//============================================ Catégorie ========================================================
//==																										   ==	
	@RequestMapping(value="/allcategorie",method=RequestMethod.GET,produces="application/json")
	public List<Categorie> getAllCategorie(){
		return catServ.getAllCategorieService();
	}
	
	@RequestMapping(value="/categorieByNom/{nom}",method=RequestMethod.GET,produces="application/json")
	public Categorie getCategorieByNomService(@PathVariable("nom")String nom_cat){
		return catServ.getCategorieByNomService(nom_cat);
	}
	
	@RequestMapping(value="/addCategorie",method=RequestMethod.POST,consumes="application/json")
	public void addCategorie(@RequestBody Categorie categorie){
		catServ.addCategorieService(categorie);
	}
	
	@RequestMapping(value="/deleteCategorie/{id}",method=RequestMethod.DELETE)
	public void deleteCategorie(@PathVariable("id")long id_cat){
		catServ.deleteCategorieService(id_cat);
	}
	
	@RequestMapping(value="/updateCategorie",method=RequestMethod.PUT,consumes="application/json")
	public void updateCategorie(@RequestBody Categorie categorie){
		catServ.updateCategorieService(categorie);
	}
	
	
//============================================ Client ========================================================
//==
	
	
	@RequestMapping(value="/allClient",method=RequestMethod.GET,produces="application/json")
	public List<Client> getAllClient(){
		return clientServ.getAllClientService();
	}
	
	@RequestMapping(value="/clientById/{id}",method=RequestMethod.GET,produces="application/json")
	public Client getClientById(@PathVariable("id")long id){
		return clientServ.getClientByIdService(id);
	}
		
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
	
//========================================== Ligne de commande ==================================================
//==																										   ==	

	
	@RequestMapping(value="/getLCByPanier",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public List<LigneCommande> getLCsByPanier(@RequestBody Panier panier){
		return LCServ.getLCsByPanierService(panier);
	}
	
	@RequestMapping(value="/addLC",method=RequestMethod.POST,consumes="application/json")
	public void addLigneC(@RequestBody LigneCommande LigneC){
		LCServ.addLigneCService(LigneC);
	}
	
	@RequestMapping(value="/deleteLC/{id}",method=RequestMethod.DELETE)
	public void deleteLigneC(@PathVariable("id") long id_LigneC){
		LCServ.deleteLigneCService(id_LigneC);
	}
	
/*	@RequestMapping(value="/updateLC",method=RequestMethod.PUT,consumes="application/json")
	public void updateLigneC(@RequestBody LigneCommande LigneC){
		LCServ.updateLigneCService(LigneC);
	}*/
	
	
	
//============================================== Commande =======================================================
//==																										   ==	
	@RequestMapping(value="/addCommande",method=RequestMethod.POST,consumes="application/json")
	public void addCommande(@RequestBody Commande cmd){
		commandeServ.addCommandeService(cmd);
	}
	
	@RequestMapping(value="/deleteCommande/{id}",method=RequestMethod.DELETE)
	public void deleteComande(@PathVariable("id")long id_cmd){
		commandeServ.deleteComandeService(id_cmd);
	}
	
	@RequestMapping(value="/getCommandeByIdClient/{id}",method=RequestMethod.GET,produces="application/json")
	public List<Commande> getCommandesByIdClient(@PathVariable("id")long id_client){
		return commandeServ.getCommandesByIdClientService(id_client);
	}	
	
}
