package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Curso;
import service.CursosService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/BuscarController")
public class BuscarController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		//llammos al metodo service para que nos ejecute el añadir curso
		CursosService service=new CursosService();
		ArrayList<Curso> listaCursos=(ArrayList<Curso>) service.preciosCursoMax(Double.parseDouble(request.getParameter("precio")));
		//transferimos la peticion al jsp
		request.setAttribute("listaCursos", listaCursos);
		//request.getRequestDispatcher("cursos.jsp").forward(request, response);
	}

}
