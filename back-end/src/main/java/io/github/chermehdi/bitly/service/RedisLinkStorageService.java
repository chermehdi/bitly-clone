package io.github.chermehdi.bitly.service;

import javax.inject.Inject;
import redis.clients.jedis.JedisPool;

/**
 * @author chermehdi
 */
public class RedisLinkStorageService implements LinkStorageService {

  @Inject
  JedisPool jedisPool;
}
