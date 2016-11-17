/**
 * 
 * @author CLAIN Fabien
 * Date :27/10/2016
 * 
 */
package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;
@Repository
public class CategorieDaoImpl implements ICategorieDao {
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
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
//----------------------------------------------------------------------------------------------------------------
//---------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */
	public void addCategorieDao(Categorie categorie) {
		Session s = sf.getCurrentSession();
		s.save(categorie);

	}

	public void deleteCategorieDao(long id_cat) {
		Session s = sf.getCurrentSession();
		Categorie cat = (Categorie) s.get(Categorie.class, id_cat);
		s.delete(cat);

	}

	public void updateCategorieDao(Categorie categorie) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(categorie);

	}

	public List<Categorie> getAllCategorieDao() {
		Session s = sf.getCurrentSession();
		String req = "FROM Categorie";
		Query query =s.createQuery(req);
		
		return query.list();
	}

	public Categorie getCategorieByNomDao(String nom_cat) {
		Session s = sf.getCurrentSession();
		String req = "FROM Categorie WHERE nom=:cat_nom";
		Query query = s.createQuery(req);
		
		query.setParameter("cat_nom", nom_cat);
		
		return (Categorie) query.uniqueResult();
	}

//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------

}
