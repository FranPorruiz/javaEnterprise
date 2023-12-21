package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Pagina;
import service.BuscadorService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
//esto se pone si hay problemos con la llamada desde HTML
@WebServlet("/BuscadorServlet")
public class BuscadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String busqueda=request.getParameter("busqueda");
		BuscadorService bs=new BuscadorService();
		List<Pagina> resultado=bs.buscar(busqueda);
		//guardamos los resultados
		request.setAttribute("resultados", resultado);	
		//transferimos el control y le enviamos el envio, respuest
		request.getRequestDispatcher("Resultados.jsp").forward(request, response);
		
		
 }

}
