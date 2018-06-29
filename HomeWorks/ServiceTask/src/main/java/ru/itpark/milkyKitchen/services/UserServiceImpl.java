package ru.itpark.milkyKitchen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itpark.milkyKitchen.dto.UserDto;
import ru.itpark.milkyKitchen.models.User;
import ru.itpark.milkyKitchen.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by nailya.shakirova on 28.06.2018.
 */

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(UserDto.builder()
                    .id(user.getId())
                    .login(user.getLogin())
                    .blocked(user.isBlocked())
                    .build());
        }
        return userDtos;
    }

}
