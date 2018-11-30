package io.github.chermehdi.bitly.web.filters;

import io.github.chermehdi.bitly.web.support.Secured;
import java.io.IOException;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

/**
 * @author chermehdi
 */
@Provider
@Secured
@Priority(Priorities.AUTHENTICATION)
public class SecurityFilter implements ContainerRequestFilter {

  @Override
  public void filter(ContainerRequestContext containerRequestContext) throws IOException {
  }
}
