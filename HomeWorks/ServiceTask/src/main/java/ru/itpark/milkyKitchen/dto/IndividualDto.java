package ru.itpark.milkyKitchen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by nailya.shakirova on 20.06.2018.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndividualDto {
    private Integer id;
//    private String surname;
//    private String name;
//    private String patrName;
    private Date birthDate;
    private String fio;
}
