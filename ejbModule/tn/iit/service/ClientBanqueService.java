package tn.iit.service;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import tn.iit.dao.ClientBanqueDao;
import tn.iit.dao.CompteBancaireDao;
import tn.iit.model.ClientBanque;
import tn.iit.model.CompteBancaire;

@Path("/UserService")
@Stateless
@Produces({ "application/json" })
public class ClientBanqueService {

	@EJB
	private ClientBanqueDao clientBanqueDao;

	
	public void ajouterClientBanque(ClientBanque clb) {
		clientBanqueDao.addClientBanque(clb);
	}

	public void suppClientBanque(ClientBanque clb) {
		clientBanqueDao.removeClientBanque(clb);
	}

	public void modifClientBanque(ClientBanque clb) {
		clientBanqueDao.modifyClientBanque(clb);
	}
	
	public void modifClientBanqueNative(ClientBanque clb,String newCin) {
		clientBanqueDao.modifierClientNative(newCin, clb);
	}

	@GET
	@Path("/users")
	@Produces({ "application/json" })
	public List<ClientBanque> selectAllClientBanque() {
		return clientBanqueDao.findAllClientBanque();
	}

	
	
	
	public ClientBanque findAllClientByCin(ClientBanque clb) {
		return clientBanqueDao.findAllClientByCin(clb);
	}
	

}
