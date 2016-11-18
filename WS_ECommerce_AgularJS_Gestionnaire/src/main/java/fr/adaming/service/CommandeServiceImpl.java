/**
 * 
 * @author CLAIN Fabien
 * Date :27/10/2016
 * 
 */
package fr.adaming.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICommandeDao;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;

@Service("CommandeServiceBean")
@Transactional
public class CommandeServiceImpl implements ICommandeService{
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
	@Autowired
	private ICommandeDao cmdDao;
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
	public void addCommandeService(Commande cmd) {
		cmdDao.addCommandeDao(cmd);	
	}

	public void deleteComandeService(long id_cmd) {
		cmdDao.deleteComandeDao(id_cmd);	
	}

	public List<Commande> getCommandesByClientService(Client client) {
		return cmdDao.getCommandesByClientDao(client);
	}
	
	public List<Commande> getCommandesByIdClientService(long id_client){
		return cmdDao.getCommandesByIdClientDao(id_client);
	}
	
	public Commande getCommandeByIdService(long id_commande) {				
		return cmdDao.getCommandeByIdDao(id_commande);
	}
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
}
