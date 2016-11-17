/**
 * 
 * @author CLAIN Fabien
 * Date : 15/10/2016
 * 
 */
package fr.adaming.dao;



import java.util.List;

import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;

public interface ILigneCommandeDao {
//------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
//-------------------------------------------------------------------------------------------------------------
//------------------------------2_Les constructeurs------------------------------------------------------------	
	/**
	 * 2_Les constructeurs
	 */
//-------------------------------------------------------------------------------------------------------------
//------------------------------3_Les Getters et Setters-------------------------------------------------------
	/**
	 * 3_Les Getters et Setters
	 */
//-------------------------------------------------------------------------------------------------------------
//------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */
	public void addLigneCDao(LigneCommande LigneC);
	public void deleteLigneCDao(long id_LigneC);
	public void updateLigneCDao(LigneCommande LigneC);
	public LigneCommande getLigneCByProduitDao(Produit produit, Panier panier);
	public List<LigneCommande> getLCsByPanierDao(Panier panier);
	public List<LigneCommande> getLigneCByIdCommandeDao(long id_commande);
//-------------------------------------------------------------------------------------------------------------
}
