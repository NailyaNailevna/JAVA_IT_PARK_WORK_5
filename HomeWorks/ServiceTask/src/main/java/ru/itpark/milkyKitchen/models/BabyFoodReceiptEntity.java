package ru.itpark.milkyKitchen.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by nailya.shakirova on 02.06.2018.
 */

@Data
//@NoArgsConstructor
@AllArgsConstructor
//@Builder
@Entity
//@EqualsAndHashCode(callSuper = true,of = {"id"})
//@EqualsAndHashCode(callSuper = false, of = {"id"})
@Table(name="ehr.baby_food_receipt")
//@PrimaryKeyJoinColumn(name = "ID")
/*
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries(value = {
        @NamedQuery(
                name = "BabyFoodReceiptEntity.findReceiptById",
                query = "SELECT bfr " +
                        "FROM BabyFoodReceiptEntity bfr " +
                        "JOIN bfr.ReceiptEntity r " +
//                    "FROM receipt.receipt r " +
//                    "JOIN receipt.baby_food_receipt bfr on bfr.id = r.id " +
//                    "JOIN pim_employee_position pep on pep.id = r.employee_position_id " +
//                    "JOIN pim_employee pe on pe.id = pep.employee_id " +
//                    "JOIN pim_individual docpi on docpi.id = pe.individual_id " +
//                    "JOIN pim_individual pi on pi.id = r.patient_id " +
//                    "JOIN pim_department pd on pd.id = bfr.kitchen_id " +
                        "WHERE bfr.id = :id"
        )
})
*/
public class BabyFoodReceiptEntity extends ReceiptEntity {

    @OneToOne(cascade = CascadeType.ALL)
//    , mappedBy = "ReceiptEntity"
    @PrimaryKeyJoinColumn
    private ReceiptEntity receipt;

    @Column(name = "benefit_definition_id", nullable = false)
    private Integer benefitDefinitionId;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "kitchen_id")
    private DepartmentEntity kitchen;

    @Column(name = "begin_dt", nullable = false)
    private java.util.Date beginDate;

    @Column(name = "end_dt", nullable = false)
    private java.util.Date endDate;

    @Column(name = "age_category_id", nullable = false)
    private Integer ageCategoryId;

    public BabyFoodReceiptEntity(){
    }

    public BabyFoodReceiptEntity(Long id
                                , String series
                                , String num
                                , Date issueDate
                                , Date beginDate
                                , Date endDate
                                , Integer patient
                                , Integer ageCategoryId
                                , Integer benefitDefinitionId
                                , Integer kitchen
                                , Integer clinic
                                , Integer emplPosId) {
        setId(id);
        setSeries(series);
        setNum(num);
        setIssueDt(issueDate);
        setBeginDate(beginDate);
        setEndDate(endDate);
        setPatient(new IndividualEntity(patient));
        setAgeCategoryId(ageCategoryId);
        setBenefitDefinitionId(benefitDefinitionId);
        setKitchen(new DepartmentEntity(kitchen));
        setClinic(new ClinicEntity(clinic));
        setEmplPos(new EmployeePositionEntity(emplPosId));
    }

}
