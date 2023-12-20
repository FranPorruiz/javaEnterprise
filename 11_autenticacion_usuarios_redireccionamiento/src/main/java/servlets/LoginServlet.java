package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UsuariosService;

import java.io.IOException;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creamos una istancia del usuario service
		UsuariosService service=new UsuariosService();
		//Vamosa  ahacer un redireccionamiento a una feb esterna
	
		
		//recibimos y verificamos el usuario
		if(service.autenticar(request.getParameter("usuario"), request.getParameter("password"))){
			//redireccion a la direccion exterior correcto.jsp
			//le pasamos el parameetro
			//los parametros se enviar con una interrogacion pegados a la web
			response.sendRedirect("correcto.jsp?usuario="+request.getParameter("usuario"));
		}else {
			//redireccion a la direcction exterior erroneo.jsp
			//le pasamos los parametros
			//el ampersand es para incluirlos
			response.sendRedirect("erroneo.jsp?usuario="+request.getParameter("usuario")+ "&password="+request.getParameter("password"));

		}
		

	}

}
