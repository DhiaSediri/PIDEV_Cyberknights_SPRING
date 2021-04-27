package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.Entity.Facture;
import tn.esprit.spring.Entity.TypeFacture;

public interface FactureService {

	public Facture addFacture(Facture facture);
	 public Facture addOrUpdateFacture(Facture facture);
	 public void deleteFactureById(Long factureId);
	 public Facture getFactureById(Long factureId);
	 public List<Facture> getAllFactures();
	 /*public List<Facture> getFacturesByTypeJPQL(TypeFacture type);
	 public List<Facture> getFacturesByClientJPQL(Long idClient);*/
	 //public Facture authenticate(String login, String password);
}
