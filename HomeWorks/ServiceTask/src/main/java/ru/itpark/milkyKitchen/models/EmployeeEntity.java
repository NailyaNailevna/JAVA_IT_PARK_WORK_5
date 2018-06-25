package ru.itpark.milkyKitchen.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by nailya.shakirova on 05.06.2018.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="pim_employee", schema="public")
@Inheritance(strategy = InheritanceType.JOINED)
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pim_employee_id_gen")
    @SequenceGenerator(name = "pim_employee_id_gen",sequenceName = "public.pim_employee_id_seq",allocationSize = 1)
    @Access(AccessType.PROPERTY)
    private Integer id;

    @Column(name = "number")
    private String number;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "individual_id", nullable = false)
    private IndividualEntity indiv;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private ClinicEntity org;

    @Column(name = "employment_dt")
    @Temporal (TemporalType.DATE)
    private Date employmentDt;

    @Column(name = "is_dismissed")
    private Boolean isDismissed;

    @Column(name = "dismissal_dt")
    @Temporal (TemporalType.DATE)
    private Date dismissalDt;

//    @Column(name = "note")
//    private String note;
}
