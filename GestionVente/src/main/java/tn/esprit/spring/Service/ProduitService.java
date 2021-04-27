package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.Entity.Produit;

public interface ProduitService {

	public Produit addProduit(Produit produit);
	public Produit addOrUpdateProduit(Produit produit);
	public void deleteProduitById(Long produitId);
	public Produit getProduitById(Long produitId);
	public List<Produit> getAllProduits(); 
}
