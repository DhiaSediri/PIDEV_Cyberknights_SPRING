package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.Entity.Produit;

public interface ProduitRepository extends CrudRepository<Produit, Long> {

}
