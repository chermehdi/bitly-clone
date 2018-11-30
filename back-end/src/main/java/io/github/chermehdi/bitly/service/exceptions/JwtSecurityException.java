package io.github.chermehdi.bitly.service.exceptions;

/**
 * @author chermehdi
 */
public class JwtSecurityException extends RuntimeException {

  public JwtSecurityException(Exception ex) {
    super(ex);
  }

  public JwtSecurityException(String message) {
    super(message);
  }

}
