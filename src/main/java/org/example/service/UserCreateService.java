package org.example.service;

import org.example.entities.User;
import org.example.exaptions.CreateException;
import org.example.repository.UserCreateRepository;
import org.example.utils.Constants;
import org.example.utils.EmailValidator;

import java.util.HashMap;
import java.util.Map;

public class UserCreateService {
    UserCreateRepository repository;

    public UserCreateService(UserCreateRepository repository){
        this.repository = repository;
    }

    public String userContact(String[] data){
        Map<String,String> errors = validateData(data);
        if (!errors.isEmpty()) {
            try {
                throw new CreateException("Check inputs", errors);
            } catch (CreateException ce) {
                return ce.getErrors(errors);
            }
        }

        return repository.createContact(convertData(data));
    }
    private  Map<String,String> validateData(String[] data){
        Map<String,String> errors = new HashMap<>();
        if(data[0].isEmpty())
            errors.put("user name", Constants.INPUT_REQ_MSG);
        if(data[1].isEmpty())
            errors.put("first name", Constants.INPUT_REQ_MSG);
        if(data[2].isEmpty())
            errors.put("last name", Constants.INPUT_REQ_MSG);
        if(EmailValidator.isEmailValidator(data[3]))
            errors.put("email", Constants.WRONG_EMAIL_MSG);
        return errors;
    }

    private User convertData(String[] data) {
        User user = new User();
        user.setUserName(data[0]);
        user.setFirstName(data[1]);
        user.setLastName(data[2]);
        user.setEmail(data[3]);
        return user;
    }
}
