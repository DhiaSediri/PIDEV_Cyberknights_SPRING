package dto;

public class DetailsCommandeDtoInput {
	
	private Long idProduit;
	private int quantiteProduit;

	public DetailsCommandeDtoInput() {
	}

	public DetailsCommandeDtoInput(Long idProduit, int quantiteProduit) {
		super();	
		this.idProduit = idProduit;
		this.quantiteProduit = quantiteProduit;
	}
	
	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public int getQuantiteProduit() {
		return quantiteProduit;
	}

	public void setQuantiteProduit(int quantiteProduit) {
		this.quantiteProduit = quantiteProduit;
	}

}
