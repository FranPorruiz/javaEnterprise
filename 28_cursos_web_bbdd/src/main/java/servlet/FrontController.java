package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UsuariosService;

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
					case "doNuevo": 
						request.getRequestDispatcher("GuardarController").include(request, response);
						urlView="menu.html";
						break;
					
					//nos lanza al servlet BuscarController y luego nos redirige al Resultados
					case "doBuscar":
						request.getRequestDispatcher("BuscarController").include(request, response);
						urlView="cursos.jsp";
						break;
						
					//nos lanza al servlet Eliminar y luego nos redirige al Resultados
					case "doEliminar":
						request.getRequestDispatcher("EliminarController").include(request, response);
						urlView="eliminar.html";
						break;	
						
					case "doModificarDuracion":
						request.getRequestDispatcher("ModificarController").include(request, response);
						urlView="menu.html";
						break;		
					
						//nos lanza al servlet Eliminar y luego nos redirige al Resultados
					case "doLogin":
						request.getRequestDispatcher("LoginController").include(request, response);
						boolean valido=(boolean) request.getAttribute("Valido");
						if(valido){
							urlView="menu.html";	 
			
						}else {
							urlView="erroneo.jsp";
						}
						break;	
					
					//Estos casos nos derivan a diferentes html	
					case "toNuevo":
						urlView="nuevo.html";
						break;	
					
					case "toBuscar":
						urlView="buscarPorPrecio.html";
						break;	
						
					case "toEliminar":
						urlView="eliminar.html";
						break;	
					case "toModificarPrecio":
						urlView="modificarDuracion.html";
						break;		
						
					case "toInicio":
						urlView="menu.html";
						break;		
						
				}
				//al haber pasado por el swtich, el urviewe ya tiene el valor:
				//asi que ahora le decimos que nos redirige
				request.getRequestDispatcher(urlView).forward(request, response);
	}
}


