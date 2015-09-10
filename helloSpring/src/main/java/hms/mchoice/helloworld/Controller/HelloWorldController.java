package hms.mchoice.helloworld.Controller;

import hms.mchoice.helloworld.Service.Service;
import hms.mchoice.helloworld.beans.UserBeans;
import hms.mchoice.helloworld.validator.UserValidator;
import hms.mchoice.user.Domain.User;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class HelloWorldController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
    @Autowired
    private Service service;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value ="/welcome",method = RequestMethod.GET)
    public String hello(ModelMap model){

        //logs debug message
//        if(logger.isDebugEnabled()){
//            logger.debug("get Welcome is executed!");
//        }

        //logs exception
        logger.info("runnig welcome page");

        model.addAttribute("name", "welcome");
        return "welcome";
    }

    @RequestMapping(value ="/helloWorld",method = RequestMethod.GET)
    public ModelAndView addUser(){
        //logs exception
        logger.info("runnig helloworld get method");
        return new ModelAndView("/helloWorld", "userBean", new UserBeans());

    }

    @RequestMapping(value ="/helloWorld" ,method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("userBean") UserBeans userBeans , BindingResult result) {
        //logs exception
        logger.info("running helloworld post method");
        userValidator.validate(userBeans, result);
        //return new ModelAndView("/helloWorld","userBean", new UserBeans());
        if(result.hasErrors()){
            return addUser();

        }else {
            service.addUser(userBeans);
            return addUser();
        }

    }

    @RequestMapping(value ="/viewUsers" , method = RequestMethod.GET)
    public ModelAndView allUsers(){
        logger.info("running viewUsers get method");
        List<User> userList = service.findAll();
        ModelAndView modelAndView = new ModelAndView("/viewUsers");
        modelAndView.addObject("list",userList);
        return  modelAndView;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView removeUser(){
        logger.info("running deleteUser get method");
        return new ModelAndView("/deleteUser", "userBean", new UserBeans());
    }

    @RequestMapping(value = "/deleteUser" , method = RequestMethod.POST)
    private ModelAndView removeUser(@ModelAttribute("userBean") UserBeans userBeans, BindingResult result){
        userValidator.validate(userBeans, result);
        if(result.hasErrors()){
            return removeUser();
        }else {
            service.deleteUser(Long.parseLong(userBeans.getUserId()));
            return addUser();
        }
    }

    @RequestMapping(value = "/searchUser", method = RequestMethod.GET)
    public ModelAndView findUsers(){
        return new ModelAndView("/searchUser", "userBean", new UserBeans());
    }

    @RequestMapping(value ="/searchUser" , method = RequestMethod.POST)
    private ModelAndView findUsers(@ModelAttribute("userBean") UserBeans userBeans, BindingResult result){
        userValidator.validate(userBeans, result);

        if(result.hasErrors()){
            return findUsers();
        }else {
            List<User> userList = service.findUser(userBeans.getFirstName());
            ModelAndView modelAndView = new ModelAndView("/viewUsers");
            modelAndView.addObject("list", userList);
            return modelAndView;
        }
    }
}
