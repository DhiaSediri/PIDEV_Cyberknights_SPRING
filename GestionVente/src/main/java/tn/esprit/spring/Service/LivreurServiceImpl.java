package tn.esprit.spring.Service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Livreur;
import tn.esprit.spring.Repository.LivreurRepository;

@Service
public class LivreurServiceImpl implements LivreurService {
	
	@Autowired
	LivreurRepository livreurRepository;
	
	private static final Logger l = LogManager.getLogger(LivreurServiceImpl.class);

	@Override
	public Livreur addLivreur(Livreur livreur) {
		l.info("In addLivreur : " + livreur);
		Livreur liv = livreurRepository.save(livreur);
		l.info("Out of addLivreur : " + livreur);
		return liv;
	}

	@Override
	public Livreur addOrUpdateLivreur(Livreur livreur) {
		l.info("In addOrUpdateLivreur : " + livreur);
		Livreur liv = livreurRepository.save(livreur);
		l.info("Out of addOrUpdateLivreur : " + livreur);
		return liv;
	}

	@Override
	public void deleteLivreurById(Long livreurId) {
		l.info("In deleteLivreurById : " + livreurId);
		livreurRepository.deleteById(livreurId);
		l.info("Out of deleteLivreurById : " + livreurId);
	}

	@Override
	public Livreur getLivreurById(Long livreurId) {
		l.info("In getLivreurById id : " + livreurId);
		Livreur liv = livreurRepository.findById(livreurId).get();
		l.info("Livreur returned : " + liv);
		return liv;
	}

	@Override
	public List<Livreur> getAllLivreurs() {
		l.info("In getAllLivreurs : ");
		List<Livreur> livreurs = (List<Livreur>) livreurRepository.findAll();
		for(Livreur liv : livreurs){
			l.debug("Livreur +++ : " + liv);
		}
		l.info("Out of getAllLivreurs : ");
		return livreurs; 
	}

}
