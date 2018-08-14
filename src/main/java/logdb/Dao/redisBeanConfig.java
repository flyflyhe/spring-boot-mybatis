/*
package logdb.Dao;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.ibatis.io.Resources;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@ComponentScan("redis.clients.jedis.*")
@Configuration
public class redisBeanConfig {

    @Bean
    public JedisPoolConfig jedisPoolConfig() throws IOException{
        return new JedisPoolConfig();
    }

    @Bean
    @Primary
    public ShardedJedisPool shardedJedisPool()
        throws IOException {
        JedisPoolConfig genericObjectPoolConfig = jedisPoolConfig();
        Properties redisProd = getRedisProperties();
        List<JedisShardInfo> jedisShardInfoList = new ArrayList<>();
        String uri = redisProd.getProperty("redis.uri");

        JedisShardInfo jedisShardInfo = new JedisShardInfo(uri);
        jedisShardInfoList.add(jedisShardInfo);

        return new ShardedJedisPool(genericObjectPoolConfig, jedisShardInfoList);
    }

    private Properties getRedisProperties() throws IOException {
        Properties prop = new Properties();
        InputStream inputStream = Resources.getResourceAsStream("redis.properties");
        prop.load(inputStream);
        return prop;
    }

    @Bean
    public ShardedJedis shardedJedis(ShardedJedisPool jedisPool) {
        ShardedJedis shardedJedis = jedisPool.getResource();
        return shardedJedis;
    }
}
*/
