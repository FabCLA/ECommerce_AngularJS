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

import fr.adaming.model.Client;
import fr.adaming.model.Panier;
@Repository
public class PanierDaoImpl implements IPanierDao {
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
	public void addPanierDao(Panier panier) {
		Session s = sf.getCurrentSession();
		s.save(panier);

	}

	public void deletePanierDao(long id_panier) {
		Session s = sf.getCurrentSession();
		Panier panier = (Panier) s.get(Panier.class, id_panier);
		s.delete(panier);

	}

	public void updatePanierDao(Panier panier) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(panier);

	}

	public List<Panier> getAllPanierDao() {
		Session s = sf.getCurrentSession();
		String req = "FROM Panier";
		Query query =s.createQuery(req);
		
		return query.list();
	}

	public Panier getPanierByClientDao(Client client) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int isExistDao() {
		Session s = sf.getCurrentSession();
		List<Panier> liste =this.getAllPanierDao();
		if(liste.isEmpty()==true){
			return 0;
		}else{
			Panier panier = this.getActivePanierDao();
			if(panier==null){
				return 0;
			}else{
			return 1;
			}
		}
		
	}
	@Override
	public Panier getActivePanierDao() {
		Session s = sf.getCurrentSession();
		String req = "FROM Panier p WHERE p.active=true";
		Query query = s.createQuery(req);
		return (Panier) query.uniqueResult();
	}
	
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------

}
