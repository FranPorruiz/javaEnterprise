package service;

import java.util.List;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.Producto;

public class ProductosService {
	
	//Con el Entity manager Factory creamos una factoria, que nos permite crear otros objetos
	
	0
	
	public void agregarProducto(String nombreProducto, String categoriaProducto, double precioProducto) {
		//le ponemos un valor 0 pero da igual, porque el motor de persistencia no lo va a usar
		Producto pr=new Producto(0, nombreProducto,categoriaProducto, precioProducto);
		
		EntityManager em=getEntityManager(); //creamos el objeto EM
		//creamos una transaccion que es lo que envia la informacion
		EntityTransaction tx=em.getTransaction();
		tx.begin();//la iniciamos
		em.persist(pr);//con esta funcion le decimos que lo inserte en la BBDD
		tx.commit();
		
	}
	
	public Producto buscarProducto(int idProducto) {
		//el motor de persistencia busca primero el elemento y luego la clave primaria
		//aqui no es necesario abrir y cerrrar la transaccian porque es un select
		return getEntityManager().find(Producto.class, idProducto);	 
	}
	
	public void EliminarProducto(int idProducto) {
		//buscamos el producto
		Producto pr=buscarProducto(idProducto);
		//si existe lo borramos 
		if(pr!=null) {
			EntityManager em=getEntityManager(); //creamos el objeto EM
			//creamos una transaccion que es lo que envia la informacion
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.remove(pr);
			tx.commit();

		}
		
	}
	
	public List<Producto> buscarPorCategoria(String nombreCategoria){
		//=? es para incluir parametros en la consulta por posicion
		String jpql="Select p from Producto p where p.categoria=?1";
		//otra opcion
		//String jpql="Select p from Producto p where p.categoria='"+nombreCategoria+"'";
		//consulta por string
		//String jpql="Select p from Producto p where p.categoria=cat";
		//query.setParameter("cat", categoria)
		//creamos la query y le decimos que va a recibir una query con clases producto
		TypedQuery<Producto> query=getEntityManager().createQuery(jpql, Producto.class);
		//con esto le asignamos a la categoria  del jpql el valor
		query.setParameter(1, nombreCategoria);
		
		//esto nos devuelve una lista
		return query.getResultList();
	}
	
	public  void eliminarPorNombre(String nombreBorrado) {
		String jpql="Delete p from Producto where p.nombre=?1";
		EntityManager em=getEntityManager();//para gestionar entidades
		Query query=em.createQuery(jpql);//creamos la query con el string
		query.setParameter(1, nombreBorrado);//ponemos los parametros
		EntityTransaction tx=em.getTransaction();//iniciamos la transaccione
		tx.begin();
		query.executeUpdate();//esto nos ejecuta la query t actualiza
		tx.commit();
		
	}
	
}
