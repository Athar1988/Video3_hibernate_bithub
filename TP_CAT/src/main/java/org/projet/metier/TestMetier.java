package org.projet.metier;

public class TestMetier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CatalogueMetierImp metier= new CatalogueMetierImp();
		metier.addProduit(new Produit("HP 125",123.33,23));
		metier.addProduit(new Produit("HP 234",547.33,2));
		metier.addProduit(new Produit("Compag",236.0,15));
	}

}
