/**
 * 
 * @author CLAIN Fabien
 * Date : 15/10/2016
 * 
 */
package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {
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
		public void addClientService(Client client);
		public void deleteClientService(long id_client);
		public void updateClientService(Client client);
		public int isExistService(String mail, String password);
		public List<Client> getAllClientService();
		public Client getClientByIdentifiantService(String mail, String password);
		public Client getClientByIdService(long id_client);
	//-------------------------------------------------------------------------------------------------------------

}
