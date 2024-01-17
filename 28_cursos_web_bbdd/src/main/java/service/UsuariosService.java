package service;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Curso;
import model.Usuario;

public class UsuariosService {
	
	//Con el Entity manager Factory creamos una factoria, que nos permite crear otros objetos
	private EntityManager getEntityManager() {
			//el objeto persistence esta definido en el persistence.xml
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("escuela");
			return factory.createEntityManager();
		}
	///metodo de login
	public boolean autenticar(String usuarioNombre, String password) {
		String jpql="Select u from Usuario u where (u.usuario=?1) AND (u.password=?2)";
		TypedQuery<Usuario> query=getEntityManager().createQuery(jpql, Usuario.class);//esto nos permite pasar la query
		query.setParameter(1, usuarioNombre);//le pasamos el precioMax, le decimos que 1 es el precioMaximo
		query.setParameter(2, password);//le pasamos el precioMax, le decimos que 1 es el precioMaximo
		/*
		 *
		List<Usuario> usuarios=query.getResultList();	
		if(usuarios.size()==0) {
			return false;
		}
		else {
			return true;
		}
		*/
		
		//version mas sencilla de lo superior
		return query.getResultList().size()!=0;
		
	}
}
