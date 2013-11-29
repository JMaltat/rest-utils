package nc.isi.rest_utils.rest;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 * Renvoie les réponses aux requêtes CORS pour les options ==> utiliser
 * seulement en phase de dev/test
 * 
 * @author jmaltat
 * 
 */
@Path("{path : .*}")
public class OptionsCORSResponse {

	@OPTIONS
	public Response handleCORSRequest(
			@HeaderParam("Access-Control-Request-Method") final String requestMethod,
			@HeaderParam("Access-Control-Request-Headers") final String requestHeaders) {
		final ResponseBuilder retValue = Response.ok();

		if (requestHeaders != null) {
			retValue.header("Access-Control-Allow-Headers", requestHeaders);
		}

		if (requestMethod != null) {
			retValue.header("Access-Control-Allow-Methods", requestMethod);
		}

		retValue.header("Access-Control-Allow-Origin", "*");

		return retValue.build();
	}

}
