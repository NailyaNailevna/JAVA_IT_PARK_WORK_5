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
@Table(name="public.pim_employee_position")
@Inheritance(strategy = InheritanceType.JOINED)
public class EmployeePositionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pim_employee_position_id_gen")
    @SequenceGenerator(name = "pim_employee_position_id_gen",sequenceName = "public.pim_employee_to_position_seq",allocationSize = 1)
    @Access(AccessType.PROPERTY)
    private Integer id;

    @Column(name = "code")
    private String code;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeEntity employee;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id", nullable = false)
    private PositionEntity position;

    @Column(name = "start_date")
    @Temporal (TemporalType.DATE)
    private Date fromDt;

    @Column(name ="end_date")
    @Temporal(TemporalType.DATE)
    private Date toDt;
    private String note;

    public EmployeePositionEntity(Integer id) {
        this.id = id;
    }
}
