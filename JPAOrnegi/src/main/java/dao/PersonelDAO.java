package dao;

import java.util.List;

import entity.Personel;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Named
@RequestScoped
public class PersonelDAO {
	@PersistenceContext
	private EntityManager em;

	public List<Personel> getTumPersoneller() {
		List<Personel> personeller = em.createQuery("select p from Personel p", Personel.class).getResultList();
		return personeller;
	}

	public Personel getPersonel(int id) {
		Personel personel = em.find(Personel.class, id);
		return personel;
	}

	@Transactional
	public void personelGuncelle(Personel personel) {
		em.merge(personel);
	}
}
