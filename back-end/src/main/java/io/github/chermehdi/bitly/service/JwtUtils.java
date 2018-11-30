package io.github.chermehdi.bitly.service;

import io.github.chermehdi.bitly.domain.Role;
import io.github.chermehdi.bitly.domain.User;
import io.github.chermehdi.bitly.service.exceptions.JwtSecurityException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chermehdi
 */
public final class JwtUtils {

  private static final Key signingKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

  private static final long DEFAULT_EXPIRATION = 24L * 60L * 60L * 3L; // 3 days

  public static String createToken(User user, long expired) {
    Date expirationDate = Date
        .from(LocalDateTime.now().plusSeconds(expired).atZone(ZoneId.systemDefault()).toInstant());
    return Jwts.builder()
        .setSubject(user.getEmail())
        .claim("roles", String.join(",", user.getRoles()
            .stream()
            .map(Role::getName)
            .collect(Collectors.joining(","))))
        .signWith(signingKey)
        .setExpiration(expirationDate)
        .compact();
  }

  public static String createToken(User user) {
    return createToken(user, DEFAULT_EXPIRATION);
  }

  public static Set<Role> validateToken(String token) {
    try {
      Claims claims = Jwts.parser()
          .setSigningKey(signingKey)
          .parseClaimsJws(token)
          .getBody();
      System.out.println("the roles set " + claims);
      Set<Role> roles = Arrays.stream(((String) claims.get("roles")).split(","))
          .map(Role::new)
          .collect(Collectors.toSet());
      Jwts.parser()
          .requireSubject(claims.getSubject())
          .setSigningKey(signingKey)
          .parseClaimsJws(token);
      return roles;
    } catch (Exception ex) {
      throw new JwtSecurityException(ex);
    }
  }
}
