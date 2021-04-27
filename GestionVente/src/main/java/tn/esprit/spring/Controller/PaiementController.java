package tn.esprit.spring.Controller;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dto.FactureDtoInput;
import dto.PaiementDtoInput;
import tn.esprit.spring.Entity.DetailsCommande;
import tn.esprit.spring.Entity.Facture;
import tn.esprit.spring.Entity.Paiement;
import tn.esprit.spring.Entity.TypeFacture;
import tn.esprit.spring.Entity.TypePaiement;
import tn.esprit.spring.Repository.PaiementRepository;
import tn.esprit.spring.Service.PaiementServiceImpl;

@RestController
public class PaiementController {

	@Autowired
	PaiementServiceImpl paiementService;
	
	@Autowired
	PaiementRepository paiementRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	// http://localhost:8081/SpringMVC/servlet/add-Paiement
	@PostMapping(value = "/add-Paiement")
	@ResponseBody
	public ResponseEntity<Paiement> addPaiement(@RequestBody PaiementDtoInput paiementDtoInput) {
		Paiement paiement = new Paiement();
		
		paiement.setTypePaiement(paiementDtoInput.getTypePaiement());
		paiement.setTypeCarte(paiementDtoInput.getTypeCarte());
		paiement.setDateExpirationCarte(paiementDtoInput.getDateExpirationCarte());
		paiement.setNumeroCarte(paiementDtoInput.getNumeroCarte());
		paiement.setCodeSecret(paiementDtoInput.getCodeSecret());
		paiement.setNomProprietaire(paiementDtoInput.getNomProprietaire());
		paiement.setDatePaiement(new Date());
		//paiement.setCommande(paiementDtoInput.getIdCommande());
		Paiement p = paiementService.addPaiement(paiement);
		return ResponseEntity.ok(p);
	}

	// http://localhost:8081/SpringMVC/servlet/addOrUpdate-Paiement
	@PutMapping(value = "/addOrUpdate-Paiement")
	@ResponseBody
	public ResponseEntity<Paiement> addOrUpdatePaiement(@RequestBody PaiementDtoInput paiementDtoInput) {	
		Paiement paiement = convertPaiementDtoInputToEntity(paiementDtoInput);	
		Paiement p = paiementService.addOrUpdatePaiement(paiement);
		return ResponseEntity.ok(p);
	}

	// http://localhost:8081/SpringMVC/servlet/delete-Paiement/{Paiement-id}
	@DeleteMapping(value = "/delete-Paiement/{Paiement-id}")
	@ResponseBody
	public void supprimerPaiement(@RequestBody Long paiementId) {
		paiementService.deletePaiementById(paiementId);
	}

	// http://localhost:8081/SpringMVC/servlet/paiement/{Paiement-id}
	@GetMapping(value = "/paiement/{Paiement-id}")
	@ResponseBody
	public Paiement getPaiementById(@PathVariable("Paiement-id") Long paiementId) {
		Paiement p = paiementService.getPaiementById(paiementId);
		return p;
	}

	// http://localhost:8081/SpringMVC/servlet/getAll-Paiements
	@GetMapping(value = "/getAll-Paiements")
	@ResponseBody
	public List<Paiement> getAllPaiements() {
		List<Paiement> paiements = paiementService.getAllPaiements();
		return paiements;
	}
	
	private Paiement convertPaiementDtoInputToEntity(PaiementDtoInput paiementDtoInput) throws ParseException {
		Paiement paiement = modelMapper.map(paiementDtoInput, Paiement.class);
		if (paiementDtoInput.getId() != null) {
			Paiement oldPaiement = paiementService.getPaiementById(paiementDtoInput.getId());
			modelMapper.map(paiementDtoInput, oldPaiement);
			return oldPaiement;
		}
		return paiement;
	}
	
    /*
	// http://localhost:8081/SpringMVC/servlet/getPaiementsByType/{Paiement-type}
	@GetMapping(value = "/getPaiementsByType/{Paiement-type}")
	@ResponseBody
	public List<Paiement> getPaiementsByType(@PathVariable("Paiement-type") String type) {
		List<Paiement> paiements = paiementRepository.getPaiementsByTypePaiement("en_ligne");		
		return paiements;
	}
    /*
	// http://localhost:8081/SpringMVC/servlet/paiementsByClient/{Paiement-idClient}
	@GetMapping(value = "/paiementsByClient/{Paiement-idClient}")
	@ResponseBody
	public List<Paiement> getPaiementsByClient(Long idClient) {
		return paiementService.getPaiementsByClientJPQL(idClient);
	}
    
	// http://localhost:8081/SpringMVC/servlet/paiementsByProduit/{Paiement-idProduit}
	@GetMapping(value = "/paiementsByProduit/{Paiement-idProduit}")
	@ResponseBody
	public List<Paiement> getPaiementsByProduit(Long idProduit) {
		return paiementService.getPaiementsByProduitJPQL(idProduit);
	}
    */
}
