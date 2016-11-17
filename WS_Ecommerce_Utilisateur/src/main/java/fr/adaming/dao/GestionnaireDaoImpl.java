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

import fr.adaming.model.Gestionnaire;
@Repository
public class GestionnaireDaoImpl implements IGestionnaireDao {
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
	public int isExist(String login, String mdp) {
		Session s = sf.getCurrentSession();
		String req = "FROM Gestionnaire g WHERE g.login=:loginG AND g.mdp=:mdpG";
		Query query = s.createQuery(req);
		
		query.setParameter("loginG", login);
		query.setParameter("mdpG", mdp);
		
		if(query.uniqueResult()!=null){
			return 1;
		}else{
			return 0;
		}
	}

//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------

}
