package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import service.ProductosService;

import java.io.IOException;

@WebServlet("/AnadirController")
public class AnadirController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreNew=request.getParameter("nombre");
		int precioNew=Integer.parseInt(request.getParameter("precio"));
		String categoria=request.getParameter("categoria");
		ProductosService sp=new ProductosService();
		sp.agregarProducto(nombreNew, categoria, precioNew);
		//request.getRequestDispatcher("Home.html").forward(request, response);
		//esta linea desaparece porque lo va hacer el front controller
	}
}
