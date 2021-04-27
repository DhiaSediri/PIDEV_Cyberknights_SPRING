package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.Entity.Livreur;

public interface LivreurService {

	public Livreur addLivreur(Livreur livreur);
	public Livreur addOrUpdateLivreur(Livreur livreur);
	public void deleteLivreurById(Long livreurId);
	public Livreur getLivreurById(Long livreurId);
	public List<Livreur> getAllLivreurs(); 
}
