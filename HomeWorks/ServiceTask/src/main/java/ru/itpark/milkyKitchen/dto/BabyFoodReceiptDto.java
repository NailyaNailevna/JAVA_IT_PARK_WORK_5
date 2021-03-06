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
//    public class BabyFoodReceiptDto extends ReceiptDto{
    private Integer id;
    private String series;
    private String num;
    private Date issueDt;
    private Date beginDate;
    private Date endDate;
    private Integer patientId;
    private String patientFio;
    private Date birthDate;
//    private String age;
    private Integer ageCategoryId;
    private Integer benefitDefinitionId;
    private Integer kitchenId;
    private String kitchenName;
    private Integer diagnosisId;
    private Integer clinicId;
    private Integer emplPosId;
    private String emplPosName;
    private Boolean canceled;

    public static BabyFoodReceiptDto from(BabyFoodReceiptEntity model) {
        return BabyFoodReceiptDto.builder()
                .id(model.getReceiptId().getId())
//                .series(model.getReceipt().getSeries())
//                .num(model.getReceipt().getNum())
//                .issueDt(model.getReceipt().getIssueDt())
                .beginDate(model.getBeginDate())
                .endDate(model.getEndDate())
//                .patientId(model.getReceipt().getPatient().getId())
//                .patientFio(model.getReceipt().getPatient().getFio())
//                .birthDate(model.getReceipt().getPatient().getBirthDate())
                .ageCategoryId(model.getAgeCategoryId())
                .benefitDefinitionId(model.getBenefitDefinitionId())
//                .diagnosisId(model.getReceipt().getDiagnosis().getId())
                .kitchenId(model.getKitchenId().getId())
                .kitchenName(model.getKitchenId().getName())
//                .clinicId(model.getReceipt().getClinic().getId())
//                .emplPosId(model.getReceipt().getEmplPos().getId())
//                .emplPosName(model.getReceipt().getEmplPos().getEmployee().getIndiv().getFio())
                .build();
    }
    //test
//
//    private static class BabyFoodReceiptDtoTest {
//    }
//    public static BabyFoodReceiptDtoTest from(BabyFoodReceiptEntity model) {
//        return BabyFoodReceiptDtoTest.builder()
//                .id(model.getReceipt().getId())
//                .series(model.getSeries())
//                .num(model.getNum())
//                .issueDt(model.getIssueDt())
//                .build();
//    }

    public static List<BabyFoodReceiptDto> from(List<BabyFoodReceiptEntity> models) {
        return models.stream().map(BabyFoodReceiptDto::from).collect(Collectors.toList());
    }
}
