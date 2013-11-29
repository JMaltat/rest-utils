package nc.isi.rest_utils.services;

import java.util.Collection;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperProviderImpl implements ObjectMapperProvider {
	private final ObjectMapper mapper;

	public ObjectMapperProviderImpl(Collection<Module> modules) {
		mapper = new ObjectMapper();
		for (Module module : modules) {
			mapper.registerModule(module);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nc.isi.services.geojson.ObjectMapperProvider#provide()
	 */
	@Override
	public ObjectMapper provide() {
		return mapper;
	}

}
