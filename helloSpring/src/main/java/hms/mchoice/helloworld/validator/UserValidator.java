package hms.mchoice.helloworld.validator;

import hms.mchoice.helloworld.Service.Service;
import hms.mchoice.helloworld.beans.UserBeans;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by kapila on 9/10/15.
 */
public class UserValidator implements Validator {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserValidator.class);
    @Autowired
    private Service service;

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object object, Errors errors) {
        UserBeans userBeans = (UserBeans) object;

        if (userBeans.getFirstName() == null || userBeans.getFirstName().trim().equals("")) {
            errors.rejectValue("firstName", "firstName.required");
            logger.error("first name field null found");
        } else if (service.findUser(userBeans.getFirstName()).size() != 0) {
            errors.rejectValue("firstName", "firstName.exitst");
        }

        if (userBeans.getMiddleName() == null || userBeans.getFirstName().trim().equals("")) {
            errors.rejectValue("middleName", "middleName.required");
        }

        try {
            Integer.parseInt(userBeans.getAge());

        } catch (NumberFormatException e) {
            logger.warn("age wrong found");
            errors.rejectValue("age", "age.wrong");
        }

        if (userBeans.getAge() == null || userBeans.getFirstName().trim().equals("")) {
            errors.rejectValue("age", "age.required");
        }


        try {
            Long.parseLong(userBeans.getUserId());

        } catch (NumberFormatException e) {
            errors.rejectValue("userId", "userid.wrong");
        }

    }
}
