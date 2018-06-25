package ru.itpark.milkyKitchen.dto;

import lombok.*;
import ru.itpark.milkyKitchen.models.ClinicEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nailya.shakirova on 22.06.2018.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClinicDto {
    private Integer id;
    private String code;
    private String fullName;
    private String shortName;

    public static ClinicDto from(ClinicEntity model) {
        return ClinicDto.builder()
                .id(model.getId())
                .code(model.getCode())
                .fullName(model.getFullName())
                .shortName(model.getShortName())
                .build();
    }

    public static List<ClinicDto> from(List<ClinicEntity> models) {
        return models.stream().map(ClinicDto::from).collect(Collectors.toList());
    }
}
