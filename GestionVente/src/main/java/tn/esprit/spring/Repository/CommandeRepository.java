package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.Commande;

@Repository
public interface CommandeRepository extends CrudRepository<Commande, Long> {

}
