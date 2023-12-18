package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

//esqueleto del Servlet
public class SaludoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;//constante que genera automaticamene el programa, no lo va a usar
	
	//sobreescritura del metodo service
	//el servidor de apliaciones nos envia los dos objetos o interfaces
	//request es para cosas que nos envian
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();//esto lo que hace es quue podamos escribir en la respuesta
		response.setContentType("text/html");//esto lo que hace es generar una cabecera de respuesta que le dice al navegador que se le va a enviar
		out.println("<html><body><center>");
		for(int i=1;i<=6;i++) {
			out.println("<h"+i+">Primer servlet</h"+i+">");
		}
		out.println("</center></body></html>");

		out.close(); 
	}
}
