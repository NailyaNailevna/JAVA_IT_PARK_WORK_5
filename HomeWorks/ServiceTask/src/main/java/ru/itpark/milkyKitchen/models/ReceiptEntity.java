package ru.itpark.milkyKitchen.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itpark.milkyKitchen.enums.ReceiptSignEnum;

import javax.persistence.*;

/**
 * Created by nailya.shakirova on 02.06.2018.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="ehr.receipt")
@Inheritance(strategy = InheritanceType.JOINED)
/*
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries(value = {
        @NamedQuery(
                name = "ReceiptEntity.findReceiptById",
                query = "SELECT r " +
                        "FROM ReceiptEntity r " +
//                    "FROM receipt.receipt r " +
//                    "JOIN receipt.baby_food_receipt bfr on bfr.id = r.id " +
//                    "JOIN pim_employee_position pep on pep.id = r.employee_position_id " +
//                    "JOIN pim_employee pe on pe.id = pep.employee_id " +
//                    "JOIN pim_individual docpi on docpi.id = pe.individual_id " +
//                    "JOIN pim_individual pi on pi.id = r.patient_id " +
//                    "JOIN pim_department pd on pd.id = bfr.kitchen_id " +
                        "WHERE r.id = :id"
        )
})
*/
public class ReceiptEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "receipt_id_gen")
    @SequenceGenerator(name = "receipt_id_gen", sequenceName = "ehr.receipt_id_seq", allocationSize = 1)
    @Access(AccessType.PROPERTY)
    private Long id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "clinic_id", nullable = false)
    private ClinicEntity clinic;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", nullable = false)
    private ReceiptTypeEntity receiptType;

    @Column(name = "series")
    private String series;

    @Column(name = "num")
    private String num;

    @Column(name = "issue_dt", nullable = false)
    private java.util.Date issueDt;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_position_id", nullable = false)
    private EmployeePositionEntity emplPos;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private IndividualEntity patient;

//    @ManyToOne (fetch = FetchType.LAZY)
//    @JoinColumn(name = "sign_id", nullable = false)
//    private ReceiptSignEntity receiptSign;
    @Column(name = "sign_id")
    @Enumerated(value = EnumType.STRING)
    private ReceiptSignEnum receiptSign;

    @Column(name = "cito", nullable = false)
    private boolean cito;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "diagnosis_id")
    private DiagnosisEntity diagnosis;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "validity_id", nullable = false)
    private ReceiptValidityEntity receiptValidity;

    @Column(name = "canceled", nullable = false)
    private boolean canceled;

    public IndividualEntity getIndividual() {
        return patient;
    }

    public void setPatient(IndividualEntity patient) {
        this.patient = patient;
    }

    public Integer getpatientId() {
        return patient == null ? null : patient.getId();
    }

}
