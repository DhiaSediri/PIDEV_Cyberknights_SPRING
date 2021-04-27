package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Paiement;
import tn.esprit.spring.Entity.TypePaiement;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    
	/*@Query("SELECT p FROM paiement p WHERE p.typePaiement=:typePaiement")
	public List<Paiement> getPaiementsByTypePaiement(@Param("typePaiement") String type);
    /*
	@Query("SELECT p FROM paiement p JOIN FETCH p.commande c JOIN FETCH c.client clt WHERE clt.id=:idClient")
	public List<Paiement> getPaiementsByClientJPQL(@Param("idClient") Long idClient);

	@Query("SELECT p FROM paiement p JOIN FETCH p.commande c JOIN FETCH c.detailsCommandes dc JOIN FETCH dc.produit p WHERE p.id=:idProduit")
	public List<Paiement> getPaiementsByProduitJPQL(@Param("idProduit") Long idProduit);
	*/
}
