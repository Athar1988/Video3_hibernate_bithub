package org.projet.metier;

import java.util.List;

public interface ICatalogueMetier {
	public void addProduit(Produit p);
	public List<Produit> ListProduit();
	public Produit getProduit(Long idProd);
	public List<Produit> getProduitParMC(String mc);
	public void deleteProduit(Long idProd);
	public void updateProduit(Produit p);

}
