package ru.itpark.milkyKitchen.dto;

import lombok.*;
import ru.itpark.milkyKitchen.models.DiagnosisEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nailya.shakirova on 19.06.2018.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiagnosisDto {
    private Integer id;
    private String code;
    private String name;
    private Integer fullName;

    public static DepartmentDto from(DiagnosisEntity model) {
        return DepartmentDto.builder()
                .id(model.getId())
                .code(model.getCode())
                .name(model.getName())
//                .orgId(model.getFullName())
                .build();
    }

    public static List<DepartmentDto> from(List<DiagnosisEntity> models) {
        return models.stream().map(DiagnosisDto::from).collect(Collectors.toList());
    }
}
