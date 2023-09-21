package org.example.utils;

public class LastNameValidator {
    public static boolean isLastNameValidator(String lastName){

        return lastName.isEmpty()|| !lastName.matches(Constants.LAST_NAME);
    }
}