/**
 * 
 * @author CLAIN Fabien
 * Date :27/10/2016
 * 
 */
package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@Service("clientServiceBean")
@Transactional
public class ClientServiceImpl implements IClientService{
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
	@Autowired
	private IClientDao clientDao;
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
//----------------------------------------------------------------------------------------------------------------
//---------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */
	public void addClientService(Client client) {
		clientDao.addClientDao(client);
		
	}

	public void deleteClientService(long id_client) {
		clientDao.deleteClientDao(id_client);
		
	}

	public void updateClientService(Client client) {
		clientDao.updateClientDao(client);
		
	}

	public int isExistService(String mail, String password) {
		return clientDao.isExistDao(mail, password);
	}

	public List<Client> getAllClientService() {
		return clientDao.getAllClientDao();
	}
	
	@Override
	public Client getClientByIdentifiantService(String mail, String password) {
		
		return clientDao.getClientByIdentifiantDao(mail, password);
	}
	
	public Client getClientByIdService(long id_client){
		return clientDao.getClientByIdDao(id_client);
	}
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------

}
