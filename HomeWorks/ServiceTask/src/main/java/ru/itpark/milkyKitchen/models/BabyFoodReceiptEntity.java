package ru.itpark.milkyKitchen.models;

import lombok.*;

import javax.persistence.*;

/**
 * Created by nailya.shakirova on 02.06.2018.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="baby_food_receipt", schema="ehr")
@Inheritance(strategy = InheritanceType.JOINED)

//public class BabyFoodReceiptEntity extends ReceiptEntity {
public class BabyFoodReceiptEntity{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private ReceiptEntity receiptId;

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "benefit_definition_id", nullable = false)
    private Integer benefitDefinitionId;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "kitchen_id")
    private DepartmentEntity kitchenId;

    @Column(name = "begin_dt", columnDefinition="DATE", nullable = false)
    private java.util.Date beginDate;

    @Column(name = "end_dt", columnDefinition="DATE", nullable = false)
    private java.util.Date endDate;

    @Column(name = "age_category_id", nullable = false)
    private Integer ageCategoryId;

}
