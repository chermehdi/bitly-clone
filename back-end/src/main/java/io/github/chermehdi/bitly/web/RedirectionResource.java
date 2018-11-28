package io.github.chermehdi.bitly.web;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

/**
 * @author chermehdi
 */
@Path("/")
public class RedirectionResource {

  @GET
  public void redirect(@QueryParam("to") String to, @Context HttpServletResponse response)
      throws IOException {
    System.out.println("redirecting to " + to);
    response.sendRedirect("http://google.com");
  }
}
