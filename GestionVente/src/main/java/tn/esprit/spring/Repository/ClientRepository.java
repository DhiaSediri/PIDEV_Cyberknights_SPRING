package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.Entity.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
