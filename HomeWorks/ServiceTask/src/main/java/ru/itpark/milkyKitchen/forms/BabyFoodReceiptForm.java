package ru.itpark.milkyKitchen.forms;

import lombok.*;

import java.util.Date;

/**
 * Created by nailya.shakirova on 14.06.2018.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BabyFoodReceiptForm {
//    Integer id;
    Integer typeId;
    Integer signId;
//    Integer validityId;

    //Integer refDepId;
    String series;
    String num;
    Date issueDt;
    Date beginDt;
    Date endDt;
    Integer patientId;
    Integer ageCategoryId;
    Integer benefitDefinitionId;
    Integer diagnosisId;
    Integer kitchenId;

    Integer clinicId;
    Integer employeePositionId;
//    Boolean isSeparate;



}
