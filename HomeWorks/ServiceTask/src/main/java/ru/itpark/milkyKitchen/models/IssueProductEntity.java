package ru.itpark.milkyKitchen.models;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by nailya.shakirova on 05.06.2018.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder()
@Getter
@Setter
@Entity
//@TypeDefs({@TypeDef(name = "JsonObject", typeClass = CacheObject.class)})
//@TypeDefs({
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
//})
@Table(name="issue_product", schema="milky")
public class IssueProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "issue_product_id_gen")
    @SequenceGenerator(name = "issue_product_id_gen",sequenceName = "milky.issue_product_seq",allocationSize = 1)
    @Access(AccessType.PROPERTY)
    private Integer id;

    @Column(name = "receipt_id")
    private Integer receiptId;

    @Column(name = "distribute_dt")
    @Temporal (TemporalType.DATE)
    private Date distributeDt;

    @Type(type = "jsonb")
    @Column(name = "distribute_info", columnDefinition = "jsonb")
//    @Type(type = "JsonObject")
//    private JsonMapType distributeInfo;
//    private DistributeInfo distributeInfo;
//    @Column(name = "distribute_info")
    private JsonBinaryType distributeInfo;

    @Column(name ="user_id")
    private Integer userId;

    public IssueProductEntity(Integer id) {
        this.id = id;
    }
/*
    @Type(type = "jsonb",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = TypeReferenceFactory.FACTORY_CLASS,
                            value = "com.vladmihalcea.hibernate.type.json.PostgreSQLGenericJsonBinaryTypeTest$AlternativeLocationsTypeReference"
                    )
            }
*/
}
