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
@Table(name="pim_position", schema="public")
public class PositionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pim_position_id_gen")
    @SequenceGenerator(name = "pim_position_id_gen",sequenceName = "public.pim_position_id_seq",allocationSize = 1)
    @Access(AccessType.PROPERTY)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private ClinicEntity org;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private DepartmentEntity dep;

    @Column(name = "start_date")
    @Temporal (TemporalType.DATE)
    private Date fromDt;

    @Column(name ="end_date")
    @Temporal(TemporalType.DATE)
    private Date toDt;
}
