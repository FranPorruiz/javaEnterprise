package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cursos")
public class Curso {
	//creamos los atributos en privado para que se necesite getter y setters luego
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//asi le decimos que es autogenerado
	private int idCurso;
	@Column(name="denominacion")
	private String nombre;
	private int duracion;
	private double precio;//double por ser decimal
	//constructor(con el boton derecho en source podemos generarlo)
	public Curso( int idCurso, String nombre, int duracion, double precio) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}
	
	
	public Curso() {
		super();
	}


	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
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
