package tn.esprit.spring.Controller;

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

import dto.ProduitDtoInput;
import tn.esprit.spring.Entity.Produit;
import tn.esprit.spring.Service.ProduitServiceImpl;

@RestController
public class ProduitController {

	@Autowired
	ProduitServiceImpl produitService;

	@Autowired
	private ModelMapper modelMapper;

	// http://localhost:8081/SpringMVC/servlet/add-Produit
	@PostMapping(value = "/add-Produit")
	@ResponseBody
	public ResponseEntity<Produit> addProduit(@RequestBody ProduitDtoInput produitDtoInput) {
		Produit produit = new Produit();
		produit.setNom(produitDtoInput.getNom());
		produit.setBarcode(produitDtoInput.getBarcode());
		produit.setMateriel(produitDtoInput.getMateriel());
		produit.setPrix(produitDtoInput.getPrix());
		produit.setStock(produitDtoInput.getStock());
		Produit p = produitService.addProduit(produit);
		return ResponseEntity.ok(p);
	}

	// http://localhost:8081/SpringMVC/servlet/addOrUpdate-Produit
	@PutMapping(value = "/addOrUpdate-Produit")
	@ResponseBody
	public ResponseEntity<Produit> addOrUpdateProduit(@RequestBody ProduitDtoInput produitDtoInput) {
		Produit produit = convertProduitDtoInputToEntity(produitDtoInput);	
		Produit p = produitService.addOrUpdateProduit(produit);
		return ResponseEntity.ok(p);
	}

	// http://localhost:8081/SpringMVC/servlet/delete-Produit/{Produit-id}
	@DeleteMapping(value = "/delete-Produit/{Produit-id}")
	@ResponseBody
	public ResponseEntity<Long> deleteProduitById(@PathVariable("Produit-id") Long produitId) {
		produitService.deleteProduitById(produitId);
		return ResponseEntity.ok(produitId);
	
	}

	// http://localhost:8081/SpringMVC/servlet/produit/{Produit-id}
	@GetMapping(value = "/produit/{Produit-id}")
	@ResponseBody
	public Produit getProduitById(@PathVariable("Produit-id") Long produitId) {
		Produit p = produitService.getProduitById(produitId);
		return p;
	}

	// http://localhost:8081/SpringMVC/servlet/getAll-Produits
	@GetMapping(value = "/getAll-Produits")
	@ResponseBody
	public List<Produit> getAllProduits() {
		List<Produit> Produits = produitService.getAllProduits();
		return Produits;
	}

	private Produit convertProduitDtoInputToEntity(ProduitDtoInput produitDtoInput) throws ParseException {
		Produit produit = modelMapper.map(produitDtoInput, Produit.class);
		if (produitDtoInput.getId() != null) {
			Produit oldProduit = produitService.getProduitById(produitDtoInput.getId());
			modelMapper.map(produitDtoInput, oldProduit);
			return oldProduit;
		}
		return produit;
	}
}
