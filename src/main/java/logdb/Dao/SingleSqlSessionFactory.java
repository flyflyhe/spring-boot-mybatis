package logdb.Dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.lang.Nullable;

import java.io.InputStream;

/**
 * 不能注册为bean的原因SqlSession是个接口
 */
public class SingleSqlSessionFactory extends AbstractFactoryBean<SqlSession>{

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return SqlSession.class;
    }

    @Override
    protected SqlSession createInstance() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        org.apache.ibatis.session.SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        return  sqlSessionFactory.openSession(true);
    }
}
