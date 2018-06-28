package ru.itpark.milkyKitchen.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by nailya.shakirova on 28.06.2018.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserForm {
    private String login;
    private String password;
}
