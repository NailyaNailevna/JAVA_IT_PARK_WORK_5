package ru.itpark.milkyKitchen.forms;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
//    Boolean cito;

    String series;
    String num;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date issueDt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date beginDt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date endDt;
    Integer patientId;
    Integer ageCategoryId;
    Integer benefitDefinitionId;
    Integer diagnosisId;
    Integer kitchenId;

    Integer clinicId;
    Integer employeePositionId;

}
