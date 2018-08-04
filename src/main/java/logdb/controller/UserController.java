package logdb.controller;


import logdb.Dao.SqlSessionConfig;
import logdb.mapper.UserMapper;
import logdb.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> index() throws Exception {
        SqlSession session = SqlSessionConfig.getMybatisSession();
        //UserMapper useDao = session.getMapper(UserMapper.class);
        /*List<User> userList = new ArrayList<User>();
        userList.add(session.selectOne("select", 1));*/
        return session.selectList("findAll");
        //return  userList;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User create(@Valid @ModelAttribute User user) throws Exception {
        SqlSession session = SqlSessionConfig.getMybatisSession();
        int id = user.create(session);
        if (id > 0) {
            user.setId(id);
            return user;
        }
        throw new Exception("error");
    }
}
