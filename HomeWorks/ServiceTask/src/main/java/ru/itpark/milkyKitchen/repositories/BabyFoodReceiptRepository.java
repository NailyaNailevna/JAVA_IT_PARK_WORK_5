package ru.itpark.milkyKitchen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.milkyKitchen.models.BabyFoodReceiptEntity;

import java.util.List;
import java.util.Optional;

//import org.springframework.stereotype.Repository;

/**
 * Created by nailya.shakirova on 19.06.2018.
 */

//@Repository("ReceiptRepository")
public interface BabyFoodReceiptRepository extends JpaRepository<BabyFoodReceiptEntity,Integer>{

    @Query(nativeQuery = true, value = "SELECT bfr.id, r.series, r.num, r.patient_id, bfr.kitchen_id, r.employee_position_id,   r.clinic_id, r.cito, r.canceled, r.type_id, r.issue_dt, r.sign_id, r.diagnosis_id, r.validity_id, bfr.age_category_id, bfr.benefit_definition_id, bfr.begin_dt, bfr.end_dt FROM ehr.baby_food_receipt bfr JOIN ehr.receipt r on r.id = bfr.id")
    List<BabyFoodReceiptEntity> findAll();

}
