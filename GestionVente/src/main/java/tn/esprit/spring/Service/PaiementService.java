package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.Entity.Paiement;
import tn.esprit.spring.Entity.TypePaiement;

public interface PaiementService {

	 public Paiement addPaiement(Paiement paiement);
	 public Paiement addOrUpdatePaiement(Paiement paiement);
	 public void deletePaiementById(Long paiementId);
	 public Paiement getPaiementById(Long paiementId);
	 public List<Paiement> getAllPaiements();
	 //public List<Paiement> getPaiementsByTypeJPQL(TypePaiement type);
	 /*public List<Paiement> getPaiementsByClientJPQL(Long idClient);
	 public List<Paiement> getPaiementsByProduitJPQL(Long idProduit);*/
	 //public Paiement authenticate(String login, String password);	 
}
