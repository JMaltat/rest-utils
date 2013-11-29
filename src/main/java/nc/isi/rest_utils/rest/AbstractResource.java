package nc.isi.rest_utils.rest;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import nc.isi.rest_utils.CharsetHeaders;
import nc.isi.slq2o_dao.daos.Dao;
import nc.isi.slq2o_dao.entities.Entity;

/**
 * Classe abstraite de définition minimale d'une ressource
 * 
 * @author jmaltat
 * 
 */
public abstract class AbstractResource<T extends Entity> {
	protected final Dao<T> dao;

	protected AbstractResource(Dao<T> dao) {
		this.dao = dao;
	}

	protected Response corResponse(ResponseBuilder response) {
		response.header("Access-Control-Allow-Origin", "*");
		return response.build();
	}

	/**
	 * 
	 * @return {@link Collection} {@link ActivitePoste}
	 * 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";" + CharsetHeaders.UTF_8)
	public Collection<T> getAll() {
		return dao.getAll();
	}

	/**
	 * 
	 * @param id
	 *            : l'id de l'activité poste
	 * @return l'activité poste correspondante
	 * @throws Exception
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";" + CharsetHeaders.UTF_8)
	public T getById(@PathParam("id") String id) throws Exception {
		return dao.get(id);
	}

	/**
	 * 
	 * @param entity
	 *            l'objet à insérer dans la base
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void post(T entity) {
		dao.insert(entity);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(T entity) {
		dao.delete(entity);
	}

}