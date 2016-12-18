package tn.iit.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.iit.model.ClientBanque;
import tn.iit.model.CompteBancaire;

@Singleton
public class CompteBancaireDao {

	@PersistenceContext
	private EntityManager em; /* private/protected */

	public void addCompteBancaire(CompteBancaire cb) {
		em.persist(cb);
	};

	public void removeCompteBancaire(CompteBancaire cb) {

		em.remove(em.find(CompteBancaire.class, cb.getRib()));

	};

	public void modifyCompteBancaire(CompteBancaire cb) {
		em.merge(cb);
	};

	public List<CompteBancaire> findAllCompteBancaire() {
		Query q = em.createNamedQuery("CompteBancaire.findAll", CompteBancaire.class);
		return q.getResultList();

	}
	
	
	public List<CompteBancaire> findAllCompteBancaireByIdClient(String cin) {
		Query q = em.createNamedQuery("CompteBancaire.findAllCompteBancaireByIdClient", CompteBancaire.class);
		q.setParameter("numcin", cin);
		System.out.println("Requette ------------------"+q);
		return q.getResultList();
		
	}
	
	public CompteBancaire getCompteByRib(long rib) {

		return em.find(CompteBancaire.class, rib);

	};
	

}
