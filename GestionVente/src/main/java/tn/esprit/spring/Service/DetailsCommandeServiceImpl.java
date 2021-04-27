package tn.esprit.spring.Service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.DetailsCommande;
import tn.esprit.spring.Repository.DetailsCommandeRepository;

@Service
public class DetailsCommandeServiceImpl implements DetailsCommandeService {
	
	@Autowired
	DetailsCommandeRepository detailsCommandeRepository;
	
	private static final Logger l = LogManager.getLogger(DetailsCommandeServiceImpl.class);

	@Override
	public DetailsCommande addDetailsCommande(DetailsCommande detailsCommande) {
		l.info("In addDetailsCommande : " + detailsCommande);
		DetailsCommande dc = detailsCommandeRepository.save(detailsCommande);
		l.info("Out of addDetailsCommande. : " + detailsCommande);
		return dc;
	}

	@Override
	public DetailsCommande addOrUpdateDetailsCommande(DetailsCommande detailsCommande) {
		l.info("In addOrUpdateDetailsCommande : " + detailsCommande);
		DetailsCommande dc = detailsCommandeRepository.save(detailsCommande);
		l.info("Out of addOrUpdateDetailsCommande : " + detailsCommande);
		return dc;
	}

	@Override
	public void deleteDetailsCommandeById(Long detailsCommandeId) {
		l.info("In deleteDetailsCommandeById : " + detailsCommandeId);
		detailsCommandeRepository.deleteById(detailsCommandeId);
		l.info("Out of deleteDetailsCommandeById : " + detailsCommandeId);
	}

	@Override
	public DetailsCommande getDetailsCommandeById(Long detailsCommandeId) {
		l.info("In getDetailsCommandeById id : " + detailsCommandeId);
		DetailsCommande dc = detailsCommandeRepository.findById(detailsCommandeId).get();
		l.info("DetailsCommande returned : " + dc);
		return dc;
	}

	@Override
	public List<DetailsCommande> getAllDetailsCommandes() {
		l.info("In getAllDetailsCommandes : ");
		List<DetailsCommande> detailsCommandes = (List<DetailsCommande>) detailsCommandeRepository.findAll();
		for(DetailsCommande dc : detailsCommandes){
			l.debug("DetailsCommande +++ : " + dc);
		}
		l.info("Out of getAllDetailsCommandes : ");
		return detailsCommandes; 
	}
	
	//@Override
		//public DetailsCommande authenticate(String login, String password) {
			// TODO Auto-generated method stub
			//return null;
		//}

}
