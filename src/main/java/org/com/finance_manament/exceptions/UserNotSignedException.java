package org.com.finance_manament.exceptions;

public class UserNotSignedException extends RuntimeException {
    public UserNotSignedException(String message) {
        super(message);
    }
}
