/**
 * 
 * @author CLAIN Fabien
 * Date : 15/10/2016
 * 
 */
package fr.adaming.service;

import java.util.List;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;

public interface ILigneCommandeService {
	//-------------------------------------------------------------------------------------------------------------
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
		public void addLigneCService(LigneCommande LigneC);
		public void deleteLigneCService(long id_LigneC);
		public void updateLigneCService(LigneCommande LigneC);
		public LigneCommande getLigneCByProduitService(Produit produit ,Panier panier);
		public List<LigneCommande> getLCsByPanierService(Panier panier);
		public List<LigneCommande> getLigneCByIdCommandeService(long id_commande);
	//-------------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------------
}
