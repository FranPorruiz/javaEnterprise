package intercepting;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;

public class FiltroLogin extends HttpFilter implements Filter {

	public void destroy() {
	}

	//toda llamada que se haga va a pasar por aqui
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession sesion=((HttpServletRequest)request).getSession();
		String usuario=(String)sesion.getAttribute("usuario");
		if(usuario!=null) {
			// esto nos filtra las llamada
			chain.doFilter(request, response);
		}else {
			//obtenemos la dirección de entrada y el valor del parametro que enviamos
			//String path=((HttpServletRequest)request).getServletPath();esto nos da la direccion del url
			String param=((HttpServletRequest)request).getParameter("operation");
			//si el parametro no es null es dologin nos hace fltro
			if(param!=null&&param.equals("doLogin")) {
				
				chain.doFilter(request, response);
				return;
			}else {
			request.getRequestDispatcher("Inicio.html").forward(request, response);
			}
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
