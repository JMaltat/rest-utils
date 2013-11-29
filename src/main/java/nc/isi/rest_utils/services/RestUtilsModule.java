package nc.isi.rest_utils.services;

import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.ServiceBinder;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.joda.JodaModule;

public class RestUtilsModule {

	public static void bind(ServiceBinder binder) {
		binder.bind(ObjectMapperProvider.class, ObjectMapperProviderImpl.class);
	}

	public static void contributeResteasyPackageManager(
			Configuration<String> configuration) {
		configuration.add("nc.isi.rest_utils.rest");
	}

	public static void contributeObjectMapperProvider(
			Configuration<Module> configuration) {
		configuration.add(new JodaModule());
	}

}
