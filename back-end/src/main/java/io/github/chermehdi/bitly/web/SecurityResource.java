package io.github.chermehdi.bitly.web;

import io.github.chermehdi.bitly.service.JwtUtils;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

/**
 * @author chermehdi
 */
@Path("security")
public class SecurityResource {

  @GET
  public Response get(@Context SecurityContext context) {
    return Response.ok(JwtUtils.createToken("mehdi", "ADMIN", 60 * 60 * 24)).build();
  }

  @GET
  @Path("validate")
  public Response get(@QueryParam("token") String token) {
    return Response.ok(JwtUtils.validateToken(token)).build();
  }
}
