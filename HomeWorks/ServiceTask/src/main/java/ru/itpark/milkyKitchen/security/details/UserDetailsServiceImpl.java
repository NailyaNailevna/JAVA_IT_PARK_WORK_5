package ru.itpark.milkyKitchen.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ru.itpark.milkyKitchen.repositories.UserRepository;

/**
 * Created by nailya.shakirova on 28.06.2018.
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return new UserDetailsImpl(userRepository.findOneByLogin(login).orElseThrow(() ->
        new BadCredentialsException("User not found")));
    }
}
