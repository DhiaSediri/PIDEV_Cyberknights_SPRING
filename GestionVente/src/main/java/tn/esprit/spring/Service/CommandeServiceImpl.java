package tn.esprit.spring.Service;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Commande;
import tn.esprit.spring.Entity.Facture;
import tn.esprit.spring.Entity.TypeFacture;
import tn.esprit.spring.Entity.TypePaiement;
import tn.esprit.spring.Repository.CommandeRepository;
import tn.esprit.spring.Repository.FactureRepository;
import tn.esprit.spring.Utility.Mail;
import tn.esprit.spring.Utility.Pdf;
import tn.esprit.spring.Utility.Pdf_facture;

@Service
public class CommandeServiceImpl implements CommandeService {
	
	@Autowired
	CommandeRepository commandeRepository;
	
	@Autowired
	FactureServiceImpl factureService;
	
	private static final Logger l = LogManager.getLogger(CommandeServiceImpl.class);

	@Override
	public Commande addCommande(Commande commande) {
		l.info("In addCommande : " + commande);
		Commande c = commandeRepository.save(commande);
		l.info("Out of addCommande. : " + commande);
		/*if(c.getPaiement().getTypePaiement().equals(TypePaiement.en_ligne)){
			Facture factureEnLigne = genererFacture(commande);
		}*/
		return c;
	}

	@Override
	public Commande addOrUpdateCommande(Commande commande) {
		l.info("In addOrUpdateCommande : " + commande);
		Commande c = commandeRepository.save(commande);
		l.info("Out of addOrUpdateCommande : " + commande);
		return c;
	}
	
	@Override
	public void deleteCommandeById(Long commandeId) {
		l.info("In deleteCommandeById : " + commandeId);
		commandeRepository.deleteById(commandeId);
		l.info("Out of deleteCommandeById : " + commandeId);
	}
	
	@Override
	public Commande getCommandeById(Long commandeId) {
		l.info("In getCommandeById id : " + commandeId);
		Commande c = commandeRepository.findById(commandeId).get();
		l.info("Commande returned : " + c);
		return c;
	}
	
	@Override
	public List<Commande> getAllCommandes() {
		l.info("In getAllCommandes : ");
		List<Commande> commandes = (List<Commande>) commandeRepository.findAll();
		for(Commande c : commandes){
			l.debug("Commande +++ : " + c);
		}
		l.info("Out of getAllCommandes : ");
		return commandes; 
	}

	@Override
	public Facture genererFacture(Commande commande) {
		String namePdf ="C:\\generer_pdf\\" + commande.getClient().getNom() + " " + commande.getClient().getPrenom() + ".pdf";  
		Pdf_facture.generatePdf(namePdf, commande);
		try {
			Mail.sendMail(commande.getClient().getEmail(), namePdf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Facture facture = null;
		if(commande.getPaiement().getTypePaiement().equals(TypePaiement.en_ligne)){
			facture = new Facture(TypeFacture.automatique, new Date(), commande);
		}
		if(commande.getPaiement().getTypePaiement().equals(TypePaiement.aprés_livraison)){
			facture = new Facture(TypeFacture.manuelle, new Date(), commande);
		}
		
		return facture;
	}

	//@Override
	//public Commande authenticate(String login, String password) {
		// TODO Auto-generated method stub
		//return null;
	//}
	
}
