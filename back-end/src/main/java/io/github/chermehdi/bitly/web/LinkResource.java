package io.github.chermehdi.bitly.web;

import io.github.chermehdi.bitly.domain.Link;
import io.github.chermehdi.bitly.web.support.Secured;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author chermehdi
 */
@Path("/links")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class LinkResource {

  @PersistenceContext
  EntityManager em;

  @GET
  @Secured
  public Response getAllLinks() {
    em.persist(new Link("http://google.com"));
    Link link = em.find(Link.class, 1L);
    return Response.ok(link).build();
  }

  @GET
  @Path("/one")
  public Response getOne() {
    return Response.ok(new Link("http://youtube.com")).build();
  }
}
