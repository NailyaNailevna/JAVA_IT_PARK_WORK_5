package ru.itpark.milkyKitchen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itpark.milkyKitchen.repositories.UserRepository;

/**
 * Created by nailya.shakirova on 28.06.2018.
 */

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

}
