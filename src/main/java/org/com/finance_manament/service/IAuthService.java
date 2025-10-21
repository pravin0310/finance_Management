package org.com.finance_manament.service;

import org.com.finance_manament.models.User;

public interface IAuthService {
    User signup(String username, String password, String email, String role);
}
