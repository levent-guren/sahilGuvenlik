package controller;

import java.util.List;

import config.ModelMapperConfig;
import entity.Baskanlik;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;
import model.BaskanlikModel;
import service.BaskanlikService;

@Named("bc")
@RequestScoped
@Data
public class BaskanlikController {
	BaskanlikModel baskanlikModel = new BaskanlikModel();

	@Inject
	private BaskanlikService baskanlikService;

	public String baskanlikYarat() {
		try {
			Baskanlik baskanlik = ModelMapperConfig.getModelMapper().map(baskanlikModel, Baskanlik.class);
			baskanlikService.baskanlikEkle(baskanlik);
			return "basarili";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<BaskanlikModel> getTumBaskanliklar() {
		List<Baskanlik> baskanliklar = baskanlikService.getTumBaskanliklar();
		return baskanliklar.stream().map(b -> ModelMapperConfig.getModelMapper().map(b, BaskanlikModel.class)).toList();
	}
}
