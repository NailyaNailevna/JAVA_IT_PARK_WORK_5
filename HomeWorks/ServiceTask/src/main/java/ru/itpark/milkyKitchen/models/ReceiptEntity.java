package ru.itpark.milkyKitchen.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by nailya.shakirova on 02.06.2018.
 */

@Data
//@NoArgsConstructor
@AllArgsConstructor
//@Builder
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

    @Column(name = "issue_dt", columnDefinition="DATE", nullable = false)
    private java.util.Date issueDt;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_position_id", nullable = false)
    private EmployeePositionEntity emplPos;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private IndividualEntity patient;

    @Column(name = "sign_id")
//    @Enumerated(value = EnumType.STRING)
//    private ReceiptSignEnum receiptSign;
    private Integer receiptSignId;

    @Column(name = "cito", nullable = false)
    private Boolean cito;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "diagnosis_id")
    private DiagnosisEntity diagnosis;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "validity_id", nullable = false)
    private ReceiptValidityEntity receiptValidity;

    @Column(name = "canceled", nullable = false)
    private Boolean canceled;

    public IndividualEntity getIndividual() {
        return patient;
    }

    public void setPatient(IndividualEntity patient) {
        this.patient = patient;
    }

    public Integer getpatientId() {
        return patient == null ? null : patient.getId();
    }

    public ReceiptEntity(){
    }

    public ReceiptEntity(Integer id){
    }

    public ReceiptEntity(Integer id
            , Integer receiptTypeId
            , String series
            , String num
            , Date issueDate
            , Integer clinic
            , Integer emplPosId
            , Integer patient
            , Integer receiptSignId
            , Boolean cito
            , Integer diagnosisId
            , Integer receiptValidityId
            , Boolean canceled) {
        setId(id);
        setReceiptType(new ReceiptTypeEntity(receiptTypeId));
        setSeries(series);
        setNum(num);
        setIssueDt(issueDate);
        setClinic(new ClinicEntity(clinic));
        setEmplPos(new EmployeePositionEntity(emplPosId));
        setPatient(new IndividualEntity(patient));
        setReceiptSignId();
        setCito();        
        setDiagnosis(new DiagnosisEntity(diagnosisId));
        setReceiptValidity(new ReceiptValidityEntity(receiptValidityId));
    }

    private void setCito() {
    }

    private void setReceiptSignId() {}
}
