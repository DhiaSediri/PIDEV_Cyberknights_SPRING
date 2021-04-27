package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="produit")
public class Produit /*implements Serializable*/{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private  Long id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="barcode")
	private String barcode;
	
	@Column(name="stock")
	private int stock; 
	
	@Column(name="prix")
	private double prix; 
	
	@Column(name="materiel")
	private String materiel;

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy="produit")
	private Set<DetailsCommande> detailsCommandes;

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produit(String nom, String barcode, int stock, double prix, String materiel,
			Set<DetailsCommande> detailsCommandes) {
		super();
		this.nom = nom;
		this.barcode = barcode;
		this.stock = stock;
		this.prix = prix;
		this.materiel = materiel;
		this.detailsCommandes = detailsCommandes;
	}

	public Produit(String nom, String barcode, int stock, double prix, String materiel) {
		super();
		this.nom = nom;
		this.barcode = barcode;
		this.stock = stock;
		this.prix = prix;
		this.materiel = materiel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getMateriel() {
		return materiel;
	}

	public void setMateriel(String materiel) {
		this.materiel = materiel;
	}

	public Set<DetailsCommande> getDetailsCommandes() {
		return detailsCommandes;
	}

	public void setDetailsCommandes(Set<DetailsCommande> detailsCommandes) {
		this.detailsCommandes = detailsCommandes;
	}

}
