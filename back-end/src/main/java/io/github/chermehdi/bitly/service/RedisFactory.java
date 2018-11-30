package io.github.chermehdi.bitly.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author chermehdi
 */
public class RedisFactory {

  @Produces
  @ApplicationScoped
  public JedisPool createJedisPool() {
    JedisPoolConfig poolConfig = new JedisPoolConfig();
    return new JedisPool(poolConfig, "localhost");
  }
}
