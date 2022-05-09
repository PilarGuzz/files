package xml.model;

public class Coche {
	
	private int id;
	private String modelo;
	private String marca;
	private String cilindrada;
	
	
	public Coche(){	}


	public Coche(int id, String modelo, String marca, String cilindrada) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.cilindrada = cilindrada;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getCilindrada() {
		return cilindrada;
	}


	public void setCilindrada(String cilindrada) {
		this.cilindrada = cilindrada;
	}


	

}
