package ru.itpark.milkyKitchen.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by nailya.shakirova on 14.06.2018.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BabyFoodReceiptForm {
    Integer id;
    Integer clinicId;
    Integer refDepId;
    Integer typeId;
    Integer signId;
    Integer validityId;
    String series;
    String num;
    Date issueDt;
    Integer employeePositionId;
    Integer patientId;
    Integer benefitDefinitionId;
    Integer ageCategoryId;
    Integer diagnosisId;
    Integer kitchenId;
    Date beginDt;
    Date endDt;
    Boolean isSeparate;
}
