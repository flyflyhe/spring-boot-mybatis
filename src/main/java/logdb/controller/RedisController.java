package logdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @RequestMapping("/get")
    public String get(JedisPool jedisPool) {
        return jedisPool.getResource().get("test");
    }

    @RequestMapping("/set")
    public String set(JedisPool jedisPool) {
        return jedisPool.getResource().set("test", "abcde");
    }

    @RequestMapping("/config")
    public JedisPoolConfig config(JedisPoolConfig jedisPoolConfig) {
        return jedisPoolConfig;
    }

    @RequestMapping("/pool")
    @Autowired
    public JedisPool pool(JedisPool jedisPool) {
        return jedisPool;
    }
}
