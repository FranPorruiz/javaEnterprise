package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UsuariosService;

import java.io.IOException;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuariosService service=new UsuariosService();
		if(service.autenticar(request.getParameter("usuario"), request.getParameter("password"))){
			request.setAttribute("Valido", true);
			 
		}else {
			request.setAttribute("Valido", false);
		}
		
		//otra forma mas simple es simplemente enviarle el true o false
		//request.setAttribute(request.getParameter("usuario"), request.getParameter("password"));
		

	}

	private void generarCookis(HttpServletResponse response, HttpServletRequest request) {
		Cookie ck=new Cookie("usuario", request.getParameter("usuario"));
		ck.setMaxAge(200_000);
		response.addCookie(ck);
		
	}

}


