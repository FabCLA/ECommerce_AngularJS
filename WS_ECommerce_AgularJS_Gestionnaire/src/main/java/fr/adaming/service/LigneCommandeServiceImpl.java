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

import fr.adaming.dao.ILigneCommandeDao;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;

@Service("ligneCommandeBean")
@Transactional
public class LigneCommandeServiceImpl implements ILigneCommandeService{
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
	@Autowired
	private ILigneCommandeDao ligneCDao;
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

	public void addLigneCService(LigneCommande LigneC) {
		ligneCDao.addLigneCDao(LigneC);
		
	}

	public void deleteLigneCService(long id_LigneC) {
		ligneCDao.deleteLigneCDao(id_LigneC);
		
	}

	public void updateLigneCService(LigneCommande LigneC) {
		ligneCDao.updateLigneCDao(LigneC);
		
	}
	
	@Override
	public LigneCommande getLigneCByProduitService(Produit produit, Panier panier) {
		return ligneCDao.getLigneCByProduitDao(produit, panier);
	}
	
	@Override
	public List<LigneCommande> getLCsByPanierService(Panier panier) {
		return ligneCDao.getLCsByPanierDao(panier);
	}

	@Override
	public List<LigneCommande> getLigneCByIdPanierService(long id_panier) {
		return ligneCDao.getLigneCByIdPanierDao(id_panier);
	}

	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------



}
