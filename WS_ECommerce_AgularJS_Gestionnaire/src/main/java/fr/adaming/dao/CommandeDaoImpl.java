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

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.Produit;

@Repository
public class CommandeDaoImpl implements ICommandeDao {
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
	public void addCommandeDao(Commande cmd) {
		Session s = sf.getCurrentSession();
		s.save(cmd);
	}


	public void deleteComandeDao(long id_cmd) {
		Session s = sf.getCurrentSession();
		Commande cmd = (Commande) s.get(Commande.class, id_cmd);
		s.delete(cmd);
	}

	public List<Commande> getCommandesByClientDao(Client client) {
		Session s = sf.getCurrentSession();
		String req ="FROM Commande";
		Query query = s.createQuery(req);
		
		return query.list();
	}
	
	public List<Commande> getCommandesByIdClientDao(long id_client) {
		Session s = sf.getCurrentSession();
		
		String reqSql="SELECT * FROM commande WHERE client_id=?";
		SQLQuery querySql=s.createSQLQuery(reqSql);
		querySql.addEntity(Commande.class);
		
		querySql.setParameter(0, id_client);
		
		return querySql.list();
	}
	
	public Commande getCommandeByIdDao(long id_commande) {
		Session s = sf.getCurrentSession();
		String req ="FROM Commande p WHERE p.id_commande=:commande_id";
		Query query = s.createQuery(req);
		
		query.setParameter("commande_id", id_commande);
		
		return (Commande) query.uniqueResult();
	}

//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------

}
