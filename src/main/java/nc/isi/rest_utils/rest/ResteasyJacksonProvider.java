package nc.isi.rest_utils.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import nc.isi.rest_utils.services.ObjectMapperProvider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

/**
 * Implémentation de {@link JacksonJsonProvider} permettant d'ajouter la gestion
 * des objets PostGis à {@link ObjectMapper}
 * 
 * @author jmaltat
 * 
 */
@Provider
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ResteasyJacksonProvider extends JacksonJsonProvider {
	public ResteasyJacksonProvider(ObjectMapperProvider objectMapperProvider) {
		super();

		setMapper(objectMapperProvider.provide());
	}
}
