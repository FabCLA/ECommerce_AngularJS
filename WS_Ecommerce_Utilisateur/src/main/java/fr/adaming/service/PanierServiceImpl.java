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

import fr.adaming.dao.IPanierDao;
import fr.adaming.model.Client;
import fr.adaming.model.Panier;

@Service("PanierServiceBean")
@Transactional
public class PanierServiceImpl implements IPanierService{
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
	@Autowired
	private IPanierDao panierDao;
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
	public void addPanierService(Panier panier) {
		panierDao.addPanierDao(panier);
		
	}

	public void deletePanierService(long id_panier) {
		panierDao.deletePanierDao(id_panier);
		
	}

	public void updatePanierService(Panier panier) {
		panierDao.updatePanierDao(panier);
		
	}

	public List<Panier> getAllPanierService() {
		return panierDao.getAllPanierDao();
	}

	public Panier getPanierByClientService(Client client) {
		return panierDao.getPanierByClientDao(client);
	}

	@Override
	public int isExistService() {
		return panierDao.isExistDao();
	}

	@Override
	public Panier getActivePanierService() {
		return panierDao.getActivePanierDao();
	}
	
	
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
}
