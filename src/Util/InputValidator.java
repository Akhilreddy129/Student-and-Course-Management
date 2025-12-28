package Util;

import exception.InvalidInputException;

import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    private InputValidator() {}

    public static String requireNonBlank(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new InvalidInputException(fieldName + " cannot be blank.");
        }
        return value.trim();
    }

    public static int requirePositiveInt(int value, String fieldName) {
        if (value <= 0) {
            throw new InvalidInputException(fieldName + " must be a positive integer.");
        }
        return value;
    }

    public static String requireValidEmail(String email) {
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new InvalidInputException("Invalid email format.");
        }
        return email;
    }

    public static int parseIntOrThrow(String input, String fieldName) {
        try {
            return Integer.parseInt(requireNonBlank(input, fieldName));
        } catch (NumberFormatException e) {
            throw new InvalidInputException(fieldName + " must be a number.");
        }
    }
}
