package ru.itpark.milkyKitchen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itpark.milkyKitchen.models.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nailya.shakirova on 28.06.2018.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Integer id;
    private String login;
    private boolean blocked;

    public static UserDto from(User model) {
        return UserDto.builder()
                .id(model.getId())
                .login(model.getLogin())
                .blocked(model.isBlocked())
                .build();
    }

    public static List<UserDto> from(List<User> models) {
        return models.stream().map(UserDto::from).collect(Collectors.toList());
    }
}
