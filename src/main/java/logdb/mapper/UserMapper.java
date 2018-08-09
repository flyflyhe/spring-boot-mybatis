package logdb.mapper;

import logdb.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface UserMapper {
    List<User> findAll();
    User select(int id);
    int delete(int id);
}
