package model;

public class Curso {
	//creamos los atributos en privado para que se necesite getter y setters luego
	private String nombre;
	private int duracion;
	private double precio;//double por ser decimal
	//constructor(con el boton derecho en source podemos generarlo)
	public Curso(String nombre, int duracion, double precio) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}
	
	//getters y setters, generado tambien con el boton derecho
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	

	
}
