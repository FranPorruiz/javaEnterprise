package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Producto;
import service.ProductosService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/BuscarPorCategoriaController")

public class BuscarPorCategoriaController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		ProductosService ps= new ProductosService();
		ArrayList<Producto> listaProductos=(ArrayList<Producto>) ps.buscarPorCategoria(request.getParameter("categoria"));
		request.setAttribute("listaProductos",listaProductos);
		
	
	
	}

}
