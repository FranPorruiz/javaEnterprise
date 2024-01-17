package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recogemos el parametro que recibiremos por parte del cliente
		String op=request.getParameter("operation");
		String urlView="";
		//switch para ver que hace el front controller
		switch (op) {
			//nos lanza al servlet AnadirController y luego nos redirige al home
			//es un include en vez de un 
			//Alta, buscar por id, buscar por categoria, eliminar
			case "doAlta": 
				request.getRequestDispatcher("AnadirController").include(request, response);
				urlView="Home.html";
				break;
			
			//Estos casos nos derivan a diferentes html	
			case "toNuevo":
				urlView="nuevoproducto.html";
				break;	
				
			case "toInicio":
				urlView="Home.html";
				break;
				
			case "doBuscar":
				request.getRequestDispatcher("buscarProductoController").include(request, response);
				urlView="resultados.jsp";
				break;
				
			case "doBuscarPorCategoria":
				request.getRequestDispatcher("BuscarPorCategoriaController").include(request, response);
				urlView="resultados.jsp";
				break;	
				
			case "toBuscar":
				urlView="buscador.html";
				break;	
				
			case "toBuscarProducto":
				urlView="buscarProducto.html";
				break;
				
			case "doBorrar":
				request.getRequestDispatcher("BorrarController").include(request, response);
				urlView="eliminar.html";
				break;	
				
				
				
		}
		//al haber pasado por el swtich, el urviewe ya tiene el valor:
		//asi que ahora le decimos que nos redirige
		request.getRequestDispatcher(urlView).forward(request, response);
	}
}
