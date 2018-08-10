package logdb.controller;


import logdb.Dao.DbConnectionFactory;
import logdb.mapper.UserMapper;
import logdb.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<User> index() throws Exception {
        SqlSession session = DbConnectionFactory.getMybatisSession();
        UserMapper useDao = session.getMapper(UserMapper.class);
        /*List<User> userList = new ArrayList<User>();
        userList.add(session.selectOne("select", 1));*/
        //return session.selectList("findAll");
        return  useDao.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findOne(@PathVariable int id) throws Exception {
        SqlSession session = DbConnectionFactory.getMybatisSession();
        UserMapper useDao = session.getMapper(UserMapper.class);
        /*List<User> userList = new ArrayList<User>();
        userList.add(session.selectOne("select", 1));*/
        //return session.selectList("findAll");
        return  useDao.select(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User create(@Valid @ModelAttribute User user) throws Exception {
        SqlSession session = DbConnectionFactory.getMybatisSession();
        int id = user.create(session);
        if (id > 0) {
            user.setId(id);
            return user;
        }
        throw new Exception("error");
    }

    @RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.DELETE)
    public User deleteOne(@PathVariable("id") int id) throws Exception {
        SqlSession session = DbConnectionFactory.getMybatisSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.select(id);
        if (user != null && user.getId() == id) {
            if (userMapper.delete(id) > 0) {
                return null;
            }
        }
        throw new Exception("删除失败");
    }
}
