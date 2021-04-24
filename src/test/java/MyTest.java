import com.zou.entity.User;
import com.zou.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author: 邹祥发
 * @date: 2021/4/23 21:08
 */
public class MyTest {
    private final SqlSession session = InitSession.getSession("mybatis-config.xml");

    public MyTest() throws IOException {
    }

    /**
     * 查询所有数据
     */
    @Test
    public void selectListTest() throws Exception {
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectList();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 模糊查询1
     */
    @Test
    public void selectLikeTest01() throws Exception {
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectlike01();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 模糊查询2
     */
    @Test
    public void selectLikeTest02() throws Exception {
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectlike02("%i%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 模糊查询3
     */
    @Test
    public void selectLikeTest03() throws Exception {
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectlike03(new User(1, "zou", 18, "男"));
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 插入并获得主键id的值
     */
    @Test
    public void insertTest() throws Exception {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User(11, "jack", 25, "男");
        mapper.insert(user);
        System.out.println(user.getId());
    }

    /**
     * or 的使用
     * 查询名字为zou 或者 年龄为21的数据
     */
    @Test
    public void orTest() throws Exception {
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.sqlSelect01(new User(1, "zou", 21, "男"));
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * mybatis中if标签的使用
     */
    @Test
    public void ifTest01() throws Exception {
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.sqlSelect02(new User(1, "", 21, "男"));
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * mybatis中if标签嵌套where标签的使用
     */
    @Test
    public void ifAndWhereTest() throws Exception {
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.sqlSelect03(new User());
        for (User user : users) {
            System.out.println(user);
        }
    }
}
