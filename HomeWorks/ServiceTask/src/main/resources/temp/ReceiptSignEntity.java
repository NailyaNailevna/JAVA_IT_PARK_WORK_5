package temp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by nailya.shakirova on 05.06.2018.
 */

@Entity
@Table(name="receipt.receipt_sign")
public class ReceiptSignEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "receipt_sign_id_gen")
    @SequenceGenerator(name = "receipt_sign_id_gen",sequenceName = "receipt.receipt_sign_id_seq",allocationSize = 1)
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
    private Date fromdt;

    @Column(name ="to_dt")
    @Temporal(TemporalType.DATE)
    private Date todt;

    @Column(name = "is_adult")
    private boolean isAdult;

    @Column(name = "is_child")
    private boolean isChild;
}
