package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import service.ProductosService;

import java.io.IOException;

@WebServlet("/buscarProductoController")
public class buscarProductoController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idProducto=Integer.parseInt(request.getParameter("idProducto"));
		ProductosService ps=new ProductosService();
		Producto productoBuscado=ps.buscarProducto(idProducto);
		request.setAttribute("producto", productoBuscado);
		
	}

}
