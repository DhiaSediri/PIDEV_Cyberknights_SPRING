package tn.esprit.spring.Controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dto.CommandeDtoInput;
import dto.DetailsCommandeDtoInput;
import tn.esprit.spring.Entity.Client;
import tn.esprit.spring.Entity.Commande;
import tn.esprit.spring.Entity.DetailsCommande;
import tn.esprit.spring.Entity.Facture;
import tn.esprit.spring.Entity.Livreur;
import tn.esprit.spring.Entity.Paiement;
import tn.esprit.spring.Entity.Produit;
import tn.esprit.spring.Entity.TypePaiement;
import tn.esprit.spring.Entity.TypeStatut;
import tn.esprit.spring.Service.ClientServiceImpl;
import tn.esprit.spring.Service.CommandeServiceImpl;
import tn.esprit.spring.Service.DetailsCommandeServiceImpl;
import tn.esprit.spring.Service.FactureServiceImpl;
import tn.esprit.spring.Service.LivreurServiceImpl;
import tn.esprit.spring.Service.PaiementServiceImpl;
import tn.esprit.spring.Service.ProduitServiceImpl;

@RestController
public class CommandeController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	CommandeServiceImpl commandeService;

	@Autowired
	LivreurServiceImpl livreurService;

	@Autowired
	ClientServiceImpl clientService;

	@Autowired
	PaiementServiceImpl paiementService;
	
	@Autowired
	FactureServiceImpl factureService;

	@Autowired
	ProduitServiceImpl produitService;

	@Autowired
	DetailsCommandeServiceImpl detailsCommandeService;

	// http://localhost:8081/SpringMVC/servlet/add-Commande
	@PostMapping(value = "/add-Commande")
	@ResponseBody
	public ResponseEntity<Commande> addCommande(@RequestBody CommandeDtoInput commandeDtoInput) {

		Commande commande = new Commande();
		Client client = clientService.getClientById(commandeDtoInput.getIdClient());
		if (client != null) {
			commande.setClient(client);

			Commande addedCommande = commandeService.addCommande(commande);
			commandeDtoInput.getDetailsCommandeDtoInput().stream().map(this::convertDetailsCommandeDtoInputToEntity)
					.forEach(dtCommande -> {
						dtCommande.setCommande(addedCommande);
						detailsCommandeService.addDetailsCommande(dtCommande);
					});

			Paiement paiement = modelMapper.map(commandeDtoInput.getPaiementDtoInput(), Paiement.class);
			
			paiement.setDatePaiement(new Date());			
			paiement.setCommande(addedCommande);
			
			paiement = paiementService.addPaiement(paiement);
			addedCommande.setPaiement(paiement);
			
			TypeStatut typeStatut = TypeStatut.validé;//isValideCommande(addedCommande);
			addedCommande.setStatut(typeStatut);

			if (typeStatut.equals(TypeStatut.validé)) {
				addedCommande.setDateValidationCommande(new Date());
				Facture  facture = 	commandeService.genererFacture(addedCommande);
				if(paiement.getTypePaiement().equals(TypePaiement.en_ligne)){
				paiement.setValidePaiement(true);
				}
			addedCommande.setFacture(facture);
			factureService.addFacture(facture);
			}
			return ResponseEntity.ok(addedCommande);
		}
		return ResponseEntity.ok(commande);
	}

	
	@Transactional
	private void test() {
	}

	private DetailsCommande convertDetailsCommandeDtoInputToEntity(DetailsCommandeDtoInput ligneCommandeDtoInput)
			throws ParseException {
		Produit produit = produitService.getProduitById(ligneCommandeDtoInput.getIdProduit());

		DetailsCommande detailsCommande = new DetailsCommande();
		detailsCommande.setProduit(produit);
		detailsCommande.setQuantite_produit(ligneCommandeDtoInput.getQuantiteProduit());

		return detailsCommande;
	}

	// http://localhost:8081/SpringMVC/servlet/addOrUpdate-Commande	
	 @PutMapping(value = "/addOrUpdate-Commande") 
	 @ResponseBody 
	 public ResponseEntity<Commande> addOrUpdateCommande(@RequestBody CommandeDtoInput commandeDtoInput) {
		 Commande commande = new Commande();
			Client client = clientService.getClientById(commandeDtoInput.getIdClient());
			if (client != null) {
				commande.setClient(client);

				Commande addedCommande = commandeService.addCommande(commande);
				commandeDtoInput.getDetailsCommandeDtoInput().stream().map(this::convertDetailsCommandeDtoInputToEntity)
						.forEach(dtCommande -> {
							dtCommande.setCommande(addedCommande);
							detailsCommandeService.addDetailsCommande(dtCommande);
						});

				Paiement paiement = modelMapper.map(commandeDtoInput.getPaiementDtoInput(), Paiement.class);
				
				paiement.setDatePaiement(new Date());			
				paiement.setCommande(addedCommande);
				
				paiement = paiementService.addPaiement(paiement);
				addedCommande.setPaiement(paiement);
				
				TypeStatut typeStatut = TypeStatut.validé;//isValideCommande(addedCommande);
				addedCommande.setStatut(typeStatut);

				if (typeStatut.equals(TypeStatut.validé)) {
					addedCommande.setDateValidationCommande(new Date());
					Facture  facture = 	commandeService.genererFacture(addedCommande);
					if(paiement.getTypePaiement().equals(TypePaiement.en_ligne)){
					paiement.setValidePaiement(true);
					}
				addedCommande.setFacture(facture);
				factureService.addFacture(facture);
				}
				return ResponseEntity.ok(addedCommande);
			}
			return ResponseEntity.ok(commande);
	 }
	 

	// http://localhost:8081/SpringMVC/servlet/delete-Commande/{Commande-id}
	@DeleteMapping(value = "/delete-Commande/{Commande-id}")
	@ResponseBody
	public void deleteCommandeById(@RequestBody Long commandeId) {
		commandeService.deleteCommandeById(commandeId);
	}

	// http://localhost:8081/SpringMVC/servlet/commande/{Commande-id}
	@GetMapping(value = "/commande/{Commande-id}")
	@ResponseBody
	public Commande getCommandeById(@PathVariable("Commande-id") Long commandeId) {
		Commande c = commandeService.getCommandeById(commandeId);
		return c;
	}

	// http://localhost:8081/SpringMVC/servlet/getAll-Commandes
	@GetMapping(value = "/getAll-Commandes")
	@ResponseBody
	public List<Commande> getAllCommandes() {
		List<Commande> commandes = commandeService.getAllCommandes();
		return commandes;
	}

	public TypeStatut isValideCommande(Commande commande) {

		Set<DetailsCommande> detailsCommande = commande.getDetailsCommandes();

		if (commande.getPaiement().getTypePaiement().equals(TypePaiement.en_ligne)) {

			if (!commande.getPaiement().isValideCarte()) {

				return TypeStatut.refusé;
			}
		}

		for (DetailsCommande dc : detailsCommande) {
			Produit produit = new Produit();
			produit = dc.getProduit();
			if (dc.getQuantite_produit() > produit.getStock()) {
				return TypeStatut.refusé;
			}
		}
		return TypeStatut.validé;
	}
	
	// http://localhost:8081/SpringMVC/servlet/modifierValidePaiement/{Commande-id}
	@GetMapping(value = "/modifierValidePaiement/{Commande-id}")
	@ResponseBody  
	public ResponseEntity<Commande> modifierValidePaiement(@PathVariable("Commande-id") Long idCommande){
		Commande commande = commandeService.getCommandeById(idCommande);
		commande.getPaiement().setValidePaiement(true);
		return ResponseEntity.ok(commande);
	}

	// affecté un livreur à une commande si elle est validée
	public void affecterLivreurACommande(Long idCommande, Livreur livreur) {

		Commande commande = new Commande();
		commande = commandeService.getCommandeById(idCommande);

		if (commande.getStatut().equals(TypeStatut.validé)) {
			commande.setLivreur(livreur);
		}
	}

}
