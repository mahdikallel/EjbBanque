package tn.iit.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.iit.model.ClientBanque;


@Singleton
public class ClientBanqueDao {

	
	@PersistenceContext
	private EntityManager em; /* private/protected */
	
	public void addClientBanque(ClientBanque clb) {
		em.persist(clb);
	};

	public void removeClientBanque(ClientBanque clb) {

		em.remove(em.find(ClientBanque.class, clb.getCin()));

	};

	public void modifyClientBanque(ClientBanque clb) {
		em.merge(clb);
	};

	public List<ClientBanque> findAllClientBanque() {
		Query q = em.createNamedQuery("ClientBanque.findAll", ClientBanque.class);
		return q.getResultList();

	}
	
	public void modifierClientNative(String newCin,ClientBanque cb) {
	
		
		Query q2 =em.createQuery("UPDATE ClientBanque c SET c.cin =:p1,c.nom=:p2,c.prenom=:p3,c.adresse=:p4 where c.cin=:p5");
		q2.setParameter("p1",newCin);
		q2.setParameter("p2",cb.getNom());
		q2.setParameter("p3",cb.getPrenom());
		q2.setParameter("p4",cb.getAdresse());
		q2.setParameter("p5",cb.getCin());
		q2.executeUpdate();
		
		System.out.println("Requette Native------------------"+q2);
		

	}
	
	public ClientBanque findAllClientByCin(ClientBanque clb) {
		return em.find(ClientBanque.class, clb.getCin());

	}
	
	
}
