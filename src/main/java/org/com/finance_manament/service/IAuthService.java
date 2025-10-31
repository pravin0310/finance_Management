package org.com.finance_manament.service;

import org.com.finance_manament.models.User;
import org.springframework.data.util.Pair;

public interface IAuthService {
    User signup(String username, String password, String email, String role);

    Pair<User,String> login(String email, String password);
}
