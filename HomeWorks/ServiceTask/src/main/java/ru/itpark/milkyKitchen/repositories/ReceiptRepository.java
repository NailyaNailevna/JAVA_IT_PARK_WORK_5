package ru.itpark.milkyKitchen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
import ru.itpark.milkyKitchen.models.BabyFoodReceiptEntity;

import java.util.List;

/**
 * Created by nailya.shakirova on 19.06.2018.
 */

//@Repository("ReceiptRepository")
public interface ReceiptRepository extends JpaRepository<BabyFoodReceiptEntity,Long>{
    BabyFoodReceiptEntity findById (int id);

//    @Query(nativeQuery = true, value = "SELECT * FROM receipt.baby_food_receipt bfr JOIN receipt.receipt r where r.clinic_id = ?1")
    @Query(nativeQuery = true, value = "SELECT * FROM ehr.baby_food_receipt bfr JOIN ehr.receipt r on r.id = bfr.id where r.clinic_id = 490")
    List<BabyFoodReceiptEntity> findAll();

}
