package service;

import java.util.List;

import dao.PersonelDAO;
import entity.Personel;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class PersonelService {
//	@Inject
//	private BaskanlikDAO baskanlikDAO;
	@Inject
	private PersonelDAO personelDAO;

	// @Transactional
	public List<Personel> getPersoneller(int baskanlikId) {
//		Baskanlik baskanlik = baskanlikDAO.getBaskanlik(baskanlikId);
//		baskanlik.getPersoneller().forEach(p -> {
//		});
//		return baskanlik.getPersoneller();
		return personelDAO.getPersoneller(baskanlikId);
	}
}
