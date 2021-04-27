package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="facture")
public class Facture implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private  Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="typeFacture")
	private TypeFacture typeFacture;
	
	@Temporal (TemporalType.DATE)
	@Column(name="dateCreationFacture")
	private Date dateCreationFacture;
	
	@JsonBackReference
	@OneToOne(mappedBy="facture")
	private Commande commande;

	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Facture(TypeFacture typeFacture, Date dateCreationFacture, Commande commande) {
		super();
		this.typeFacture = typeFacture;
		this.dateCreationFacture = dateCreationFacture;
		this.commande = commande;
	}

	public Facture(TypeFacture typeFacture, Date dateCreationFacture) {
		super();
		this.typeFacture = typeFacture;
		this.dateCreationFacture = dateCreationFacture;
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

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

}
