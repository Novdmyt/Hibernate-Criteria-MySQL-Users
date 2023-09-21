package org.example.service.userupdate;

import org.example.entities.User;
import org.example.exaptions.UpdateException;
import org.example.repository.userupdate.UserLastNameUpdateRepository;
import org.example.utils.Constants;
import org.example.utils.IdValidator;
import org.example.utils.NameValidator;

import java.util.HashMap;
import java.util.Map;

public class UserLastNameUpdateService {
    UserLastNameUpdateRepository repository;

    public UserLastNameUpdateService(UserLastNameUpdateRepository repository) {
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

        return repository.updateLastName(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        // Map для помилок
        Map<String, String> errors = new HashMap<>();

        if (IdValidator.isIdValid(data[0]))
            errors.put("id", Constants.WRONG_ID_MSG);
        if (NameValidator.isLastNameValidator(data[1]))
            errors.put("last name", Constants.WRONG_NAME);
        return errors;
    }

    private User convertData(String[] data) {
        User user = new User();
        user.setId(Integer.parseInt(data[0]));
        user.setLastName(data[1]);
        return user;
    }
}