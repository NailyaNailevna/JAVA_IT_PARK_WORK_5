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
@Getter
@Entity
@Table(name="md_clinic", schema="public")
public class ClinicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pim_party_id_gen")
    @SequenceGenerator(name = "pim_party_id_gen",sequenceName = "public.pim_party_id_seq",allocationSize = 1)
    @Access(AccessType.PROPERTY)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "short_name", nullable = false)
    private String shortName;

    @Column(name = "from_dt")
    @Temporal (TemporalType.DATE)
    private Date fromDt;

    @Column(name ="to_dt")
    @Temporal(TemporalType.DATE)
    private Date toDt;

    public ClinicEntity(Integer id) {
        this.id = id;
    }

}
