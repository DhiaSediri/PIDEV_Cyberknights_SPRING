package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.Entity.Facture;
import tn.esprit.spring.Entity.TypeFacture;

public interface FactureRepository extends CrudRepository<Facture, Long> {
    /*
	@Query("SELECT f FROM facture f WHERE f.typeFacture=:typeFacture")
	public List<Facture> getFacturesByTypeJPQL(@Param("typeFacture") TypeFacture type);

	@Query("SELECT f FROM facture f JOIN FETCH f.commande c JOIN FETCH c.client clt WHERE clt.id=:idClient")
	public List<Facture> getFacturesByClientJPQL(@Param("idClient") Long idClient);
	*/
}
