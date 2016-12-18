package tn.iit.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.iit.dao.CompteBancaireDao;
import tn.iit.model.ClientBanque;
import tn.iit.model.CompteBancaire;

@Stateless
public class CompteBancaireService {

	@EJB
	private CompteBancaireDao compteDao;

	public void ajouterCompte(CompteBancaire cb) {
		compteDao.addCompteBancaire(cb);
	}

	public void suppCompte(CompteBancaire cb) {
		compteDao.removeCompteBancaire(cb);
	}

	public void modifCompte(CompteBancaire cb) {
		compteDao.modifyCompteBancaire(cb);
	}

	public List<CompteBancaire> selectAllCompteBancaire() {
		return compteDao.findAllCompteBancaire();
	}
	
	public List<CompteBancaire> selectCompteBancaireByIdClient(String clb) {
		return compteDao.findAllCompteBancaireByIdClient(clb);
	}

	
	public CompteBancaire getCompteByRib(long rib) {
		return compteDao.getCompteByRib(rib);
	}
}
