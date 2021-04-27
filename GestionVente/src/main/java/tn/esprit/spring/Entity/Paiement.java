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
@Table(name="paiement")
public class Paiement implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private  Long id;
	
	@Column(name="validePaiement")
	private Boolean validePaiement = false;
	
	@Enumerated(EnumType.STRING)
	@Column(name="typePaiement")
	private TypePaiement typePaiement;
	
	@Enumerated(EnumType.STRING)
	@Column(name="typeCarte")
	private TypeCarte typeCarte;
	
	@Temporal (TemporalType.DATE)
	@Column(name="dateExpirationCarte")
	private Date dateExpirationCarte;
	
	@Column(name="numeroCarte")
	private Long numeroCarte ;
	
	@Column(name="codeSecret")
	private Long codeSecret ;
	
	@Column(name="nomProprietaire")
	private String nomProprietaire;
		
	@Temporal (TemporalType.DATE)
	@Column(name="datePaiement")
	private Date datePaiement;
	
	@JsonBackReference
	@OneToOne(mappedBy="paiement")
	private Commande commande;

	public Paiement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paiement(Boolean validePaiement, TypePaiement typePaiement, TypeCarte typeCarte, Date dateExpirationCarte,
			Long numeroCarte, Long codeSecret, String nomProprietaire, Date datePaiement, Commande commande) {
		super();
		this.validePaiement = validePaiement;
		this.typePaiement = typePaiement;
		this.typeCarte = typeCarte;
		this.dateExpirationCarte = dateExpirationCarte;
		this.numeroCarte = numeroCarte;
		this.codeSecret = codeSecret;
		this.nomProprietaire = nomProprietaire;
		this.datePaiement = datePaiement;
		this.commande = commande;
	}
	

	public Paiement(Boolean validePaiement, TypePaiement typePaiement, TypeCarte typeCarte, Date dateExpirationCarte,
			/*String numeroCarte,*/ Long codeSecret, String nomProprietaire, Date datePaiement) {
		super();
		this.validePaiement = validePaiement;
		this.typePaiement = typePaiement;
		this.typeCarte = typeCarte;
		this.dateExpirationCarte = dateExpirationCarte;
		//this.numeroCarte = numeroCarte;
		this.codeSecret = codeSecret;
		this.nomProprietaire = nomProprietaire;
		this.datePaiement = datePaiement;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getValidePaiement() {
		return validePaiement;
	}

	public void setValidePaiement(Boolean validePaiement) {
		this.validePaiement = validePaiement;
	}

	public TypePaiement getTypePaiement() {
		return typePaiement;
	}

	public void setTypePaiement(TypePaiement typePaiement) {
		this.typePaiement = typePaiement;
	}

	public TypeCarte getTypeCarte() {
		return typeCarte;
	}

	public void setTypeCarte(TypeCarte typeCarte) {
		this.typeCarte = typeCarte;
	}

	public Date getDateExpirationCarte() {
		return dateExpirationCarte;
	}

	public void setDateExpirationCarte(Date dateExpirationCarte) {
		this.dateExpirationCarte = dateExpirationCarte;
	}

	public Long getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(Long numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	public Long getCodeSecret() {
		return codeSecret;
	}

	public void setCodeSecret(Long codeSecret) {
		this.codeSecret = codeSecret;
	}

	public String getNomProprietaire() {
		return nomProprietaire;
	}

	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}

	public Date getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	public Boolean isValideCarte(){
		return /*commande.getPaiement().getNumeroCarte().length() == 16
				&&*/ new Date().before(commande.getPaiement().getDateExpirationCarte());
	}
	
}
