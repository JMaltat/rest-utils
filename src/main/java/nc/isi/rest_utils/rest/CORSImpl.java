package nc.isi.rest_utils.rest;


import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.spi.interception.MessageBodyWriterContext;
import org.jboss.resteasy.spi.interception.MessageBodyWriterInterceptor;

/**
 * Implémentation d'un système pour autoriser les requêtes CORS => Seulement
 * utile en dev
 * 
 * @author jmaltat
 * 
 */
@Provider
@ServerInterceptor
public class CORSImpl implements MessageBodyWriterInterceptor {

	@Override
	public void write(MessageBodyWriterContext context) throws IOException,
			WebApplicationException {
		context.getHeaders().add("Access-Control-Allow-Origin", "*");
		context.proceed();
	}

}
