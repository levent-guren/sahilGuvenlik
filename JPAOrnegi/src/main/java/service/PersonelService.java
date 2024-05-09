package service;

import java.util.List;

import dao.PersonelDAO;
import entity.Personel;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;

@Named
@RequestScoped
@Data
public class PersonelService {
	@Inject
	private PersonelDAO personelDAO;

	public List<Personel> getTumPersoneller() {
		return personelDAO.getTumPersoneller();
	}

	public Personel getPersonel(int id) {
		return personelDAO.getPersonel(id);
	}

	public void personelGuncelle(int id, String adi, String soyadi) {
		Personel personel = personelDAO.getPersonel(id);
		personel.setAdi(adi);
		personel.setLastName(soyadi);
		personelDAO.personelGuncelle(personel);
	}
}
