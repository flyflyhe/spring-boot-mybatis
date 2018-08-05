package logdb.Dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SqlSessionFactoryBeanConfig {

    @Bean(name = "org.apache.ibatis.session.SqlSession")
    public SingleSqlSessionFactory sqlSessionFactoryBean() throws Exception {
        return new SingleSqlSessionFactory();
    }
}
