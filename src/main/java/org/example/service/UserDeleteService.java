package org.example.service;

import org.example.entities.User;
import org.example.exaptions.UpdateException;
import org.example.repository.UserDeleteRepository;
import org.example.utils.Constants;
import org.example.utils.IdValidator;

import java.util.HashMap;
import java.util.Map;

public class UserDeleteService {
    UserDeleteRepository repository;

    public UserDeleteService(UserDeleteRepository repository){
        this.repository = repository;
    }
    public String deleteUser(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new UpdateException("Check inputs", errors);
            } catch (UpdateException ue) {
                return ue.getErrors(errors);
            }
        }

        return repository.deleteContact(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {

        Map<String, String> errors = new HashMap<>();

        if (IdValidator.isIdValid(data[0]))
            errors.put("id", Constants.WRONG_ID_MSG);

        return errors;
    }

    private User convertData(String[] data) {
        User contact = new User();
        contact.setId(Integer.parseInt(data[0]));
        return contact;
    }
}
