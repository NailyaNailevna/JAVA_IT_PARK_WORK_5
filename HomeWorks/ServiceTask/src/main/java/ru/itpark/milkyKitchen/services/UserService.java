package ru.itpark.milkyKitchen.services;

import ru.itpark.milkyKitchen.dto.UserDto;

import java.util.List;

/**
 * Created by nailya.shakirova on 28.06.2018.
 */
public interface UserService {

    List<UserDto> getAllUsers();
}
