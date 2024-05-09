package config;

import org.modelmapper.ModelMapper;

public class ModelMapperConfig {
	private static ModelMapper modelMapper = new ModelMapper();

	public static ModelMapper getModelMapper() {
		return modelMapper;
	}
}
