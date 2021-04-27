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

import dto.ClientDtoInput;
import tn.esprit.spring.Entity.Client;
import tn.esprit.spring.Service.ClientServiceImpl;

@RestController
public class ClientController {

	@Autowired
	ClientServiceImpl clientService;
	
	@Autowired
	private ModelMapper modelMapper;

	// http://localhost:8081/SpringMVC/servlet/add-Client
	@PostMapping(value = "/add-Client")
	@ResponseBody
	public ResponseEntity<Client> addClient(@RequestBody ClientDtoInput clientDtoInput) {
		Client client = new Client();
		client.setNom(clientDtoInput.getNom());
		client.setPrenom(clientDtoInput.getPrenom());
		client.setEmail(clientDtoInput.getEmail());
		client.setTelephone(clientDtoInput.getTelephone());
		client.setAdresse(clientDtoInput.getAdresse());
		Client clt = clientService.addClient(client);
		return ResponseEntity.ok(clt);
	}

	// http://localhost:8081/SpringMVC/servlet/addOrUpdate-Client
	@PutMapping(value = "/addOrUpdate-Client")
	@ResponseBody
	public ResponseEntity<Client> addOrUpdateClient(@RequestBody ClientDtoInput clientDtoInput) {
		Client client = convertClientDtoInputToEntity(clientDtoInput);	
		Client clt = clientService.addOrUpdateClient(client);
		return ResponseEntity.ok(clt);
	}

	// http://localhost:8081/SpringMVC/servlet/delete-Client/{Client-id}
	@DeleteMapping(value = "/delete-Client/{Client-id}")
	@ResponseBody
	public void deleteClientById(@RequestBody Long clientId) {
		clientService.deleteClientById(clientId);
	}

	// http://localhost:8081/SpringMVC/servlet/client/{Client-id}
	@GetMapping(value = "/client/{Client-id}")
	@ResponseBody
	public Client getClientById(@PathVariable("Client-id") Long clientId) {
		Client clt = clientService.getClientById(clientId);
		return clt;
	}

	// http://localhost:8081/SpringMVC/servlet/getAll-Clients
	@GetMapping(value = "/getAll-Clients")
	@ResponseBody
	public List<Client> getAllClients() {
		List<Client> clients = clientService.getAllClients();
		return clients;
	}
	
	private Client convertClientDtoInputToEntity(ClientDtoInput clientDtoInput) throws ParseException {
		Client client = modelMapper.map(clientDtoInput, Client.class);
		if (clientDtoInput.getId() != null) {
			Client oldClient = clientService.getClientById(clientDtoInput.getId());
			modelMapper.map(clientDtoInput, oldClient);
			return oldClient;
		}
		return client;
	}

}
