package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Producto;

import java.io.IOException;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

@WebServlet("/BorrarServlet")
public class BorrarServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String nombre=request.getParameter("nombre");
		List<Producto> listaProducto=(List<Producto>) session.getAttribute("listaProducto");
		listaProducto.removeIf(p -> (p.getNombre().equals(nombre)));
		//session.setAttribute("listaProducto", listaProducto); no hace falta añadir esta linea porque el if esta apuntando al mismo objeto
		request.getRequestDispatcher("Carrito.jsp").forward(request, response);
	
	}

}
