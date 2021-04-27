package tn.esprit.spring.Service;

import java.util.List;
import tn.esprit.spring.Entity.DetailsCommande;

public interface DetailsCommandeService {

	 public DetailsCommande addDetailsCommande(DetailsCommande detailsCommande);
	 public DetailsCommande addOrUpdateDetailsCommande(DetailsCommande detailsCommande);
	 public void deleteDetailsCommandeById(Long detailsCommandeId);
	 public DetailsCommande getDetailsCommandeById(Long detailsCommandeId);
	 public List<DetailsCommande> getAllDetailsCommandes(); 
	 //public DetailsCommande authenticate(String login, String password);
}
