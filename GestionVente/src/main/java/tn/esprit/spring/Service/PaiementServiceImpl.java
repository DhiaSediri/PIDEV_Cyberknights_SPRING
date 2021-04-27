package tn.esprit.spring.Service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Paiement;
import tn.esprit.spring.Entity.TypePaiement;
import tn.esprit.spring.Repository.PaiementRepository;

@Service
public class PaiementServiceImpl implements PaiementService {
	
	@Autowired
	PaiementRepository paiementRepository;
	
	private static final Logger l = LogManager.getLogger(CommandeServiceImpl.class);

	@Override
	public Paiement addPaiement(Paiement paiement) {
		l.info("In addPaiement : " + paiement);
		Paiement p = paiementRepository.save(paiement);	
		l.info("Out of addPaiement : " + paiement);
		return p;
	}

	@Override
	public Paiement addOrUpdatePaiement(Paiement paiement) {
		l.info("In addOrUpdatePaiement : " + paiement);
		Paiement p = paiementRepository.save(paiement);
		l.info("Out of addOrUpdatePaiement : " + paiement);
		return p;
	}
	
	@Override
	public void deletePaiementById(Long paiementId) {
		l.info("In deletePaiementById : " + paiementId);
		paiementRepository.deleteById(paiementId);
		l.info("Out of deletePaiementById : " + paiementId);
	}
	
	@Override
	public Paiement getPaiementById(Long paiementId) {
		l.info("In getPaiementById : " + paiementId);
		Paiement p = paiementRepository.findById(paiementId).get();
		l.info("Paiement returned : " + p);
		return p; 
	}

	@Override
	public List<Paiement> getAllPaiements() {
		l.info("In getAllFactures : ");
		List<Paiement> paiements = (List<Paiement>) paiementRepository.findAll();
		for(Paiement p : paiements){
			l.debug("paiement +++ : " + p);
		}
		l.info("Out of getAllPaiements : ");
		return paiements;
	}
    /*
	@Override
	public List<Paiement> getPaiementsByTypeJPQL(TypePaiement type) {
		
		return paiementRepository.getPaiementsByTypeJPQL(type);
	}
    /*
	@Override
	public List<Paiement> getPaiementsByClientJPQL(Long idClient) {
		
		return paiementRepository.getPaiementsByClientJPQL(idClient);
	}

	@Override
	public List<Paiement> getPaiementsByProduitJPQL(Long idProduit) {
		
		return paiementRepository.getPaiementsByProduitJPQL(idProduit);
	}*/
	
	//@Override
	//public Paiement authenticate(String login, String password) {
		// TODO Auto-generated method stub
		//return null;
	//}

}
