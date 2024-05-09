package controller;

import java.util.List;

import entity.Personel;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import lombok.Data;
import service.PersonelService;

@Named("pc")
@RequestScoped
@Data
public class PersonelController {
	private int seciliBaskanlikId;
	@Inject
	private PersonelService personelService;

	@Transactional
	public void getPersoneller() {
		List<Personel> personeller = personelService.getPersoneller(seciliBaskanlikId);
		personeller.forEach(System.out::println);
	}
}
