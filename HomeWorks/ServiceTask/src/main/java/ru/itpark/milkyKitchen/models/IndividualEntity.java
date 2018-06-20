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
@Table(name="public.pim_individual")
public class IndividualEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pim_party_id_gen")
    @SequenceGenerator(name = "pim_party_id_gen",sequenceName = "public.pim_party_id_seq",allocationSize = 1)
    @Access(AccessType.PROPERTY)
    private Integer id;

    @Column(name = "surname", length = 50)
    private String surname;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "patr_name", length = 50)
    private String patrName;

    @Column(name = "birth_dt")
    @Temporal(value = TemporalType.DATE)
    private Date birthDate;

    public IndividualEntity(Integer id) {
        this.id = id;
    }

}
