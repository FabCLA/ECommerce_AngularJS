/**
 * 
 * @author CLAIN Fabien
 * Date : 15/10/2016
 * 
 */
package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

public interface IProduitService {
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
		public void addProduitService(Produit produit);
		public void deleteProduitService(long id_produit);
		public void updateProduitService(Produit produit);
		public List<Produit> getAllProduitService();
		public List<Produit> getProduitByCategorieService(Categorie categorie);
		public Produit getProduitByIdService(long id_produit);
		public long getIdProduitByNomService(String nomProduit);
	//-------------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------------
}
