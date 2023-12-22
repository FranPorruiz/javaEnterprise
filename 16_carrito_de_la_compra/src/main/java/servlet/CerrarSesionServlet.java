package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CerrarSesionServlet")
public class CerrarSesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//para elminar una sesión
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//llamamos a la sesion y la cerramos con invalidae
		request.getSession().invalidate();
		request.getRequestDispatcher("Inicio.html").forward(request, response);
	}

}
