package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//con esta anotacion la convertimos en una entidad
@Entity
@Table(name="productos")//con esto enlazamos con el nombre de la tabla a la que nos referimos
public class Producto {
	@Id //con esto le decimos que la siguiente es PK
	@GeneratedValue(strategy=GenerationType.IDENTITY)//asi le decimos que es autogenerado
	private int idProducto;
	private String nombreProducto;
	private String categoriaProducto;
	private double precioProducto;
	
	//hay que crear un constructor sin nada
	public Producto() {
		super();
	}
	
	public Producto(int idProducto, String nombreProducto, String categoriaProducto, double precioProducto) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.categoriaProducto = categoriaProducto;
		this.precioProducto = precioProducto;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getCategoriaProducto() {
		return categoriaProducto;
	}
	public void setCategoriaProducto(String categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}
	public double getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}
	
	
	

}
