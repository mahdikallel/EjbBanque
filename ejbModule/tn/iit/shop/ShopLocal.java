package tn.iit.shop;

import java.util.List;

import javax.ejb.Local;

import tn.iit.dto.Product;

@Local
public interface ShopLocal {
	
	 void achatProduit(String produit, int qte, double prix);
	 StringBuilder listProduitAchete();
	 boolean suppressionProduit(String produit, int qte);
	 double getTotal();
	 List<Product> getList();

}
