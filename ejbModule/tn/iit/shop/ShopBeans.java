package tn.iit.shop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;

import tn.iit.banque.CalculatriceRemote;
import tn.iit.dto.Product;

@Stateful
public class ShopBeans implements ShopLocal, ShopRemote, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Product> productsList = new ArrayList<>();
	private double total;

	@EJB
	private CalculatriceRemote bank;

	@Override
	public void achatProduit(String produit, int qte, double prix) {
		// TODO Auto-generated method stub
		Product product = new Product();
		product.setPrix(prix);
		product.setProductName(produit);
		product.setQte(qte);
		if (!productsList.contains(product)) {
			productsList.add(product);
		} else {
			int indice = productsList.indexOf(product);
			productsList.get(indice).setQte(productsList.get(indice).getQte() + qte);
		}

	}

	@Override
	public StringBuilder listProduitAchete() {
		// TODO Auto-generated method stub
		StringBuilder ch = new StringBuilder();

		for (int i = 0; i < productsList.size(); i++) {
			ch.append(productsList.get(i).getProductName() + " Prix = " + productsList.get(i).getPrix() + " Quantité  "
					+ productsList.get(i).getQte());
			ch.append("\n");
		}

		return ch;
	}

	@Override
	public boolean suppressionProduit(String produit, int qte) {
		// TODO Auto-generated method stub
		Product p = new Product();
		p.setProductName(produit);

		int index = productsList.indexOf(p);

		if (productsList.get(index).getQte() > qte) {
			// System.out.println(productsList.get(index) + "index condition 1 "
			// + index);
			productsList.get(index).setQte(productsList.get(index).getQte() - qte);
		}

		else {
			productsList.remove(index);

		}

		return false;
	}

	@Override
	public double getTotal() {
		// TODO Auto-generated method stub
		total = 0;
		for (int i = 0; i < productsList.size(); i++) {
			total += bank.som(total, bank.mult(productsList.get(i).getPrix(), productsList.get(i).getPrix()));
		}

		return total;
	}

	@PostConstruct
	public void nouveauClient() {
		System.out.println("********Nouveau client connecté********");
	}
	@Override
	public List<Product> getList(){
		return productsList;
	}

}
