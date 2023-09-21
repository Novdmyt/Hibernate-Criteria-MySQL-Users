package org.example.service;

import org.example.entities.User;
import org.example.repository.UserReadRepository;
import org.example.utils.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UserReadService {
    UserReadRepository repository;

    public UserReadService(UserReadRepository repository) {
        this.repository = repository;
    }

    public String readUser() {
        List<User> list = repository.readContacts();
                if (list != null) {

            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((user) ->
                        stringBuilder.append(count.incrementAndGet())
                                .append(") id: ")
                                .append(user.getId())
                                .append(", ")
                                .append(user.getUserName())
                                .append(" ")
                                .append(user.getFirstName())
                                .append(" ")
                                .append(user.getLastName())
                                .append(", ")
                                .append(user.getEmail())
                                .append("\n")
                );
                return "\n______ User ___________\n" + stringBuilder;
            } else return Constants.DATA_ABSENT_MSG;
        } else return Constants.DATA_ABSENT_MSG;
    }
}
