package tn.esprit.spring.Controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

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

import dto.ClientDtoInput;
import dto.FactureDtoInput;
import tn.esprit.spring.Entity.Client;
import tn.esprit.spring.Entity.Facture;
import tn.esprit.spring.Entity.TypeFacture;
import tn.esprit.spring.Service.CommandeServiceImpl;
import tn.esprit.spring.Service.FactureServiceImpl;

@RestController
public class FactureController {

	@Autowired
	FactureServiceImpl factureService;
	
	@Autowired
	private ModelMapper modelMapper;

	// http://localhost:8081/SpringMVC/servlet/add-Facture
	@PostMapping(value = "/add-Facture")
	@ResponseBody
	public ResponseEntity<Facture> addFacture(@RequestBody FactureDtoInput factureDtoInput) {
		Facture facture = new Facture();
		facture.setTypeFacture(factureDtoInput.getTypeFacture());
		facture.setDateCreationFacture(new Date());
		//facture.setCommande(factureDtoInput.getIdCommande());
		Facture f = factureService.addFacture(facture);
		return ResponseEntity.ok(f);
	}

	// http://localhost:8081/SpringMVC/servlet/addOrUpdate-Facture
	@PutMapping(value = "/addOrUpdate-Facture")
	@ResponseBody
	public ResponseEntity<Facture> addOrUpdateFacture(@RequestBody FactureDtoInput factureDtoInput) {
		Facture facture = convertFactureDtoInputToEntity(factureDtoInput);	
		Facture f = factureService.addOrUpdateFacture(facture);
		return ResponseEntity.ok(f);
	}

	// http://localhost:8081/SpringMVC/servlet/delete-Facture/{Facture-id}
	@DeleteMapping(value = "/delete-Facture/{Facture-id}")
	@ResponseBody
	public void supprimerFacture(@RequestBody Long factureId) {
		factureService.deleteFactureById(factureId);
	}

	// http://localhost:8081/SpringMVC/servlet/facture/{Facture-id}
	@GetMapping(value = "/facture/{Facture-id}")
	@ResponseBody
	public Facture getFactureById(@PathVariable("Facture-id") Long factureId) {
		Facture f = factureService.getFactureById(factureId);
		return f;
	}

	// http://localhost:8081/SpringMVC/servlet/getAll-Factures/mohamed
	@GetMapping(value = "/getAll-Factures/mohamed")
	@ResponseBody
	public List<Facture> getAllFactures() {
		List<Facture> factures = factureService.getAllFactures();
		return factures;
	}
	
	private Facture convertFactureDtoInputToEntity(FactureDtoInput factureDtoInput) throws ParseException {
		Facture facture = modelMapper.map(factureDtoInput, Facture.class);
		if (factureDtoInput.getId() != null) {
			Facture oldFacture = factureService.getFactureById(factureDtoInput.getId());
			modelMapper.map(factureDtoInput, oldFacture);
			return oldFacture;
		}
		return facture;
	}
	
	/*
	// http://localhost:8081/SpringMVC/servlet/facturesByType/{Facture-type}
		@GetMapping(value = "/facturesByType/{Facture-type}")
		@ResponseBody
		public List<Facture> getFacturesByType(@PathVariable("Facture-type") TypeFacture type) {
			return factureService.getFacturesByTypeJPQL(type);
		}
		
		// http://localhost:8081/SpringMVC/servlet/facturesByClient/{Facture-idClient}
		@GetMapping(value = "/facturesByClient/{Facture-idClient}")
		@ResponseBody
		public List<Facture> getFacturesByClient(Long idClient) {
			return factureService.getFacturesByClientJPQL(idClient);
		}
        */
}
