/**
 * 
 * @author CLAIN Fabien
 * Date : 15/10/2016
 * 
 */
package fr.adaming.dao;

import java.util.List;


import fr.adaming.model.Client;
import fr.adaming.model.Panier;

public interface IPanierDao {
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
	public void addPanierDao(Panier panier);
	public void deletePanierDao(long id_panier);
	public void updatePanierDao(Panier panier);
	public List<Panier> getAllPanierDao();
	public Panier getPanierByClientDao(Client client);
	public int isExistDao();
	public Panier getActivePanierDao();
//-------------------------------------------------------------------------------------------------------------
}
