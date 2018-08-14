package logdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private ShardedJedisPool shardedJedisPool;

    private JedisPool jedisPool;

    private JedisPoolConfig jedisPoolConfig;

    @Autowired //为啥把注入放到构造器上可以成功注入 放入到方法上就不行?
    public RedisController(ShardedJedisPool shardedJedisPool, JedisPool jedisPool, JedisPoolConfig jedisPoolConfig) {
        this.shardedJedisPool = shardedJedisPool;
        this.jedisPool = jedisPool;
        this.jedisPoolConfig = jedisPoolConfig;
    }

    @RequestMapping("/get")
    public String get() {
        return jedisPool.getResource().get("test");
    }

    @RequestMapping("/get2")
    public String get2() {
        return shardedJedisPool.getResource().get("test");
    }

    @RequestMapping("/set")
    public String set() {
        return jedisPool.getResource().set("test", "abcde");
    }

    @RequestMapping("/config")
    public JedisPoolConfig config() {
        return jedisPoolConfig;
    }

    @RequestMapping("/pool")
    @Autowired
    public JedisPool pool() {
        return jedisPool;
    }
}
