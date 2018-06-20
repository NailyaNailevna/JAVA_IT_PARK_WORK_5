package ru.itpark.milkyKitchen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itpark.milkyKitchen.models.BabyFoodReceiptEntity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nailya.shakirova on 19.06.2018.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BabyFoodReceiptDto {
//    public class BabyFoodReceiptDto extends ReceptDto{
    private Long id;
    private String series;
    private String num;
    private Date issueDt;
    private Date beginDate;
    private Date endDate;
    private Integer patientId;
    private Date birthDate;
//    private String age;
    private Integer ageCategoryId;
    private Integer benefitDefinitionId;
    private Integer kitchenId;
    private Integer clinicId;
    private Integer emplPosId;

    public static BabyFoodReceiptDto from(BabyFoodReceiptEntity model) {
        return BabyFoodReceiptDto.builder()
                .id(model.getReceipt().getId())
                .series(model.getSeries())
                .num(model.getNum())
                .issueDt(model.getIssueDt())
                .beginDate(model.getBeginDate())
                .endDate(model.getEndDate())
                .patientId(model.getPatient().getId())
                .birthDate(model.getReceipt().getPatient().getBirthDate())
                .ageCategoryId(model.getAgeCategoryId())
                .benefitDefinitionId(model.getBenefitDefinitionId())
                .kitchenId(model.getKitchen().getId())
                .clinicId(model.getReceipt().getClinic().getId())
                .emplPosId(model.getReceipt().getEmplPos().getId())
                .build();
    }

    public static List<BabyFoodReceiptDto> from(List<BabyFoodReceiptEntity> models) {
        return models.stream().map(BabyFoodReceiptDto::from).collect(Collectors.toList());
    }

}
