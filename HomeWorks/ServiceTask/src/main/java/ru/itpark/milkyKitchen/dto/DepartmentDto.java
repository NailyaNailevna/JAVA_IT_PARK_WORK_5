package ru.itpark.milkyKitchen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itpark.milkyKitchen.models.DepartmentEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nailya.shakirova on 22.06.2018.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDto {
    private Integer id;
    private String code;
    private String name;
    private Integer orgId;

    public static DepartmentDto from(DepartmentEntity model) {
        return DepartmentDto.builder()
                .id(model.getId())
                .code(model.getCode())
                .name(model.getName())
                .orgId(model.getOrg().getId())
                .build();
    }

    public static List<DepartmentDto> from(List<DepartmentEntity> models) {
        return models.stream().map(DepartmentDto::from).collect(Collectors.toList());
    }
}
