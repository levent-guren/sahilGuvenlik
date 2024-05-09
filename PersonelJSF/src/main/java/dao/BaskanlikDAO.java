package dao;

import java.util.List;

import entity.Baskanlik;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Named
@RequestScoped
public class BaskanlikDAO {
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void baskanlikEkle(Baskanlik baskanlik) {
		em.persist(baskanlik);
	}

	public List<Baskanlik> getTumBaskanliklar() {
		return em.createQuery("from Baskanlik", Baskanlik.class).getResultList();
	}

	public Baskanlik getBaskanlik(int baskanlikId) {
		return em.find(Baskanlik.class, baskanlikId);
	}
}
