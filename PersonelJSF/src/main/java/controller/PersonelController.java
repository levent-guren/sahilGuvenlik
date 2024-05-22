package controller;

import java.util.ArrayList;
import java.util.List;

import config.ModelMapperConfig;
import entity.Baskanlik;
import entity.Personel;
import exception.ServiceException;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;
import model.PersonelYaratModel;
import service.PersonelService;
import util.Util;

@Named("pc")
@RequestScoped
@Data
public class PersonelController {
	private int seciliBaskanlikId;
	private List<Personel> baskanlikPersonelleri = new ArrayList<Personel>();
	private PersonelYaratModel personelYaratModel = new PersonelYaratModel();
	@Inject
	private PersonelService personelService;

	public void getPersoneller() {
		baskanlikPersonelleri = personelService.getPersoneller(seciliBaskanlikId);
	}

	public String personelYarat() {
		Personel personel = ModelMapperConfig.getModelMapper().map(personelYaratModel, Personel.class);
		// iseGiris modelMapper tarafından aktarılmıyor.
		personel.setIseGiris(Util.asDate(personelYaratModel.getIseGirisTarihi()));
		Baskanlik baskanlik = new Baskanlik();
		baskanlik.setId(personelYaratModel.getBaskanlikId());
		personel.setBaskanlik(baskanlik);
		try {
			personelService.personelKaydet(personel);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Personel Oluşturuldu"));
			return "index";
		} catch (ServiceException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
			return null;
		}
	}

}
