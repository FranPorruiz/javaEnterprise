package servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/ContadorServlet")
public class ContadorServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pedimos HHpSession al servidor de aplicaciones y hacemos un ServletContext
		HttpSession session=request.getSession();
		//creacion del servlet context
		ServletContext context=request.getServletContext();
		//recuperamos el contador, le sumamos 1 y lo volvemos a guardar
		//comprobamos que sea distinto de null lo cogemos , por si acaso lo 
		//creamos a cero
		int actual=0;
		int global=0;//contador global
		if(session.getAttribute("contador")!=null){
			actual=(Integer)session.getAttribute("contador");	
		}
		if(context.getAttribute("global")!=null) {
			global=(Integer)context.getAttribute("global");
		}
		/*actual++;
		session.setAttribute("contador", actual);*/
		session.setAttribute("contador", ++actual);//con esto añadimos 1 a la variable
		context.setAttribute("global", ++global);//con esto añadimos 1 a la variable global
		
		
		//metododo para generar cookie, le pasamos el objeto response
		generarCookie(response);
		
		//transferimos la peticion a la jsp
		request.getRequestDispatcher("resultado.jsp").forward(request, response);
	
	}
	//creamos las cookie cpon fecha y hora actuales y las enviamos al cliente
	private void generarCookie(HttpServletResponse response) {
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy-hh:mm:ss");
		//le pasamos la fecha de hoy con el formato arriba indicado
		Cookie ck=new Cookie("fecha", LocalDateTime.now().format(formatter));
		ck.setMaxAge(100_000);//el guiom bajo es para separara las cifras en lugar de puntos
		response.addCookie(ck);
		
		
		
		
		
	}

}
