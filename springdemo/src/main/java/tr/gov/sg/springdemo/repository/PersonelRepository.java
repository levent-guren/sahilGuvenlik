package tr.gov.sg.springdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.gov.sg.springdemo.entity.Personel;

public interface PersonelRepository extends JpaRepository<Personel, Integer> {
	List<Personel> findByBaskanlikId(int baskanlikId);
}
