package service;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.Curso;

public class CursosService {
	//declaracion de atributos
	private EntityManager getEntityManager() {
		//el objeto persistence esta definido en el persistence.xml
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("escuela");
		return factory.createEntityManager();
		}	
	//1- añadir curso nuevo, debe asegurarnos que no se repite el nombre
	//solo se añadira si no existe, si existe no se añade y se devuelve false

	public boolean nueva(String nombre, int duracion, double precio) {
		
		//comprobamos is no existe 
		if(buscarCurso(nombre)== null) {
			Curso nuevoCurso=new Curso(0, nombre, duracion, precio);
			EntityManager em=getEntityManager(); //creamos el objeto EM
			//creamos una transaccion que es lo que envia la informacion
			EntityTransaction tx=em.getTransaction();
			tx.begin();//la iniciamos
			em.persist(nuevoCurso);//con esta funcion le decimos que lo inserte en la BBDD
			tx.commit();	
			return true;
		}
		return false;
	}
	
	//2-Pide el precio maximo y muestra una lista de los cursos
	public  List<Curso> preciosCursoMax(double precioMax) {
		//esta cuaria es para que nos de los objetos del listaod curso  
		String jpql="Select c from Curso c where c.precio<=?1 order BY c.precio DESC";
		TypedQuery<Curso> query=getEntityManager().createQuery(jpql, Curso.class);//esto nos permite pasar la query
		query.setParameter(1, precioMax);//le pasamos el precioMax, le decimos que 1 es el precioMaximo
		//devolvemos ellistauxiliar
		return query.getResultList();
	}
	
	//3-Pide el nombre del curso y lo elimina
	public void eliminarCurso(String  nombre) {
		
		 String jpql="delete from Curso c where c.nombre=?1";
		 EntityManager em =getEntityManager();
		 Query query=em.createQuery(jpql);
		 query.setParameter(1, nombre);
		 EntityTransaction tx=em.getTransaction();
		 tx.begin();
		 query.executeUpdate();
		 tx.commit();
		 
		 
		//buscamos el producto
				//Curso cur=buscarCurso(nombre);
				//si existe lo borramos 
		/*
		if(buscarCurso(nombre)!= null) {
			EntityManager em=getEntityManager(); //creamos el objeto EM
			//creamos una transaccion que es lo que envia la informacion
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.remove(buscarCurso(nombre));
			tx.commit();
			}
			*/
		
	}
	
	private Curso buscarCurso(String nombre) {
		//find solo sirve para , PK hay que buscar una opcion parra buscar por nombre
		//es nombre, porque asi lo hemos  llamado en la declaracion d ela entidad
		String jpql="Select c from Curso c where c.nombre=?1";
		//otra opcion
		TypedQuery<Curso> query=getEntityManager().createQuery(jpql, Curso.class);//esto nos permite pasar la query
		query.setParameter(1, nombre);//le pasamos el precioMax, le decimos que 1 es el precioMaximo
		//devolvemos una clase
		//si esto no da resultado  o da más de uno te devuelve una excepcion
		//asi que devolvemos un null
		try {
			return query.getSingleResult();
		}catch(NoResultException ex) {
			return null;
		}		
	}
	
	//4-Modifica la duracion de uno de ellos
	public void modificarDuracion(String nombre, int nuevaDuracion) {
		String jpql="update Curso c set c.duracion=?1 where c.nombre=?2";
		EntityManager em=getEntityManager(); //creamos el objeto EM
		Query query=em.createQuery(jpql);//esto nos permite pasar la query
		//creamos una transaccion que es lo que envia la informacion
		query.setParameter(1, nuevaDuracion);
		query.setParameter(2, nombre);
		
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		query.executeUpdate(); //actualizacion de 
		tx.commit();
		}
	
}	
