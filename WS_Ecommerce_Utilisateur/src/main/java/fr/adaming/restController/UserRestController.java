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
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.model.ProduitPanier;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICommandeService;
import fr.adaming.service.ILigneCommandeService;
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
	private IProduitService produitServ;
	
	@Autowired
	private ICategorieService categorieServ;
	
	@Autowired
	private IPanierService panierServ;
	
	@Autowired
	private IClientService clientServ;
	
	@Autowired
	private ILigneCommandeService LCServ;
	
	@Autowired
	private ICommandeService commandeServ;
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

	/**
	 * @param lCServ the lCServ to set
	 */
	public void setLCServ(ILigneCommandeService lCServ) {
		LCServ = lCServ;
	}

	/**
	 * @param commandeServ the commandeServ to set
	 */
	public void setCommandeServ(ICommandeService commandeServ) {
		this.commandeServ = commandeServ;
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
	
	@RequestMapping(value="/allProduit",method=RequestMethod.GET,produces="application/json")
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
	@RequestMapping(value="/allCategorie",method=RequestMethod.GET,produces="application/json")
	public List<Categorie> getAllCategorie(){
		return categorieServ.getAllCategorieService();
	}
	
	@RequestMapping(value="/categorieByNom/{nom}",method=RequestMethod.GET,produces="application/json")
	public Categorie getCategorieByNomService(@PathVariable("nom")String nom_cat){
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
	
	@RequestMapping(value="/isExistClient/{mail}/{password}")
	public int isExist(@PathVariable("mail")String mail, @PathVariable("password")String password){
		return clientServ.isExistService(mail, password);
	}
	
	@RequestMapping(value="/getClientByIdent/{mail}/{password}",method=RequestMethod.GET,produces="application/json")
	public Client getClientByIdentifiant(@PathVariable("mail")String mail, @PathVariable("password")String password){
		System.out.println(clientServ.getClientByIdentifiantService(mail, password));
		return clientServ.getClientByIdentifiantService(mail, password);
	}
//==																										   ==
//===============================================================================================================
	
//========================================== Ligne de commande ==================================================
//==																										   ==	
	@RequestMapping(value="/addLC",method=RequestMethod.POST,consumes="application/json")
	public void addLigneC(@RequestBody LigneCommande LigneC){
		LCServ.addLigneCService(LigneC);
	}
	
	@RequestMapping(value="/deleteLC/{id}",method=RequestMethod.DELETE)
	public void deleteLigneC(@PathVariable("id") long id_LigneC){
		LCServ.deleteLigneCService(id_LigneC);
	}
	
	@RequestMapping(value="/updateLC",method=RequestMethod.PUT,consumes="application/json")
	public void updateLigneC(@RequestBody LigneCommande LigneC){
		LCServ.updateLigneCService(LigneC);
	}
	
	@RequestMapping(value="/getLCByProduitPanier",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public LigneCommande getLigneCByProduit(@RequestBody ProduitPanier produitPanier ){
		return LCServ.getLigneCByProduitService(produitPanier.getProduit(), produitPanier.getPanier());
	}
	
	@RequestMapping(value="/getLCByPanier",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public List<LigneCommande> getLCsByPanier(@RequestBody Panier panier){
		return LCServ.getLCsByPanierService(panier);
	}

//==																										   ==
//===============================================================================================================
	
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
	
//==																										   ==
//===============================================================================================================
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
}
