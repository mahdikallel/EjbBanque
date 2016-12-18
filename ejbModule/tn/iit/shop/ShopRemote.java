package tn.iit.shop;

import java.util.List;

import javax.ejb.Remote;

import tn.iit.dto.Product;

@Remote
public interface ShopRemote {
	
	 void achatProduit(String produit, int qte, double prix);
	 StringBuilder listProduitAchete();
	 boolean suppressionProduit(String produit, int qte);
	 double getTotal();
	 List<Product> getList();

}
