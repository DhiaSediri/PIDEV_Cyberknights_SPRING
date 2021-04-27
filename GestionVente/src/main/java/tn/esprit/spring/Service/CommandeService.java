package tn.esprit.spring.Service;

import java.util.List;
import tn.esprit.spring.Entity.Commande;
import tn.esprit.spring.Entity.Facture;


public interface CommandeService {

	 public Commande addCommande(Commande commande);
	 public Commande addOrUpdateCommande(Commande commande);
	 public void deleteCommandeById(Long commandeId);
	 public Commande getCommandeById(Long commandeId);
	 public List<Commande> getAllCommandes(); 
	 //public Commande authenticate(String login, String password);
	 public Facture genererFacture(Commande commande);
}
