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
@Table(name="md_receipt_type", schema="public")
public class ReceiptTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "receipt_type_id_gen")
    @SequenceGenerator(name = "receipt_type_id_gen",sequenceName = "public.md_receipt_type_seq",allocationSize = 1)
    @Access(AccessType.PROPERTY)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "e_code")
    private String ecode;

    @Column(name = "from_dt")
    @Temporal (TemporalType.DATE)
    private Date fromDt;

    @Column(name ="to_dt")
    @Temporal(TemporalType.DATE)
    private Date toDt;

    @Column(name = "is_regular")
    private boolean isRegular;

    public ReceiptTypeEntity(Integer id) {
        this.id = id;
    }
}
