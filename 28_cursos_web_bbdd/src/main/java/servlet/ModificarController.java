package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CursosService;

import java.io.IOException;

@WebServlet("/ModificarController")

public class ModificarController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursosService service=new CursosService();
		service.modificarDuracion(request.getParameter("nombre"), Integer.parseInt(request.getParameter("duracion")));
		
	}

}
