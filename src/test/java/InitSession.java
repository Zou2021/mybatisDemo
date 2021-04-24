import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: 邹祥发
 * @date: 2021/4/23 21:06
 */
public class InitSession {
    public static SqlSession getSession(String config) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(config);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sessionFactory.openSession(true);
    }
}
