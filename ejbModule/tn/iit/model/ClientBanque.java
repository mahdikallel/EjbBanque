package tn.iit.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@Entity
@NamedQueries({
@NamedQuery(name = "ClientBanque.findAll", query = "SELECT c FROM ClientBanque c"),
@NamedQuery(name="ClientBanque.update", query="UPDATE  ClientBanque clb SET clb.cin  = :p1 ,clb.nom = :p2, clb.prenom = :p3,clb.adresse = :p4 WHERE clb.cin = :p5	")
//UPDATE `clientbanque` SET `cin`="2600000",`adresse`="ff",`nom`="gg",`prenom`="gg" WHERE `cin`="1800000"
})
@XmlRootElement(name = "user")
public class ClientBanque implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(length = 8)
	private String cin;
	private String nom;
	private String prenom;
	private String adresse;

	@OneToMany(mappedBy="client" , fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<CompteBancaire> compte;

	public List<CompteBancaire> getCompte() {
		return compte;
	}

	public void setCompte(List<CompteBancaire> compte) {
		this.compte = compte;
	}

	public ClientBanque() {

	}

	public ClientBanque(String nom, String prenom, String adresse, List<CompteBancaire> compte) {

		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "ClientBanque [cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", compte="
				 + "]";
	}

	public String getCin() {
		return cin;
	}

	@XmlElement
	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	@XmlElement
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	@XmlElement
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cin == null) ? 0 : cin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientBanque other = (ClientBanque) obj;
		if (cin == null) {
			if (other.cin != null)
				return false;
		} else if (!cin.equals(other.cin))
			return false;
		return true;
	}

	

}
