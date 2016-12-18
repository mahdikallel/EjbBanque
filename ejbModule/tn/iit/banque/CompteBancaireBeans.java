package tn.iit.banque;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.iit.model.CompteBancaire;

@Stateless

public class CompteBancaireBeans implements CompteBancaireLocal, CompteBancaireRemote {

	@PersistenceContext
	private EntityManager em; /* private/protected */

	@Override
	public void init() {
		// TODO Auto-generated method stub
		//CompteBancaire l1 = new CompteBancaire(100, "LePereGoriot");
		//CompteBancaire l2 = new CompteBancaire(255, "LesChouans");
		//CompteBancaire l3 = new CompteBancaire(160, "LesMiserables");

	//	em.persist(l1);// Enregistrer l’instance l1de l’entité d’une manière
						// permanente
	//	em.persist(l2);
	//	em.persist(l3);
	//	em.remove(l2); // Supprimer l’instance l2 de l’entité

	}

}
