package dao;

import entity.Kullanici;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Named
@RequestScoped
public class KullaniciDAO {
	@PersistenceContext
	private EntityManager em;

	public Kullanici getKullanici(String tcNo) {
		return em.createQuery("from Kullanici k where k.tcNo = :tcNo", Kullanici.class).setParameter("tcNo", tcNo)
				.getSingleResult();
	}
}
