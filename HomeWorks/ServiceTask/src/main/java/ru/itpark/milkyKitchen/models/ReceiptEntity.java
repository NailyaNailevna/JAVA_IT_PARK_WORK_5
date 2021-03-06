package ru.itpark.milkyKitchen.models;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
@Table(name="receipt", schema="ehr")
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
    private Integer id;

//    @ManyToOne (fetch = FetchType.LAZY)
//    @JoinColumn(name = "clinic_id", nullable = false)
//    private ClinicEntity clinicId;
    @Column(name = "clinic_id", nullable = false)
    private Integer clinicId;

//    @ManyToOne (fetch = FetchType.LAZY)
//    @JoinColumn(name = "type_id", nullable = false)
//    private ReceiptTypeEntity receiptType;
    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "series")
    private String series;

    @Column(name = "num")
    private String num;

    @Column(name = "issue_dt", columnDefinition="DATE", nullable = false)
    private java.util.Date issueDt;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_position_id", nullable = false)
    @NotFound(action= NotFoundAction.IGNORE)
    private EmployeePositionEntity emplPosId;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private IndividualEntity patientId;

    @Column(name = "sign_id")
    private Integer signId;

    @Column(name = "cito", columnDefinition="boolean default false")
    private boolean cito;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "diagnosis_id")
    private DiagnosisEntity diagnosisId;

//    @ManyToOne (fetch = FetchType.LAZY)
//    @JoinColumn(name = "validity_id", nullable = false)
//    private ReceiptValidityEntity receiptValidity;

    @Column(name = "canceled", columnDefinition="boolean default false")
    private boolean canceled;

}
