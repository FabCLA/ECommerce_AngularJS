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
import fr.adaming.model.Produit;
@Repository
public class ClientDaoImpl implements IClientDao {
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
	public void addClientDao(Client client) {
		Session s = sf.getCurrentSession();
		s.save(client);
	}

	public void deleteClientDao(long id_client) {
		Session s = sf.getCurrentSession();
		Client c = (Client) s.get(Client.class, id_client);
		s.delete(c);
	}

	public void updateClientDao(Client client) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(client);

	}

	public int isExistDao(String mail, String password) {
		Session s = sf.getCurrentSession();
		String req = "FROM Client c WHERE c.mail=:mailC AND c.password=:passwordC";
		Query query = s.createQuery(req);
		
		query.setParameter("mailC", mail);
		query.setParameter("passwordC", password);
		
		if(query.uniqueResult()!=null){
			return 1;
		}else{
			return 0;
		}
	}

	public List<Client> getAllClientDao() {
		Session s = sf.getCurrentSession();
		String req = "FROM Client";
		Query query =s.createQuery(req);
		
		return query.list();
	}
	
	public Client getClientByIdentifiantDao(String mail, String password) {
		Session s = sf.getCurrentSession();
		String req = "FROM Client c WHERE c.mail=:mailC AND c.password=:passwordC";
		Query query = s.createQuery(req);
		
		query.setParameter("mailC", mail);
		query.setParameter("passwordC", password);
		
		return (Client) query.uniqueResult();
	}
	
	public Client getClientByIdDao(long id_client) {
		Session s = sf.getCurrentSession();
		String req ="FROM Client p WHERE p.id_client=:client_id";
		Query query = s.createQuery(req);
		
		query.setParameter("client_id", id_client);
		
		return (Client) query.uniqueResult();
	}
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------

}
