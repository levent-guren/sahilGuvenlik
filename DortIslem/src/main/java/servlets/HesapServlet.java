package servlets;

import java.io.IOException;

import beans.Islem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.HesapService;

@WebServlet("/hesapla")
public class HesapServlet extends HttpServlet {
	private static final long serialVersionUID = -4534795102540818184L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int sayi1 = Integer.parseInt(req.getParameter("sayi1"));
		int sayi2 = Integer.parseInt(req.getParameter("sayi2"));
		Islem islem = Islem.BOL;
		if (req.getParameter("topla") != null) {
			islem = Islem.TOPLA;
		} else if (req.getParameter("cikar") != null) {
			islem = Islem.CIKAR;
		} else if (req.getParameter("carp") != null) {
			islem = Islem.CARP;
		}
		HesapService service = new HesapService();
		int sonuc = service.hesapla(sayi1, sayi2, islem);
		req.setAttribute("sonuc", sonuc);
		req.getRequestDispatcher("sonuc.jsp").forward(req, resp);
	}
}
