/**
 * 
 * @author CLAIN Fabien
 * Date : 15/10/2016
 * 
 */
package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Panier implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//------------------------------1_Les propri�t�s (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propri�t�s (champs, attributs)
	 */
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id_panier;
		
		private int nbArticle;
		
		private double prixTotal;
		
		private boolean active;
		
		
		@OneToOne(cascade=CascadeType.PERSIST)
		@JoinColumn(name="client_id",referencedColumnName="id_client")
		private Client clientP;
		
		@JsonIgnore
		@OneToMany(mappedBy="panier",cascade=CascadeType.REMOVE)
		private List<LigneCommande> listeLC;
		
		@JsonIgnore
		@OneToOne(mappedBy="panier")
		private Commande cmd;
//-------------------------------------------------------------------------------------------------------------
//------------------------------2_Les constructeurs------------------------------------------------------------	
	/**
	 * 2_Les constructeurs
	 */
		/**
		 * 
		 */
		public Panier() {
			super();
		}
		/**
		 * @param prixTotal
		 */
		public Panier(double prixTotal, int nbArticle, boolean active) {
			super();
			this.prixTotal = prixTotal;
			this.nbArticle = nbArticle;
			this.active = active;
		}
		/**
		 * @param id_panier
		 * @param prixTotal
		 */
		public Panier(long id_panier, double prixTotal, int nbArticle, boolean active) {
			super();
			this.id_panier = id_panier;
			this.prixTotal = prixTotal;
			this.nbArticle = nbArticle;
			this.active = active;
		}
//-------------------------------------------------------------------------------------------------------------
//------------------------------3_Les Getters et Setters-------------------------------------------------------
	/**
	 * 3_Les Getters et Setters
	 */
		/**
		 * @return the id_panier
		 */
		public long getId_panier() {
			return id_panier;
		}
		/**
		 * @param id_panier the id_panier to set
		 */
		public void setId_panier(Long id_panier) {
			this.id_panier = id_panier;
		}
		/**
		 * @return the prixTotal
		 */
		public double getPrixTotal() {
			return prixTotal;
		}
		/**
		 * @param prixTotal the prixTotal to set
		 */
		public void setPrixTotal(double prixTotal) {
			this.prixTotal = prixTotal;
		}
		/**
		 * @return the client
		 */
		public Client getClientP() {
			return clientP;
		}
		/**
		 * @param client the client to set
		 */
		public void setClientP(Client client) {
			this.clientP = client;
		}
		/**
		 * @return the listeLC
		 */
		public List<LigneCommande> getListeLC() {
			return listeLC;
		}
		/**
		 * @param listeLC the listeLC to set
		 */
		public void setListeLC(List<LigneCommande> listeLC) {
			this.listeLC = listeLC;
		}
		/**
		 * @return the cmd
		 */
		public Commande getCmd() {
			return cmd;
		}
		/**
		 * @param cmd the cmd to set
		 */
		public void setCmd(Commande cmd) {
			this.cmd = cmd;
		}
		
		/**
		 * @return the nbArticle
		 */
		public int getNbArticle() {
			return nbArticle;
		}
		/**
		 * @param nbArticle the nbArticle to set
		 */
		public void setNbArticle(int nbArticle) {
			this.nbArticle = nbArticle;
		}
		
		/**
		 * @return the active
		 */
		public boolean isActive() {
			return active;
		}
		/**
		 * @param active the active to set
		 */
		public void setActive(boolean active) {
			this.active = active;
		}
	//-------------------------------------------------------------------------------------------------------------
//------------------------------4_M�thodes---------------------------------------------------------------------
	/**
	 * 4_M�thodes
	 */
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Panier [id_panier=" + id_panier + ", nbArticle=" + nbArticle + ", prixTotal=" + prixTotal
					+ ", active=" + active +  "]";
		}

//-------------------------------------------------------------------------------------------------------------
}
