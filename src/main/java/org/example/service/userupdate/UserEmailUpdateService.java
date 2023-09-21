package org.example.service.userupdate;

import org.example.entities.User;
import org.example.exaptions.UpdateException;
import org.example.repository.userupdate.UserEmailUpdateRepository;
import org.example.utils.Constants;
import org.example.utils.IdValidator;


import java.util.HashMap;
import java.util.Map;

public class UserEmailUpdateService {
    UserEmailUpdateRepository repository;

    public UserEmailUpdateService(UserEmailUpdateRepository repository) {
        this.repository = repository;
    }

    public String updateContact(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new UpdateException("Check inputs", errors);
            } catch (UpdateException ue) {
                return ue.getErrors(errors);
            }
        }

        return repository.updateUser(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        // Map для помилок
        Map<String, String> errors = new HashMap<>();

        if (IdValidator.isIdValid(data[0]))
            errors.put("id", Constants.WRONG_ID_MSG);

        return errors;
    }

    private User convertData(String[] data) {
        User user = new User();
        user.setId(Integer.parseInt(data[0]));
        user.setEmail(data[1]);
        return user;
    }
}