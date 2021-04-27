package dto;

import java.util.Date;
import java.util.Set;

import tn.esprit.spring.Entity.DetailsCommande;
import tn.esprit.spring.Entity.TypePaiement;
import tn.esprit.spring.Entity.TypeStatut;

public class CommandeDtoInput {
	
	private Long idClient;	
	private Set<DetailsCommandeDtoInput> detailsCommandeDtoInput;
	private PaiementDtoInput paiementDtoInput;
	
	public CommandeDtoInput() {
	}

	public CommandeDtoInput(Long idClient, Set<DetailsCommandeDtoInput> detailsCommandeDtoInput,
			PaiementDtoInput paiementDtoInput) {
		super();
		this.idClient = idClient;
		this.detailsCommandeDtoInput = detailsCommandeDtoInput;
		this.paiementDtoInput = paiementDtoInput;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public Set<DetailsCommandeDtoInput> getDetailsCommandeDtoInput() {
		return detailsCommandeDtoInput;
	}

	public void setDetailsCommandeDtoInput(Set<DetailsCommandeDtoInput> detailsCommandeDtoInput) {
		this.detailsCommandeDtoInput = detailsCommandeDtoInput;
	}

	public PaiementDtoInput getPaiementDtoInput() {
		return paiementDtoInput;
	}

	public void setPaiementDtoInput(PaiementDtoInput paiementDtoInput) {
		this.paiementDtoInput = paiementDtoInput;
	}

}
