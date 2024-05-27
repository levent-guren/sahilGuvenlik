package filter;

import java.io.IOException;
import java.util.List;

import jakarta.faces.application.ResourceHandler;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class LoginFilter implements Filter {
	List<String> allowedUrl = List.of("/index.");

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		if (req.getRequestURI().startsWith(req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER)) {
			chain.doFilter(request, response); // jsf ile ilgili bir istek. Engelleme
			return;
		}

		if (allowedUrl.contains(req.getServletPath())) {
			chain.doFilter(request, response); // izin verilen sayfalara istek var. Engelleme
			return;
		}

		if (req.getSession().getAttribute("login") == null) {
			// login olunmadıysa engelle
			chain.doFilter(request, response);
			// req.getRequestDispatcher("/index.xhtml").forward(request, response);
			return;
		}

		// Diğer istekleri engelleme
		chain.doFilter(request, response);
	}
}
