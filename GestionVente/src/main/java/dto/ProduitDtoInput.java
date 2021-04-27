package dto;

public class ProduitDtoInput {

	private Long id;
	private String nom;
	private String barcode;
	private int stock;
	private double prix;
	private String materiel;

	public ProduitDtoInput() {
	}

	public ProduitDtoInput(String nom, String barcode, int stock, double prix, String materiel) {
		super();
		this.nom = nom;
		this.barcode = barcode;
		this.stock = stock;
		this.prix = prix;
		this.materiel = materiel;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
