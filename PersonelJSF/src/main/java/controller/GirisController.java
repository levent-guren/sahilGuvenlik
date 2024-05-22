package controller;

import java.util.Map;

import entity.Kullanici;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;
import service.KullaniciService;

@Named("giris")
@RequestScoped
@Data
public class GirisController {
	@Inject
	private KullaniciService kullaniciService;
	private String tcNo;
	private String sifre;

	public String girisYap() {
		try {
			Kullanici kullanici = kullaniciService.getKullanici(tcNo, sifre);
			if (kullanici != null) {
				// giriş başarılı
				Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				sessionMap.put("login", "true");
				sessionMap.put("kullanici", kullanici);
				return "menu";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Giriş Başarısız"));
		return null;
	}
}
