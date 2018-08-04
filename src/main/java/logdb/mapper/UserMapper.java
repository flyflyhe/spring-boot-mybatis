package logdb.mapper;

import logdb.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from user where id #{id}")
    User select(int id);

    @Insert("")
    int insert(User user);
}
