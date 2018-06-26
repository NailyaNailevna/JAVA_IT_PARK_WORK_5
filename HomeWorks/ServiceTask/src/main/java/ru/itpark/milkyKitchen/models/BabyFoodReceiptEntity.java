package ru.itpark.milkyKitchen.models;

import lombok.*;

import javax.persistence.*;

/**
 * Created by nailya.shakirova on 02.06.2018.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
//@EqualsAndHashCode(callSuper = true,of = {"id"})
//@EqualsAndHashCode(callSuper = false, of = {"id"})
@Table(name="baby_food_receipt", schema="ehr")
//@PrimaryKeyJoinColumn(name = "ID")
/*
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "babyFoodReceiptMapping",
                classes = @ConstructorResult(targetClass = BabyFoodReceiptEntity.class,
                        columns = {@ColumnResult(name = "id", type = Integer.class),
                                @ColumnResult(name = "series", type = String.class),
                                @ColumnResult(name = "num", type = String.class),
                                @ColumnResult(name = "issueDt", type = Date.class),
                                @ColumnResult(name = "beginDate", type = Date.class),
                                @ColumnResult(name = "endDate", type = Date.class),
                                @ColumnResult(name = "patientId", type = Integer.class),
                                @ColumnResult(name = "ageCategoryId", type = Integer.class),
                                @ColumnResult(name = "benefitDefinitionId", type = Integer.class),
                                @ColumnResult(name = "diagnosisId", type = Integer.class),
                                @ColumnResult(name = "kitchenId", type = Integer.class),
                                @ColumnResult(name = "clinicId", type = Integer.class),
                                @ColumnResult(name = "emplPosId", type = Integer.class)
                })),

                      }
)

@Inheritance(strategy = InheritanceType.JOINED)
@NamedNativeQueries( {
        @NamedNativeQuery(name = "BabyFoodReceiptEntity.findReceiptById",
                query = "SELECT * " +
                        "FROM BabyFoodReceiptEntity bfr\n " +
                        "JOIN bfr.ReceiptEntity r\n " +
//                    "FROM receipt.receipt r " +
//                    "JOIN receipt.baby_food_receipt bfr on bfr.id = r.id " +
//                    "JOIN pim_employee_position pep on pep.id = r.employee_position_id " +
//                    "JOIN pim_employee pe on pe.id = pep.employee_id " +
//                    "JOIN pim_individual docpi on docpi.id = pe.individual_id " +
//                    "JOIN pim_individual pi on pi.id = r.patient_id " +
//                    "JOIN pim_department pd on pd.id = bfr.kitchen_id " +
                        "WHERE bfr.id = :id",resultSetMapping = "babyFoodReceiptMapping"
        )
})
*/
//public class BabyFoodReceiptEntity extends ReceiptEntity {
public class BabyFoodReceiptEntity{

    @OneToOne(cascade = CascadeType.ALL)
//    , mappedBy = "ReceiptEntity"
    @PrimaryKeyJoinColumn
    private ReceiptEntity receiptId;

    @Column(name = "benefit_definition_id", nullable = false)
    private Integer benefitDefinitionId;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "kitchen_id")
    private DepartmentEntity kitchen;
//, columnDefinition="timestamp", length=6
    @Column(name = "begin_dt", columnDefinition="DATE", nullable = false)
    private java.util.Date beginDate;

    @Column(name = "end_dt", columnDefinition="DATE", nullable = false)
    private java.util.Date endDate;

    @Column(name = "age_category_id", nullable = false)
    private Integer ageCategoryId;
/*
    public BabyFoodReceiptEntity(){
    }

    public BabyFoodReceiptEntity(
//            Integer id,
                                  Integer typeId
                                , Integer signId
                                , String series
                                , String num
                                , Date issueDate
                                , Date beginDate
                                , Date endDate
                                , Integer patientId
                                , Integer ageCategoryId
                                , Integer benefitDefinitionId
                                , Integer diagnosisId
                                , Integer kitchenId
                                , Integer clinicId
                                , Integer emplPosId) {
//        setId(id);
        setTypeId(typeId);
        setSignId(signId);
//        setSeries(series);
//        setNum(num);
//        setIssueDt(issueDate);
        setBeginDate(beginDate);
        setEndDate(endDate);
//        setPatient(new IndividualEntity(patientId));
        setAgeCategoryId(ageCategoryId);
        setBenefitDefinitionId(benefitDefinitionId);
//        setDiagnosis(new DiagnosisEntity(diagnosisId));
        setKitchen(new DepartmentEntity(kitchenId));
//        setClinic(new ClinicEntity(clinicId));
//        setEmplPos(new EmployeePositionEntity(emplPosId));
    }

    private void setSignId(Integer signId) {
    }

    public void setTypeId(Integer typeId) {
    }
*/
}
