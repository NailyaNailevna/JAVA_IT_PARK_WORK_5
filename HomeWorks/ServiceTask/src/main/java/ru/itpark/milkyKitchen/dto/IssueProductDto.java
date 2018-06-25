package ru.itpark.milkyKitchen.dto;

import lombok.*;
import ru.itpark.milkyKitchen.models.IssueProductEntity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nailya.shakirova on 22.06.2018.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IssueProductDto {
    private Integer id;
    private Integer receiptId;
    private Date distributeDt;
    private String distributeInfo;
    private Integer userId;

    public static IssueProductDto from(IssueProductEntity model) {
        return IssueProductDto.builder()
                .id(model.getId())
                .receiptId(model.getReceiptId())
                .distributeDt(model.getDistributeDt())
                .distributeInfo(model.getDistributeInfo())
                .userId(model.getUserId())
                .build();
    }

    public static List<IssueProductDto> from(List<IssueProductEntity> models) {
        return models.stream().map(IssueProductDto::from).collect(Collectors.toList());
    }
}
