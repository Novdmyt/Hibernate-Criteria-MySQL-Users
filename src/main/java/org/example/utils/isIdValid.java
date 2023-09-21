package org.example.utils;

public class isIdValid {
    public static boolean isIdValid(String id) {
        return id.isEmpty() || !id.matches(Constants.ID_RGX);
    }
}
