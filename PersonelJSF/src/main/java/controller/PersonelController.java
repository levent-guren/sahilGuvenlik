package controller;

import java.util.ArrayList;
import java.util.List;

import entity.Personel;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;
import service.PersonelService;

@Named("pc")
@RequestScoped
@Data
public class PersonelController {
	private int seciliBaskanlikId;
	private List<Personel> baskanlikPersonelleri = new ArrayList<Personel>();

	@Inject
	private PersonelService personelService;

	public void getPersoneller() {
		baskanlikPersonelleri = personelService.getPersoneller(seciliBaskanlikId);
	}
}
