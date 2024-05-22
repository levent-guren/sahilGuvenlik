package config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class ModelMapperConfig {
	private static ModelMapper modelMapper = new ModelMapper();
	static {
		// map edilen sınıfların içindeki değişken isimlerinin tam olarak aynı olmasını
		// şart koşuyor. Bunu yapmazsak bir taraftaki değişkenin ismi diğer tarafın
		// değişken isminin içinde olması yetiyor.
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	public static ModelMapper getModelMapper() {
		return modelMapper;
	}
}
