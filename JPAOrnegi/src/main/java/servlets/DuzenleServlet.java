package servlets;

import java.io.IOException;

import entity.Personel;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.PersonelService;

@WebServlet("/duzenle")
public class DuzenleServlet extends HttpServlet {
	private static final long serialVersionUID = -9188884032662842392L;
	@Inject
	private PersonelService personelService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Personel personel = personelService.getPersonel(Integer.parseInt(id));
		req.setAttribute("personel", personel);
		req.getRequestDispatcher("/duzenle.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String adi = req.getParameter("adi");
		String soyadi = req.getParameter("soyadi");
		int id = Integer.parseInt(req.getParameter("id"));
		personelService.personelGuncelle(id, adi, soyadi);
		req.setAttribute("mesaj", "Personel güncellendi.");
		req.getRequestDispatcher("/liste").forward(req, resp);
	}
}
