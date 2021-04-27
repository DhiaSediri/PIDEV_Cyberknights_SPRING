package tn.esprit.spring.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="detailsCommande")
public class DetailsCommande implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private  Long id;
	
	@JsonManagedReference
	@ManyToOne
	private Produit produit;
	
	@JsonBackReference
	@ManyToOne
	private Commande commande;
	
	@Column(name="quantite_produit")
	private int quantite_produit;

	public DetailsCommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetailsCommande(Produit produit, Commande commande, int quantite_produit) {
		super();
		this.produit = produit;
		this.commande = commande;
		this.quantite_produit = quantite_produit;
	}
	
	public DetailsCommande(Produit produit, int quantite_produit) {
		super();
		this.produit = produit;
		this.quantite_produit = quantite_produit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public int getQuantite_produit() {
		return quantite_produit;
	}

	public void setQuantite_produit(int quantite_produit) {
		this.quantite_produit = quantite_produit;
	}
	
}
