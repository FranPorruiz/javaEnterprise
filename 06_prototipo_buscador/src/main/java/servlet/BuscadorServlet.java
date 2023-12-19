package servlet;

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
		response.setContentType("text/html");//esto lo que hace es generar una cabecera de respuesta que le dice al navegador que se le va a enviar
		PrintWriter out=response.getWriter();//esto lo que hace es quue podamos escribir en la respuesta
		out.println("<html><head><link rel='stylesheet'href='miestilo.css'>  </head><body><table border='1'");
		for (Pagina pagina : resultado) {
			out.println("<tr>");
			out.println("<td>"+pagina.getDescripcion()+"<br><a href='"+pagina.getUrl()+"'>"+pagina.getUrl()+"</td>");		
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body></html>");
		out.close();	
		
 }

}
