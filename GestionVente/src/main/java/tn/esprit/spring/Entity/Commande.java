package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="commande")
public class Commande implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private  Long id;
	
	@Temporal (TemporalType.DATE)
	@Column(name="dateCreationCommande")
	private Date dateCreationCommande = new Date();
	
	@Temporal (TemporalType.DATE)
	@Column(name="dateValidationCommande")
	private Date dateValidationCommande;
	
	@Enumerated(EnumType.STRING)
	@Column(name="statut")
	private TypeStatut statut = TypeStatut.en_cour;
		
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy="commande")
	private Set<DetailsCommande> detailsCommandes;
	
	@JsonManagedReference
	@OneToOne
	private Paiement paiement;
	
	@JsonManagedReference
	@OneToOne
	private Facture facture;
	
	@JsonManagedReference
	@ManyToOne
	Client client;
	
	@JsonManagedReference
	@ManyToOne
	Livreur livreur;

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(Date dateCreationCommande, Date dateValidationCommande,
			Set<DetailsCommande> detailsCommandes, Paiement paiement, Facture facture, Client client, Livreur livreur) {
		super();
		this.dateCreationCommande = dateCreationCommande;
		this.dateValidationCommande = dateValidationCommande;
		this.statut = TypeStatut.en_cour;
		for(DetailsCommande dc : detailsCommandes ){
			dc.setCommande(this);
		}
		this.detailsCommandes = detailsCommandes;
		this.paiement = paiement;
		this.facture = facture;
		this.client = client;
		this.livreur = livreur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateCreationCommande() {
		return dateCreationCommande;
	}

	public void setDateCreationCommande(Date dateCreationCommande) {
		this.dateCreationCommande = dateCreationCommande;
	}

	public Date getDateValidationCommande() {
		return dateValidationCommande;
	}

	public void setDateValidationCommande(Date dateValidationCommande) {
		this.dateValidationCommande = dateValidationCommande;
	}

	public TypeStatut getStatut() {
		return statut;
	}

	public void setStatut(TypeStatut statut) {
		this.statut = statut;
	}

	public Set<DetailsCommande> getDetailsCommandes() {
		return detailsCommandes;
	}

	public void setDetailsCommandes(Set<DetailsCommande> detailsCommandes) {
		this.detailsCommandes = detailsCommandes;
	}

	public Paiement getPaiement() {
		return paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}
		
}
