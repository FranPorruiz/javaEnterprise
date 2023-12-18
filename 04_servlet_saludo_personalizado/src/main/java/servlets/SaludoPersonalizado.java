package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SaludoPersonalizado extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recogemos la informacion que recibimos del html con request
		//con el nombre que le pusimos a esa etiqueta
		String nombre=request.getParameter("nombre");
		
		PrintWriter out=response.getWriter();//esto lo que hace es quue podamos escribir en la respuesta
		response.setContentType("text/html");//esto lo que hace es generar una cabecera de respuesta que le dice al navegador que se le va a enviar
		out.println("<html><body><center>");
		//la variable se usa aqui abajo
		for(int i=1;i<=6;i++) {
			out.println("<h"+i+"> hola "+nombre+"</h"+i+">");
		}
		out.println("</center></body></html>");

		out.close(); 
	}
	}


