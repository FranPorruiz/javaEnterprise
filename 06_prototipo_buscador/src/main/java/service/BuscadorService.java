package service;


import java.util.ArrayList;
import java.util.List;
import model.Pagina;

public class BuscadorService {
	//Array list de ejemplos
	List<Pagina> resultados=new ArrayList<>(
			List.of(
					new Pagina("http://www.fnac.es","libros", "Libros y más"),
					new Pagina("http://www.mybook.com","libros", "libreria de temas varios"),
					new Pagina("http://www.games.es","juegos", "Más que juegos"),
					new Pagina("http://www.juegomania.es","juegos", "Juegos y mas"),
					new Pagina("http://www.dulces.es","chucherias", "Dulces y chucerias")
					));
	
	//filtro para que encuentre la tematica que buscamos 
	public List<Pagina> buscar(String tematica){
		List<Pagina> filtrados=new ArrayList<>();
		for (Pagina pagina : resultados) {
			if (pagina.getTematica().equals(tematica)) {
				filtrados.add(pagina);				
			}
		}
		return filtrados;	
	}

}
