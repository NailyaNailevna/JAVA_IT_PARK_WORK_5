package ru.itpark.milkyKitchen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.milkyKitchen.models.User;

import java.util.Optional;

/**
 * Created by nailya.shakirova on 28.06.2018.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findOneByLogin(String login);
}
