package hms.mchoice.user.Repository;

import hms.mchoice.user.Domain.User;

import java.util.List;

/**
 * Created by kapila on 9/4/15.
 */
public interface UserRepository {
    public List findAll() ;
    public void addUser(User user);
    public void removeUser(User user);
    public void removeUser(long id);
    public void updateUser(User user);
    public List findUser(String name) ;
}
