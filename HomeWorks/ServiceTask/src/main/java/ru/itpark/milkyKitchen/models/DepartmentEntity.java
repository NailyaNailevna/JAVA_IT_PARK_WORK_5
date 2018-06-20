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
@Table(name="public.pim_department")
@Inheritance(strategy = InheritanceType.JOINED)
public class DepartmentEntity {
//    public static final int DEP_KIND_ID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pim_departament_id_gen")
    @SequenceGenerator(name = "pim_departament_id_gen",sequenceName = "public.dc_departament_seq",allocationSize = 1)
    @Access(AccessType.PROPERTY)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id", nullable = false)
    private ClinicEntity org;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "kind_id", nullable = false)
    private ReceiptTypeEntity kind;

    @Column(name = "from_dt")
    @Temporal (TemporalType.DATE)
    private Date fromDt;

    @Column(name ="to_dt")
    @Temporal(TemporalType.DATE)
    private Date toDt;

    public DepartmentEntity(Integer id) {
        this.id = id;
    }
}
