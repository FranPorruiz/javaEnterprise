package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Curso;
import service.CursosService;

@WebServlet("/GuardarController")
public class GuardarController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session=request.getSession();
	List<Curso> listaCurso;
	
	//llammos al metodo service para que nos ejecute el añadir curso
	CursosService service=new CursosService();
	Curso nuevoCurso=service.nueva(request.getParameter("nombre"),
			Integer.parseInt(request.getParameter("duracion")),
			Double.parseDouble(request.getParameter("precio")));
	
	if(session.getAttribute("listaCursos")!=null) {
		listaCurso=(List<Curso>)session.getAttribute("listaCursos");
		listaCurso.add(nuevoCurso);

	}
	else {
		listaCurso=new ArrayList<Curso>();
		listaCurso.add(nuevoCurso);
	}
	request.setAttribute("listaCursos", listaCurso);
	//request.getRequestDispatcher("menu.html").forward(request, response);
	
	}

}
