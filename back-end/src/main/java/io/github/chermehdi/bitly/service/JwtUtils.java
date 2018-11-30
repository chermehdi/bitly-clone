package io.github.chermehdi.bitly.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author chermehdi
 */
public final class JwtUtils {

  private static final Key signingKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

  private static final long DEFAULT_EXPIRATION = 24L * 60L * 60L * 3L; // 3 days

  public static String createToken(String username, String role, long expired) {
    Date expirationDate = Date
        .from(LocalDateTime.now().plusSeconds(expired).atZone(ZoneId.systemDefault()).toInstant());
    return Jwts.builder()
        .setSubject(username)
        .claim("role", role)
        .signWith(signingKey)
        .setExpiration(expirationDate)
        .compact();
  }

  public static String createToken(String username, String role) {
    Date expirationDate = Date
        .from(LocalDateTime.now().plusSeconds(DEFAULT_EXPIRATION).atZone(ZoneId.systemDefault())
            .toInstant());
    return Jwts.builder()
        .setSubject(username)
        .claim("role", role)
        .signWith(signingKey)
        .setExpiration(expirationDate)
        .compact();
  }

  public static String validateToken(String token) {
    Claims claims = Jwts.parser()
        .setSigningKey(signingKey)
        .parseClaimsJws(token)
        .getBody();
    String role = null;
    role = claims.get("role").toString();
    Jwts.parser()
        .requireSubject(claims.getSubject())
        .setSigningKey(signingKey)
        .parseClaimsJws(token);
    return role;
  }

}
