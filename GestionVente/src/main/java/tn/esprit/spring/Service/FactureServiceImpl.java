package tn.esprit.spring.Service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Facture;
import tn.esprit.spring.Entity.TypeFacture;
import tn.esprit.spring.Repository.FactureRepository;

@Service
public class FactureServiceImpl implements FactureService {
	
	@Autowired
	FactureRepository factureRepository;
	
	private static final Logger l = LogManager.getLogger(FactureServiceImpl.class);

	@Override
	public Facture addFacture(Facture facture) {
		l.info("In addFacture : " + facture);
		Facture f = factureRepository.save(facture);	
		l.info("Out of addFacture : " + facture);
		return f;
	}

	@Override
	public Facture addOrUpdateFacture(Facture facture) {
		l.info("In addOrUpdateFacture : " + facture);
		Facture f = factureRepository.save(facture);
		l.info("Out of addOrUpdateFacture : " + facture);
		return f;
	}

	@Override
	public void deleteFactureById(Long factureId) {
		l.info("In deleteFactureById : " + factureId);
		factureRepository.deleteById(factureId);
		l.info("Out of deleteFactureById : " + factureId);		
	}

	@Override
	public Facture getFactureById(Long factureId) {
		l.info("In getFactureById : " + factureId);
		Facture f = factureRepository.findById(factureId).get();
		l.info("Facture returned : " + f);
		return f;
	}

	@Override
	public List<Facture> getAllFactures() {
		l.info("In getAllFactures : ");
		List<Facture> factures = (List<Facture>) factureRepository.findAll();
		for(Facture f : factures){
			l.debug("facture +++ : " + f);
		}
		l.info("Out of getAllFactures : ");
		return factures;
	}
    /*
	@Override
	public List<Facture> getFacturesByTypeJPQL(TypeFacture type) {		
		return factureRepository.getFacturesByTypeJPQL(type);
	}
    
	@Override
	public List<Facture> getFacturesByClientJPQL(Long idClient) {		
		return factureRepository.getFacturesByClientJPQL(idClient);
	}*/

	//@Override
	//public Facture authenticate(String login, String password) {
		// TODO Auto-generated method stub
		//return null;
	//}
	
}
