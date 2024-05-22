package service;

import dao.KullaniciDAO;
import entity.Kullanici;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import util.Security;

@Named
@RequestScoped
public class KullaniciService {
	@Inject
	private KullaniciDAO kullaniciDAO;

	@Transactional
	public Kullanici getKullanici(String tcNo, String sifre) {
		Kullanici kullanici = kullaniciDAO.getKullanici(tcNo);
		if (kullanici != null && Security.isPasswordValid(sifre, kullanici.getSifre())) {
			// Kullanıcının yetkilerini dolduruyoruz.
			kullanici.getYetkiler().forEach(y -> {
			});
		}
		return kullanici;
	}
}
