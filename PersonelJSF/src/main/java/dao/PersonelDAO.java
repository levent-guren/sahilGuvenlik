package dao;

import java.util.List;

import entity.Personel;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Named
@RequestScoped
public class PersonelDAO {
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Personel> getPersoneller(int baskanlikId) {
//		TypedQuery<Personel> query = em.createQuery("from Personel p where p.baskanlik.id = :bid", Personel.class);
//		query.setParameter("bid", baskanlikId);
//		return query.getResultList();

//		CriteriaBuilder builder = em.getCriteriaBuilder();
//		CriteriaQuery<Personel> query = builder.createQuery(Personel.class);
//		Root<Personel> root = query.from(Personel.class);
//		query.select(root);
//		query.where(builder.equal(root.get("baskanlik").get("id"), baskanlikId));
//		// query.orderBy(builder.asc(root.get("ad")));
//		return em.createQuery(query).getResultList();

//		Query query = em.createNativeQuery("select * from personel where baskanlik_id = :bid");
//		query.setParameter("bid", baskanlikId);
//		List sonuc = query.getResultList();
//		sonuc.forEach(row -> {
//			Object[] rowArray = (Object[]) row;
//			System.out.println(rowArray[1]);
//		});

		Query query = em.createNativeQuery("select * from personel where baskanlik_id = :bid", Personel.class);
		query.setParameter("bid", baskanlikId);

		return query.getResultList();
	}
}
