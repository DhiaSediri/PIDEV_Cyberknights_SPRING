package tn.esprit.spring;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.Entity.Client;
import tn.esprit.spring.Entity.Commande;
import tn.esprit.spring.Entity.DetailsCommande;
import tn.esprit.spring.Entity.Facture;
import tn.esprit.spring.Entity.Livreur;
import tn.esprit.spring.Entity.Paiement;
import tn.esprit.spring.Entity.Produit;
import tn.esprit.spring.Entity.TypeCarte;
import tn.esprit.spring.Entity.TypeFacture;
import tn.esprit.spring.Entity.TypePaiement;
import tn.esprit.spring.Repository.ClientRepository;
import tn.esprit.spring.Repository.CommandeRepository;
import tn.esprit.spring.Repository.DetailsCommandeRepository;
import tn.esprit.spring.Repository.FactureRepository;
import tn.esprit.spring.Repository.LivreurRepository;
import tn.esprit.spring.Repository.PaiementRepository;
import tn.esprit.spring.Repository.ProduitRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class GestionVenteApplicationTests {

	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	LivreurRepository livreurRepository;
	
	@Autowired
    ProduitRepository produitRepository;
	
	@Autowired
	PaiementRepository paiementRepository;
	
	@Autowired
	FactureRepository factureRepository;
	
	@Autowired
	DetailsCommandeRepository detailsCommandeRepository;
	
	@Autowired
	CommandeRepository commandeRepository;
	
	
	@Test
	public void contextLoads() {
	
		Client client1 = new Client("abd rahmen", "mahjoub", "mohameddhia.sediri@esprit.tn", "22333444", "bizerte");
		clientRepository.save(client1);
		Client client2 = new Client("mohamed", "bouzid", "mohameddhia.sediri@esprit.tn", "22333477", "tunis");
		clientRepository.save(client2);
		Client client3 = new Client("amine", "snaini", "mohameddhia.sediri@esprit.tn", "22333488", "jendouba");
		clientRepository.save(client3);
		
		Livreur livreur1 = new Livreur("mohamed", "ali", "mohamed.ali@gmail.com", "20222336", "tunis");
		livreurRepository.save(livreur1);
		Livreur livreur2 = new Livreur("ahmed", "mounir", "ahmed.mounir@gmail.com", "20222337", "sfax");
		livreurRepository.save(livreur2);
		Livreur livreur3 = new Livreur("hedi", "mersni", "hedi.mersni@gmail.com", "20222339", "sousse");
		livreurRepository.save(livreur3);
		
		Produit produit1 = new Produit("chaise", "123aze", 100, 50, "plastique");
		produitRepository.save(produit1);
		Produit produit2 = new Produit("table", "123wxc", 200, 80, "bois");
		produitRepository.save(produit2);
		Produit produit3 = new Produit("armoire", "123qsd", 150, 200, "bois");
		produitRepository.save(produit3);
		
		Paiement paiement = new Paiement(true, TypePaiement.en_ligne, TypeCarte.e_dinar, new Date()/*, "123L"*/, 456L, "abd rahmen mahjoub", new Date());
		paiementRepository.save(paiement);
		Paiement p = new Paiement(true, TypePaiement.en_ligne, TypeCarte.e_dinar, new Date()/*, "789L"*/, 321L, "amine snaini", new Date());
		paiementRepository.save(p);
		
		Facture facture = new Facture(TypeFacture.automatique, new Date());
		factureRepository.save(facture);
		Facture f = new Facture(TypeFacture.automatique, new Date());
		factureRepository.save(f);
		
		DetailsCommande detailsCommande = new DetailsCommande(produit1, 3);
		//detailsCommandeRepository.save(detailsCommande);
		DetailsCommande dc = new DetailsCommande(produit2, 5);
		//detailsCommandeRepository.save(dc);
		
		Set<DetailsCommande> detailsCommandes = new HashSet<>();
		detailsCommandes.add(detailsCommande);
		detailsCommandes.add(dc);
		
		Commande commande = new Commande(new Date(), new Date(), detailsCommandes, paiement, facture, client1, livreur1);
		commandeRepository.save(commande);
		
		Optional<Commande> cmd = commandeRepository.findById((long) 1);		
		System.out.println(cmd.get().getClient().getNom());
	}

}
