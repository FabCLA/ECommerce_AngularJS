/**
 * 
 * @author CLAIN Fabien
 * Date : 15/10/2016
 * 
 */
package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.Produit;

public interface ICommandeDao {
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
	public void addCommandeDao(Commande cmd);
	public void deleteComandeDao(long id_cmd);
	public List<Commande> getCommandesByClientDao(Client client);
	public List<Commande> getCommandesByIdClientDao(long id_client);
	public Commande getCommandeByIdDao(long id_commande);
//-------------------------------------------------------------------------------------------------------------
}
