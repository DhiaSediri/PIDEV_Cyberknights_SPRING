package dto;

import java.util.Date;

import tn.esprit.spring.Entity.TypeCarte;
import tn.esprit.spring.Entity.TypePaiement;

public class PaiementDtoInput {

	private Long id;
	private TypePaiement typePaiement;
	private TypeCarte typeCarte;
	private Date dateExpirationCarte;
	private Long numeroCarte;
	private Long codeSecret;
	private String nomProprietaire;

	public PaiementDtoInput() {
	}

	public PaiementDtoInput(Boolean validePaiement, TypePaiement typePaiement, TypeCarte typeCarte,
			Date dateExpirationCarte, Long numeroCarte, Long codeSecret, String nomProprietaire) {
		super();
		this.typePaiement = typePaiement;
		this.typeCarte = typeCarte;
		this.dateExpirationCarte = dateExpirationCarte;
		this.numeroCarte = numeroCarte;
		this.codeSecret = codeSecret;
		this.nomProprietaire = nomProprietaire;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
