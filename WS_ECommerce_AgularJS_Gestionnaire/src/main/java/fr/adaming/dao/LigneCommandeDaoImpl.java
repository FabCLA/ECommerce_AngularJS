/**
 * 
 * @author CLAIN Fabien
 * Date :27/10/2016
 * 
 */
package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;
import fr.adaming.service.ProduitServiceImpl;
@Repository
public class LigneCommandeDaoImpl implements ILigneCommandeDao {
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
	@Autowired
	private SessionFactory sf;
	
	@Autowired
	private IProduitService produitService;
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
	/**
	 * @param sf the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
//----------------------------------------------------------------------------------------------------------------
//---------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */
	public void addLigneCDao(LigneCommande LigneC) {
		Session s = sf.getCurrentSession();
		s.save(LigneC);
	}

	public void deleteLigneCDao(long id_LigneC) {
		Session s = sf.getCurrentSession();
		LigneCommande ligneC = (LigneCommande) s.get(LigneCommande.class, id_LigneC);
		s.delete(ligneC);
	}

	public void updateLigneCDao(LigneCommande LigneC) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(LigneC);

	}
	
	@Override
	public LigneCommande getLigneCByProduitDao(Produit produit, Panier panier) {
		Session s = sf.getCurrentSession();
		String req = "FROM LigneCommande lc WHERE lc.produit.id_produit=:produit_id AND lc.panier.id_panier=:panier_id";
		Query query =s.createQuery(req);
		
		
		query.setParameter("produit_id", produitService.getIdProduitByNomService(produit.getNom()));
		query.setParameter("panier_id", panier.getId_panier());
		return (LigneCommande) query.uniqueResult();
	}
	
	@Override
	public List<LigneCommande> getLCsByPanierDao(Panier panier) {
		Session s = sf.getCurrentSession();
		String req ="FROM LigneCommande lc WHERE lc.panier.id_panier=:id";
		Query query = s.createQuery(req);
		
		query.setParameter("id", panier.getId_panier());
		
		return query.list();
	}
	
	
	@Override
	public List<LigneCommande> getLigneCByIdPanierDao(long id_panier) {
		
		Session s = sf.getCurrentSession();
		
		String reqSql="SELECT * FROM lignecommande WHERE panier_id=?";
		SQLQuery querySql=s.createSQLQuery(reqSql);
		querySql.addEntity(LigneCommande.class);
		
		querySql.setParameter(0, id_panier);
		
		return querySql.list();
	
	}
	
	
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------



}
