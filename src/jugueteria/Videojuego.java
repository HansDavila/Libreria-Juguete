package jugueteria;

public class Videojuego {
	private int id_vid;
	private String nom_vid;
	private float pre_vid;
	private String marc_vid;
	private int catg_vid;
	private int prov_vid;
	private int stock_vid;
	
	
	public Videojuego(int id_vid, String nom_vid, float pre_vid, String marc_vid, int catg_vid, int prov_vid, int stock_vid) {		
		this.id_vid = id_vid;
		this.nom_vid = nom_vid;
		this.pre_vid = pre_vid;
		this.marc_vid = marc_vid;
		this.catg_vid = catg_vid;
		this.prov_vid = prov_vid;
		this.stock_vid = stock_vid;
	}


	public int getId_vid() {
		return id_vid;
	}


	public void setId_vid(int id_vid) {
		this.id_vid = id_vid;
	}


	public String getNom_vid() {
		return nom_vid;
	}


	public void setNom_vid(String nom_vid) {
		this.nom_vid = nom_vid;
	}


	public float getPre_vid() {
		return pre_vid;
	}


	public void setPre_vid(float pre_vid) {
		this.pre_vid = pre_vid;
	}


	public String getMarc_vid() {
		return marc_vid;
	}


	public void setMarc_vid(String marc_vid) {
		this.marc_vid = marc_vid;
	}


	public int getCatg_vid() {
		return catg_vid;
	}


	public void setCatg_vid(int catg_vid) {
		this.catg_vid = catg_vid;
	}


	public int getProv_vid() {
		return prov_vid;
	}


	public void setProv_vid(int prov_vid) {
		this.prov_vid = prov_vid;
	}


	public int getStock_vid() {
		return stock_vid;
	}


	public void setStock_vid(int stock_vid) {
		this.stock_vid = stock_vid;
	}
	
	public String toString() {
		return id_vid + "," + nom_vid + "," + pre_vid + "," + marc_vid + "," + catg_vid + "," + prov_vid + "," + stock_vid  +"\n";
	}
	
	

}
