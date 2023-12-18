package model;

public class Pagina {
	//JavaBean
	 private String tematica, url, descripcion;
	 
	public Pagina( String url, String tematica, String descripcion) {
		super();
		this.tematica = tematica;
		this.url = url;
		this.descripcion = descripcion;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	 
	 
	

}
