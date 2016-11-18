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

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Service("produitServiceBean")
@Transactional
public class ProduitServiceImpl implements IProduitService{
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
	@Autowired
	private IProduitDao produitDao;
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

	public void addProduitService(Produit produit) {
		produitDao.addProduitDao(produit);
		
	}

	public void deleteProduitService(long id_produit) {
		produitDao.deleteProduitDao(id_produit);
		
	}

	public void updateProduitService(Produit produit) {
		produitDao.updateProduitDao(produit);
		
	}

	public List<Produit> getAllProduitService() {
		return produitDao.getAllProduitDao();
	}

	public List<Produit> getProduitByCategorieService(Categorie categorie) {
		return produitDao.getProduitByCategorieDao(categorie);
	}

	public Produit getProduitByIdService(long id_produit) {
		return produitDao.getProduitByIdDao(id_produit);
	}
	
	@Override
	public long getIdProduitByNomService(String nomProduit) {
		return produitDao.getIdProduitByNomDao(nomProduit);
	}
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------


}
