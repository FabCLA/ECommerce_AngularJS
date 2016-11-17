/**
 * 
 * @author CLAIN Fabien
 * Date :27/10/2016
 * 
 */
package fr.adaming.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Repository
public class ProduitDaoImpl implements IProduitDao {
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
	@Autowired
	private SessionFactory sf;
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
	public void addProduitDao(Produit produit) {
		Session s = sf.getCurrentSession();
		s.save(produit);

	}

	public void deleteProduitDao(long id_produit) {
		Session s = sf.getCurrentSession();
		Produit p = (Produit) s.get(Produit.class, id_produit);
		s.delete(p);
	}

	public void updateProduitDao(Produit produit) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(produit);
	}

	public List<Produit> getAllProduitDao() {
		Session s = sf.getCurrentSession();
		String req = "FROM Produit";
		Query query = s.createQuery(req);
		return query.list();
	}

	public List<Produit> getProduitByCategorieDao(Categorie categorie) {
		Session s = sf.getCurrentSession();
		long id_cat =categorie.getId_categorie();
		String req ="FROM Produit p WHERE p.categorie.id_categorie=:cat_id";
		Query query =s.createQuery(req);
		
		query.setParameter("cat_id", id_cat);
		
		return query.list();
	}

	public Produit getProduitByIdDao(long id_produit) {
		Session s = sf.getCurrentSession();
		String req ="FROM Produit p WHERE p.id_produit=:produit_id";
		Query query = s.createQuery(req);
		
		query.setParameter("produit_id", id_produit);
		
		return (Produit) query.uniqueResult();
	}

	public long getIdProduitByNomDao(String nomProduit) {
		Session s = sf.getCurrentSession();
		String req="SELECT id_produit FROM produit WHERE nom=:id";
		Query query = s.createSQLQuery(req);
		query.setParameter("id", nomProduit);
		return ((BigInteger) query.uniqueResult()).longValue();
	}
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
}
