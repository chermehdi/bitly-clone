package io.github.chermehdi.bitly.web.filters;

import io.github.chermehdi.bitly.domain.Role;
import io.github.chermehdi.bitly.service.JwtUtils;
import io.github.chermehdi.bitly.service.exceptions.JwtSecurityException;
import io.github.chermehdi.bitly.web.support.Secured;
import java.io.IOException;
import java.security.Principal;
import java.util.Set;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

/**
 * @author chermehdi
 */
@Provider
@Secured
@Priority(Priorities.AUTHENTICATION)
public class SecurityFilter implements ContainerRequestFilter {

  private static final String AUTHORIZATION_KEY = "Authorization";

  private static final String BEARER = "Bearer";

  @Override
  public void filter(ContainerRequestContext containerRequestContext) throws IOException {
    MultivaluedMap<String, String> headers = containerRequestContext.getHeaders();
    if (headers.containsKey(AUTHORIZATION_KEY)) {
      String tokenString = headers.getFirst(AUTHORIZATION_KEY);
      if (tokenString.startsWith(BEARER)) {
        String token = tokenString.substring(BEARER.length() + 1);
        try {
          Set<Role> roles = JwtUtils.validateToken(token);
          containerRequestContext.setSecurityContext(new SecurityContext() {
            @Override
            public Principal getUserPrincipal() {
              return () -> "mehdi";
            }

            @Override
            public boolean isUserInRole(String role) {
              return roles.stream()
                  .map(Role::getName)
                  .anyMatch(name -> name.equals(role));
            }

            @Override
            public boolean isSecure() {
              return true;
            }

            @Override
            public String getAuthenticationScheme() {
              return "jwt";
            }
          });
          return;
        } catch (JwtSecurityException ex) {
          abort(containerRequestContext);
        }
      } else {
        abort(containerRequestContext);
      }
    } else {
      abort(containerRequestContext);
    }
  }

  private void abort(ContainerRequestContext containerRequestContext) {
    containerRequestContext.abortWith(Response.status(Status.UNAUTHORIZED).build());
  }
}
