package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ServiceProductos;

import java.io.IOException;

@WebServlet("/BorrarController")
public class BorrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String borrar=request.getParameter("nombre");
		ServiceProductos sp=new ServiceProductos();
		sp.borrarProducto(borrar);
		//request.getRequestDispatcher("Home.html").forward(request, response);
		//esta linea desaparece porque lo va hacer el front controller

	}
	}


