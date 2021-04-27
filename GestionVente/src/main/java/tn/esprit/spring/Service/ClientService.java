package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.Entity.Client;

public interface ClientService {

	public Client addClient(Client client);
	public Client addOrUpdateClient(Client client);
	public void deleteClientById(Long clientId);
	public Client getClientById(Long clientId);
	public List<Client> getAllClients(); 
}
