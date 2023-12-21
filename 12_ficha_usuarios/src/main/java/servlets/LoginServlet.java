package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Ficha;
import service.UsuariosService;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creamos una istancia del usuario service
		UsuariosService service=new UsuariosService();
		
		
		//recibimos y verificamos el usuario
		if(service.autenticar(request.getParameter("usuario"), request.getParameter("password"))){
			//buscamos la ficha
			Ficha ficha=service.fichaUsuario("usuario");
			//guardamos la ficha en un atributo 
			request.setAttribute("ficha", ficha);
			//si es correcto transferimos la petición a correcto.jsp
			request.getRequestDispatcher("correcto.jsp").forward(request, response);
		}else {
			//en caso contrario lo pasamos a erroneo.jsp
			request.getRequestDispatcher("erroneo.jsp").forward(request, response);
		}

	}

}
