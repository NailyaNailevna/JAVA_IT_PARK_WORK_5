package ru.itpark.milkyKitchen.models;

import lombok.*;

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
@Getter
@Setter
@Table(name="md_diagnosis", schema="public")
public class DiagnosisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "md_diagnosis_id_gen")
    @SequenceGenerator(name = "md_diagnosis_id_gen",sequenceName = "public.md_diagnosis_seq",allocationSize = 1)
    @Access(AccessType.PROPERTY)
    private Integer id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", nullable = false)
    private DiagnosisEntity parent;

    @Column(name = "level")
    private Integer level;

    @Column(name = "is_leaf")
    private Boolean isLeaf;

    @Column(name = "e_code")
    private String ecode;

    @Column(name = "from_dt")
    @Temporal (TemporalType.DATE)
    private Date fromDt;

    @Column(name ="to_dt")
    @Temporal(TemporalType.DATE)
    private Date toDt;

    public DiagnosisEntity(Integer id) {
        this.id = id;
    }

//    getFullName
}
