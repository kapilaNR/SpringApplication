package hms.mchoice.user.Repository;

import hms.mchoice.user.Domain.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by kapila on 9/8/15.
 */
public class UserJdbcDaoImpl  extends JdbcDaoSupport implements UserRepository {


    @Override
    public List findAll()  {
        String sql = "select * from users";

        try {
            List<User> users = getJdbcTemplate().query(sql, new UserRowMapper());
            return users;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO users(first_name,secand_name,age) VALUES (?,?,?)";
        getJdbcTemplate().update(sql, new Object[]{user.getFirstName(),user.getMiddleName(),user.getAge()});
    }

    @Override
    public void removeUser(User user) {
        String sql = "delete from users where user_id = ?";
        getJdbcTemplate().update(sql,new Object[]{user.getUserId()});
    }

    public void removeUser(long id) {
        String sql = "delete from users where user_id= ?";
        getJdbcTemplate().update(sql,new Object[]{id});
    }

    @Override
    public void updateUser(User user) {
        String sql = "update users set first_name = ?,secand_name = ?, age = ? where id = ? ";
        getJdbcTemplate().update(sql, new Object[]{user.getFirstName(),user.getMiddleName(),user.getAge(),user.getUserId()});
    }

    @Override
    public List findUser(String name) {
        String sql = "select * from users where first_name=?";

        try {
            List<User> users = getJdbcTemplate().query(sql, new UserRowMapper() ,new Object[]{name});
            return users;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static class UserRowMapper implements RowMapper {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setFirstName(resultSet.getString("first_name"));
            user.setMiddleName(resultSet.getString("secand_name"));
            user.setAge(resultSet.getInt("age"));
            user.setUserId(resultSet.getInt("user_id"));
            return user;
        }
    }
}
