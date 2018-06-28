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
@Table(name="pim_employee_position", schema="public")
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

    public EmployeePositionEntity(Integer id) {
        this.id = id;
    }
/*
    public String getDoc() {
        return employee.getIndiv().getFio();
    }
*/
/*
    public String getDoc() {
        StringBuilder builder = getFullNameBuilder();
        return builder.toString();
    }

    public StringBuilder getFullNameBuilder() {
        StringBuilder builder = new StringBuilder();
        if (employee.getIndiv().getSurname() != null)
            builder.append(employee.getIndiv().getSurname());
        if (employee.getIndiv().getName() != null) {
            if (employee.getIndiv().getSurname() != null)
                builder.append(" ");
            builder.append(employee.getIndiv().getName());
        }
        if (employee.getIndiv().getPatrName() != null) {
            if (employee.getIndiv().getSurname() != null || employee.getIndiv().getName() != null)
                builder.append(" ");
            builder.append(employee.getIndiv().getPatrName());
        }
        return builder;
    }
*/
}
