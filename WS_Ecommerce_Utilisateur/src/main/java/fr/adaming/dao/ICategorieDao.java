/**
 * 
 * @author CLAIN Fabien
 * Date : 15/10/2016
 * 
 */
package fr.adaming.dao;

import java.util.List;


import fr.adaming.model.Categorie;


public interface ICategorieDao {
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
	public void addCategorieDao(Categorie categorie);
	public void deleteCategorieDao(long id_cat);
	public void updateCategorieDao(Categorie categorie);
	public List<Categorie> getAllCategorieDao();
	public Categorie getCategorieByNomDao(String nom_cat);
//-------------------------------------------------------------------------------------------------------------
}
