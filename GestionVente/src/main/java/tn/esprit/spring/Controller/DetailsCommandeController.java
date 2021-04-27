package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dto.DetailsCommandeDtoInput;
import tn.esprit.spring.Entity.DetailsCommande;
import tn.esprit.spring.Service.DetailsCommandeServiceImpl;

@RestController
public class DetailsCommandeController {

	@Autowired
	DetailsCommandeServiceImpl detailsCommandeService;

	// http://localhost:8081/SpringMVC/servlet/add-DetailsCommande
	@PostMapping(value = "/add-DetailsCommande")
	@ResponseBody
	public ResponseEntity<DetailsCommande> addDetailsCommande(
			@RequestBody DetailsCommandeDtoInput detailsCommandeDtoInput) {
		DetailsCommande detailsCommande = new DetailsCommande();
		// detailsCommande.setCommande(detailsCommandeDtoInput.getIdCommande());
		// detailsCommande.setProduit(detailsCommandeDtoInput.getIdProduit());
		detailsCommande.setQuantite_produit(detailsCommandeDtoInput.getQuantiteProduit());
		DetailsCommande dc = detailsCommandeService.addDetailsCommande(detailsCommande);
		return ResponseEntity.ok(dc);
	}

	// http://localhost:8081/SpringMVC/servlet/addOrUpdate-DetailsCommande
	@PutMapping(value = "/addOrUpdate-DetailsCommande")
	@ResponseBody
	public ResponseEntity<DetailsCommande> addOrUpdateDetailsCommande(
			@RequestBody DetailsCommandeDtoInput detailsCommandeDtoInput) {
		DetailsCommande detailsCommande = new DetailsCommande();
		// detailsCommande.setCommande(detailsCommandeDtoInput.getIdCommande());
		// detailsCommande.setProduit(detailsCommandeDtoInput.getIdProduit());
		detailsCommande.setQuantite_produit(detailsCommandeDtoInput.getQuantiteProduit());
		DetailsCommande dc = detailsCommandeService.addOrUpdateDetailsCommande(detailsCommande);
		return ResponseEntity.ok(dc);
	}

	// http://localhost:8081/SpringMVC/servlet/delete-DetailsCommande/{DetailsCommande-id}
	@DeleteMapping(value = "/delete-DetailsCommande/{DetailsCommande-id}")
	@ResponseBody
	public void deleteDetailsCommandeById(@RequestBody Long detailsCommandeId) {
		detailsCommandeService.deleteDetailsCommandeById(detailsCommandeId);
	}

	// http://localhost:8081/SpringMVC/servlet/DetailsCommande/{DetailsCommande-id}
	@GetMapping(value = "/DetailsCommande/{DetailsCommande-id}")
	@ResponseBody
	public DetailsCommande getDetailsCommandeById(@PathVariable("DetailsCommande-id") Long detailsCommandeId) {
		DetailsCommande dc = detailsCommandeService.getDetailsCommandeById(detailsCommandeId);
		return dc;
	}

	// http://localhost:8081/SpringMVC/servlet/getAll-DetailsCommande
	@GetMapping(value = "/getAll-DetailsCommande")
	@ResponseBody
	public List<DetailsCommande> getAllDetailsCommandes() {
		List<DetailsCommande> detailsCommandes = detailsCommandeService.getAllDetailsCommandes();
		return detailsCommandes;
	}

}
