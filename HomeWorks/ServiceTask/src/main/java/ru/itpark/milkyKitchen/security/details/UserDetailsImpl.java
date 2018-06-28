package ru.itpark.milkyKitchen.security.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itpark.milkyKitchen.models.User;

import java.util.Collection;
import java.util.List;

/**
 * Created by nailya.shakirova on 28.06.2018.
 */
public class UserDetailsImpl implements UserDetails {

    private String login;
    private String password;
    private Boolean blocked;
    private List<SimpleGrantedAuthority> authorities;

    public UserDetailsImpl(User user) {
        this.login = user.getLogin();
        this.password = user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return blocked.equals(true);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.blocked.equals(true);
    }

}
