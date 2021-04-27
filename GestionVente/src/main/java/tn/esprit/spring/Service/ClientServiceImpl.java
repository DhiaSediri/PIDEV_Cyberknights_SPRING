package tn.esprit.spring.Service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Client;
import tn.esprit.spring.Repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;
	
	private static final Logger l = LogManager.getLogger(ClientServiceImpl.class);
	
	@Override
	public Client addClient(Client client) {
		l.info("In addClient : " + client);
		Client clt = clientRepository.save(client);
		l.info("Out of addClient. : " + client);
		return clt;
	}

	@Override
	public Client addOrUpdateClient(Client client) {
		l.info("In addOrUpdateClient : " + client);
		Client clt = clientRepository.save(client);
		l.info("Out of addOrUpdateCommande : " + client);
		return clt;
	}

	@Override
	public void deleteClientById(Long clientId) {
		l.info("In deleteClientById : " + clientId);
		clientRepository.deleteById(clientId);
		l.info("Out of deleteClientById : " + clientId);
	}

	@Override
	public Client getClientById(Long clientId) {
		l.info("In getClientById id : " + clientId);
		Client clt = clientRepository.findById(clientId).get();
		l.info("Client returned : " + clt);
		return clt;
	}

	@Override
	public List<Client> getAllClients() {
		l.info("In getAllClients : ");
		List<Client> clients = (List<Client>) clientRepository.findAll();
		for(Client clt : clients){
			l.debug("Client +++ : " + clt);
		}
		l.info("Out of getAllClients : ");
		return clients; 
	}

}
