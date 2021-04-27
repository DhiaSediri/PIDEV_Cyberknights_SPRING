package tn.esprit.spring.Service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Produit;
import tn.esprit.spring.Repository.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService {
	
	@Autowired
	ProduitRepository produitRepository;
	
	private static final Logger l = LogManager.getLogger(ProduitServiceImpl.class);


	@Override
	public Produit addProduit(Produit produit) {
		l.info("In addProduit : " + produit);
		Produit p = produitRepository.save(produit);
		l.info("Out of addProduit. : " + produit);
		return p;
	}

	@Override
	public Produit addOrUpdateProduit(Produit produit) {
		l.info("In addOrUpdateCommande : " + produit);
		Produit p = produitRepository.save(produit);
		l.info("Out of addOrUpdateCommande : " + produit);
		return p;
	}

	@Override
	public void deleteProduitById(Long produitId) {
		l.info("In deleteCommandeById : " + produitId);
		produitRepository.deleteById(produitId);
		l.info("Out of deleteCommandeById : " + produitId);
	}

	@Override
	public Produit getProduitById(Long produitId) {
		l.info("In getProduitById : " + produitId);
		Produit p = produitRepository.findById(produitId).get();
		l.info("Produit returned : " + p);
		return p;
	}

	@Override
	public List<Produit> getAllProduits() {
		l.info("In getAllProduits : ");
		List<Produit> produits = (List<Produit>) produitRepository.findAll();
		for(Produit p : produits){
			l.debug("Produit +++ : " + p);
		}
		l.info("Out of getAllProduits : ");
		return produits; 
	}

}
