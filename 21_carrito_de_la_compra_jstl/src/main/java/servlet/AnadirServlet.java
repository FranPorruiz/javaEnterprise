package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Producto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AnadirServlet")
public class AnadirServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//le pedimos la HPSession al servidor
		HttpSession session=request.getSession();
		List<Producto> listaProducto=new ArrayList<Producto>();
		if(session.getAttribute("listaProducto")!=null) {
			listaProducto=(List<Producto>)session.getAttribute("listaProducto");
		}

		String nombre=request.getParameter("nombre");
		Double precio=Double.parseDouble(request.getParameter("precio"));
		String categoria=request.getParameter("categoria");
		Producto nuevoProducto=new Producto(nombre, precio, categoria);
		listaProducto.add(nuevoProducto);
		session.setAttribute("listaProducto", listaProducto);
		request.getRequestDispatcher("Inicio.html").forward(request, response);
		
	}

}
