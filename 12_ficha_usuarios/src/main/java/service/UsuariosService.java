package service;

import java.util.ArrayList;
import java.util.List;

import model.Ficha;
import model.Usuario;

public class UsuariosService {
	
	List<Usuario> listUsuario=new ArrayList<Usuario>(List.of(
			new Usuario("user1", "pwd1"),
			new Usuario("user2","pwd2"),
			new Usuario("user3","pwd3"),
			new Usuario("user4","pwd4")
			));
	
	//lista de fichas 
	List<Ficha> listFichas=new ArrayList<Ficha>(List.of(
			new Ficha("user1", 65, "user1@gmail.com"),
			new Ficha("user2", 38, "user2@gmail.com"),
			new Ficha("user3", 19, "user3@gmail.com"),
			new Ficha("user4", 43, "user4@gmail.com")
			));

	public boolean autenticar(String usuario, String password) {
		for (Usuario usuario2 : listUsuario) {
			if (usuario2.getUsuario().equals(usuario)&&usuario2.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
		//solucion con programacion funcional
		//return usuarios.stream()
		//		.anyMatch(u->u.getUsuario().equals(usuario)&&u.getPassword(9.equals(pwd));*/
	}
	//metodo para recibir la ficha
	public Ficha fichaUsuario(String usuario) {
		for (Ficha ficha : listFichas) {
			if (ficha.getUsuario().equals(usuario)) {
				 return new Ficha("user0", 40, "user0@gmail.com");
			}
		}
		return new Ficha("user1", 40, "user1@gmail.com");
	}
}
