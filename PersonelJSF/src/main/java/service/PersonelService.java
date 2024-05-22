package service;

import java.util.List;

import dao.PersonelDAO;
import entity.Personel;
import exception.ServiceException;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

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

	@Transactional
	public void personelKaydet(Personel personel) throws ServiceException {
		// aynı T.C. Kimlik numarasına sahip personel var mı?
		if (personelDAO.getPersonelSayisiByTCNo(personel.getTcKimlikNo()) != 0) {
			// aynı T.C. Kimlik numarasına sahip personel var
			throw new ServiceException("Aynı T.C. Kimlik numarasına sahip personel var");
		}
		personelDAO.personelKaydet(personel);
	}
}
