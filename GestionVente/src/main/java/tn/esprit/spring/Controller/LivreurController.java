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

import dto.LivreurDtoInput;
import tn.esprit.spring.Entity.Livreur;
import tn.esprit.spring.Service.LivreurServiceImpl;

@RestController
public class LivreurController {

	@Autowired
	LivreurServiceImpl livreurService;
	
	@Autowired
	private ModelMapper modelMapper;

	// http://localhost:8081/SpringMVC/servlet/add-Livreur
	@PostMapping(value = "/add-Livreur")
	@ResponseBody
	public ResponseEntity<Livreur> addLivreur(@RequestBody LivreurDtoInput livreurDoInput) {
		Livreur livreur = new Livreur();
		livreur.setNom(livreurDoInput.getNom());
		livreur.setPrenom(livreurDoInput.getPrenom());
		livreur.setEmail(livreurDoInput.getEmail());
		livreur.setTelephone(livreurDoInput.getTelephone());
		livreur.setAdresse(livreurDoInput.getAdresse());
		Livreur liv = livreurService.addLivreur(livreur);
		return ResponseEntity.ok(liv);
	}

	// http://localhost:8081/SpringMVC/servlet/addOrUpdate-Livreur
	@PutMapping(value = "/addOrUpdate-Livreur")
	@ResponseBody
	public ResponseEntity<Livreur> addOrUpdateLivreur(@RequestBody LivreurDtoInput livreurDtoInput) {
		Livreur livreur = convertLivreurDtoInputToEntity(livreurDtoInput);	
		Livreur l = livreurService.addOrUpdateLivreur(livreur);
		return ResponseEntity.ok(l);
	}

	// http://localhost:8081/SpringMVC/servlet/delete-Livreur/{Livreur-id}
	@DeleteMapping(value = "/delete-Livreur/{Livreur-id}")
	@ResponseBody
	public void deleteLivreurById(@RequestBody Long livreurId) {
		livreurService.deleteLivreurById(livreurId);
	}

	// http://localhost:8081/SpringMVC/servlet/livreur/{Livreur-id}
	@GetMapping(value = "/livreur/{Livreur-id}")
	@ResponseBody
	public Livreur getLivreurById(@PathVariable("Livreur-id") Long livreurId) {
		Livreur l = livreurService.getLivreurById(livreurId);
		return l;
	}

	// http://localhost:8081/SpringMVC/servlet/getAll-Livreurs
	@GetMapping(value = "/getAll-Livreurs")
	@ResponseBody
	public List<Livreur> getAllLivreurs() {
		List<Livreur> Livreurs = livreurService.getAllLivreurs();
		return Livreurs;
	}
	
	private Livreur convertLivreurDtoInputToEntity(LivreurDtoInput livreurDtoInput) throws ParseException {
		Livreur livreur = modelMapper.map(livreurDtoInput, Livreur.class);
		if (livreurDtoInput.getId() != null) {
			Livreur oldLivreur = livreurService.getLivreurById(livreurDtoInput.getId());
			modelMapper.map(livreurDtoInput, oldLivreur);
			return oldLivreur;
		}
		return livreur;
	}

}
