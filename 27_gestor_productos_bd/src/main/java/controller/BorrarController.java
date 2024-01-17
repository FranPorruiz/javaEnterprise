package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductosService;

import java.io.IOException;

@WebServlet("/BorrarController")

public class BorrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String borrado=request.getParameter("nombre");
		ProductosService ps=new ProductosService();
		ps.eliminarPorNombre(borrado);
	}

}
