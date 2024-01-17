package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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
			case "doAlta": 
				request.getRequestDispatcher("AnadirController").include(request, response);
				urlView="Home.html";
				break;
			
			//nos lanza al servlet BuscarController y luego nos redirige al Resultados
			case "doBuscar":
				request.getRequestDispatcher("BuscarController").include(request, response);
				urlView="Resultados.jsp";
				break;
				
			//nos lanza al servlet Eliminar y luego nos redirige al Resultados
			case "doEliminar":
				request.getRequestDispatcher("BorrarController").include(request, response);
				urlView="Home.html";
				break;	
			
			//Estos casos nos derivan a diferentes html	
			case "toNuevo":
				urlView="nuevoproducto.html";
				break;	
			
			case "toBuscar":
				urlView="buscador.html";
				break;	
				
			case "toEliminar":
				urlView="eliminar.html";
				break;	
				
			case "toInicio":
				urlView="Home.html";
				break;		
				
		}
		//al haber pasado por el swtich, el urviewe ya tiene el valor:
		//asi que ahora le decimos que nos redirige
		request.getRequestDispatcher(urlView).forward(request, response);
	}
}
