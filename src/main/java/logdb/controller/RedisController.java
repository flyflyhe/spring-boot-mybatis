package logdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @RequestMapping("/get")
    @Autowired
    public String get(ShardedJedisPool shardedJedisPool) {
        return shardedJedisPool.getResource().get("test");
    }

    @RequestMapping("/set")
    @Autowired
    public String set(ShardedJedisPool shardedJedisPool) {
        return shardedJedisPool.getResource().set("test", "abcde");
    }

    @RequestMapping("/config")
    public JedisPoolConfig config(JedisPoolConfig jedisPoolConfig) {
        return jedisPoolConfig;
    }

    @RequestMapping("/pool")
    public ShardedJedisPool config(ShardedJedisPool shardedJedisPool) {
        return shardedJedisPool;
    }
}
