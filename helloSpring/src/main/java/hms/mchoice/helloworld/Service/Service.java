package hms.mchoice.helloworld.Service;

import hms.mchoice.helloworld.beans.UserBeans;
import hms.mchoice.user.Domain.User;
import hms.mchoice.user.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by kapila on 9/10/15.
 */
public class Service {

    @Autowired
    private UserRepository userRepository;

    public void addUser(UserBeans userBeans) {
        User user = new User();
        user.setFirstName(userBeans.getFirstName());
        user.setMiddleName(userBeans.getMiddleName());
        user.setAge(Integer.parseInt(userBeans.getAge()));
        user.setUserId(Long.parseLong(userBeans.getUserId()));
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void deleteUser(long id){
        userRepository.removeUser(id);
    }

    public List<User> findUser(String name){
        return userRepository.findUser(name);
    }
}
