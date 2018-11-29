package io.github.chermehdi.bitly.web.filters;

import io.github.chermehdi.bitly.web.support.Secured;
import java.io.IOException;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

/**
 * @author chermehdi
 */
@Provider
@Priority(Priorities.AUTHENTICATION)
@Secured
public class SecurityFilter implements ContainerRequestFilter {

  @Override
  public void filter(ContainerRequestContext containerRequestContext) throws IOException {
    MultivaluedMap<String, String> headers = containerRequestContext.getHeaders();
    System.out.println("the headers " + headers);
  }
}
