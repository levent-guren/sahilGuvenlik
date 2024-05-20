package service;

import java.util.List;

import dao.BaskanlikDAO;
import entity.Baskanlik;
import entity.Personel;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

@Named
@RequestScoped
public class PersonelService {
	@Inject
	private BaskanlikDAO baskanlikDAO;

	@Transactional
	public List<Personel> getPersoneller(int baskanlikId) {
		Baskanlik baskanlik = baskanlikDAO.getBaskanlik(baskanlikId);
		return baskanlik.getPersoneller();
	}
}
