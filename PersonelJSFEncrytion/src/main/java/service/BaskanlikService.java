package service;

import java.util.List;

import dao.BaskanlikDAO;
import entity.Baskanlik;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class BaskanlikService {
	@Inject
	private BaskanlikDAO baskanlikDAO;

	public void baskanlikEkle(Baskanlik baskanlik) {
		baskanlikDAO.baskanlikEkle(baskanlik);
	}

	public List<Baskanlik> getTumBaskanliklar() {
		return baskanlikDAO.getTumBaskanliklar();
	}
}
