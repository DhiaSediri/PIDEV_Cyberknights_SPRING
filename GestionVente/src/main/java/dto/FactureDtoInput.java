package dto;

import java.util.Date;
import tn.esprit.spring.Entity.TypeFacture;

public class FactureDtoInput {

	private Long id;
	private TypeFacture typeFacture;
	private Date dateCreationFacture;
	//private int idCommande;

	public FactureDtoInput() {
	}

	public FactureDtoInput(TypeFacture typeFacture, Date dateCreationFacture/*, int idCommande*/) {
		super();
		this.typeFacture = typeFacture;
		this.dateCreationFacture = dateCreationFacture;
		//this.idCommande = idCommande;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeFacture getTypeFacture() {
		return typeFacture;
	}

	public void setTypeFacture(TypeFacture typeFacture) {
		this.typeFacture = typeFacture;
	}

	public Date getDateCreationFacture() {
		return dateCreationFacture;
	}

	public void setDateCreationFacture(Date dateCreationFacture) {
		this.dateCreationFacture = dateCreationFacture;
	}

	/*public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}*/

}
