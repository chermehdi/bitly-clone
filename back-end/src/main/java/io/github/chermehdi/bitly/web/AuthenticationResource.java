package io.github.chermehdi.bitly.web;

import io.github.chermehdi.bitly.domain.User;
import io.github.chermehdi.bitly.repository.UserRepository;
import io.github.chermehdi.bitly.service.AuthenticationService;
import io.github.chermehdi.bitly.service.JwtUtils;
import io.github.chermehdi.bitly.web.support.Secured;
import io.jsonwebtoken.JwtException;
import java.util.Optional;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author chermehdi
 */
@Path("auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthenticationResource {

  @Inject
  AuthenticationService authService;

  @Inject
  UserRepository userRepository;

  @POST
  @Path("login")
  public Response login(JsonObject loginRequest) {
    String email = loginRequest.getString("email");
    String password = loginRequest.getString("password");
    Optional<User> user = authService.login(email, password);
    if (user.isPresent()) {
      String token = JwtUtils.createToken(user.get());
      JsonObject object = Json.createObjectBuilder().add("auth", true)
          .add("token", token).build();
      return Response.ok(object).build();
    }
    throw new JwtException("User not found");
  }

  @GET
  @Secured
  public Response getUser() {
    return Response.ok(userRepository.findAll()).build();
  }
}



