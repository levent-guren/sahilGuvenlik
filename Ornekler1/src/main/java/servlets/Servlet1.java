package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ornek")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 4140253942988217802L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Servlet Context= " + request.getServletContext());
		out.println("Servlet Path= " + request.getServletPath());
		Enumeration<String> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String paramName = params.nextElement();
			out.println("Parameter Name= " + paramName + " Value= " + request.getParameter(paramName));
		}
	}

}
