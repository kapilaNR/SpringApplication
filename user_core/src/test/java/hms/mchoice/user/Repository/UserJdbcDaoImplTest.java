package hms.mchoice.user.Repository;

import hms.mchoice.user.Domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-context.xml")
public class UserJdbcDaoImplTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testViewAll() throws Exception {
        List<User> userList = userRepository.findAll();
        for(User user:userList){
            System.out.println(user.getUserId()+user.getFirstName()+user.getAge());
        }
    }

    @Test
    public void testAddUser() throws Exception {
        User testUser =  new User();
        testUser.setFirstName("asdasd");
        testUser.setMiddleName("fgdhy");
        testUser.setAge(19);
        userRepository.addUser(testUser);
    }

    public void testRemoveUser() throws Exception {
        userRepository.removeUser(20);
    }

    public void testUpdateUser() throws Exception {
        User testUser =  new User();
        testUser.setUserId(1);
        testUser.setFirstName("asdd");
        testUser.setMiddleName("fgy");
        testUser.setAge(39);
        userRepository.updateUser(testUser);
    }

}