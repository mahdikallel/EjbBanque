package tn.iit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({

@NamedQuery(name = "CompteBancaire.findAll", query = "SELECT c FROM CompteBancaire c"),
@NamedQuery(name = "CompteBancaire.findAllCompteBancaireByIdClient", query = "SELECT c FROM CompteBancaire c "
		+ " WHERE c.client.getCin() = :numcin ")
})
public class CompteBancaire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long rib;

	private float solde;

	
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private ClientBanque client;

	public ClientBanque getClient() {
		return client;
	}

	public void setClient(ClientBanque client) {
		this.client = client;
	}

	public CompteBancaire() {
	};

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (rib ^ (rib >>> 32));
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
		CompteBancaire other = (CompteBancaire) obj;
		if (rib != other.rib)
			return false;
		return true;
	}

	

	public long getRib() {
		return rib;
	}

	public void setRib(long rib) {
		this.rib = rib;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "CompteBancaire [rib=" + rib + ", solde=" + solde + ", client=" + client + "]";
	}

	

}
