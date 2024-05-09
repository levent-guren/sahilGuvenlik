package servlets;

import java.io.IOException;
import java.util.List;

import entity.Personel;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.PersonelService;

@WebServlet("/liste")
public class ListeServlet extends HttpServlet {
	private static final long serialVersionUID = 2727316095920821587L;
	@Inject
	private PersonelService personelService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Personel> personeller = personelService.getTumPersoneller();
		req.setAttribute("personeller", personeller);
		req.getRequestDispatcher("/liste.jsp").forward(req, resp);
	}
}
