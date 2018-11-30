package io.github.chermehdi.bitly.service.producers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 * @author chermehdi
 */
public class PropsProducer {

  @Produces
  @ApplicationScoped
  public Properties getProps() throws IOException {
    InputStream is = getClass().getClassLoader().getResourceAsStream("env.properties");
    Properties props = new Properties();
    props.load(is);
    return props;
  }
}
