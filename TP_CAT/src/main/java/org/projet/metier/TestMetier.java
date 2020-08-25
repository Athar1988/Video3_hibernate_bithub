package org.projet.metier;

import java.util.List;

import javax.servlet.ServletException;

import coucheweb.ControleurCatalogueServlet;

public class TestMetier {

	public static void main(String[] args) throws ServletException {
		// TODO Auto-generated method stub
		CatalogueMetierImp metier = new CatalogueMetierImp();
		// ajouter des champs a notre table
		metier.addProduit(new Produit("HP 125", 123.33, 23));
 	metier.addProduit(new Produit("HP 234", 547.33, 2));
		metier.addProduit(new Produit("aaaaa", 236.0, 15));
		// fait un recherche par mot de passe
		List<Produit> prods = metier.getProduitParMC("h");
		for (Produit p : prods) {
			System.out.println(p.getDesignation());
		}
		// fait une modification
		//Produit P1 = metier.getProduit(1L);
		// System.out.println(P.getDesignation());
		// System.out.println(P.getPrix());
		//P1.setDesignation("LONOVO");
		//metier.updateProduit(P1);
		//metier.ListProduit();
		// fait une suppression
		metier.deleteProduit(1L);


	}

}
