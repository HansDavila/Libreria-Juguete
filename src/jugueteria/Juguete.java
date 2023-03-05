package jugueteria;

public class Juguete {
	// Propiedades de Clase
	private int id_jug;
	private String nom_jug;
	private float pre_jug;
	private String marc_jug;
	private int catg_jug;
	private int prov_jug;
	private int stock_jug;

	// CONSTRUCTOR
	public Juguete(int id_jug, String nom_jug, float pre_jug, String marc_jug, int catg_jug, int prov_jug, int stock_jug) {
		super();
		this.id_jug = id_jug;
		this.nom_jug = nom_jug;
		this.pre_jug = pre_jug;
		this.marc_jug = marc_jug;
		this.catg_jug = catg_jug;
		this.prov_jug = prov_jug;
		this.stock_jug = stock_jug;
	}

	// GETTERS Y SETTERS
	public int getId_jug() {
		return id_jug;
	}

	public void setId_jug(int id_jug) {
		this.id_jug = id_jug;
	}

	public String getNom_jug() {
		return nom_jug;
	}

	public void setNom_jug(String nom_jug) {
		this.nom_jug = nom_jug;
	}

	public float getPre_jug() {
		return pre_jug;
	}

	public void setPre_jug(float pre_jug) {
		this.pre_jug = pre_jug;
	}

	public String getMarc_jug() {
		return marc_jug;
	}

	public void setMarc_jug(String marc_jug) {
		this.marc_jug = marc_jug;
	}

	public int getCatg_jug() {
		return catg_jug;
	}

	public void setCatg_jug(int catg_jug) {
		this.catg_jug = catg_jug;
	}

	public int getStock_jug() {
		return stock_jug;
	}

	public void setStock(int stock) {
		this.stock_jug = stock;
	}
	
	public int getProv_jug() {
		return prov_jug;
	}

	public void setProv_jug(int prov_jug) {
		this.prov_jug = prov_jug;
	}
		
	// Sobreescribiendo Metodo
	public String toString() {
		return id_jug + "," + nom_jug + "," + pre_jug + "," + marc_jug + "," + catg_jug + "," + prov_jug + "," + stock_jug  +"\n";
	}

	

}