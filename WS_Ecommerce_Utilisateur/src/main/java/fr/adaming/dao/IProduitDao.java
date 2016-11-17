/**
 * 
 * @author CLAIN Fabien
 * Date : 15/10/2016
 * 
 */
package fr.adaming.dao;

import java.util.List;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;


public interface IProduitDao {
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
	public void addProduitDao(Produit produit);
	public void deleteProduitDao(long id_produit);
	public void updateProduitDao(Produit produit);
	public List<Produit> getAllProduitDao();
	public List<Produit> getProduitByCategorieDao(Categorie categorie);
	public Produit getProduitByIdDao(long id_produit);
	public long getIdProduitByNomDao(String nomProduit);
//-------------------------------------------------------------------------------------------------------------
}
