package ru.itpark.milkyKitchen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.milkyKitchen.models.ReceiptEntity;

import java.util.List;
import java.util.Optional;

//import org.springframework.stereotype.Repository;

/**
 * Created by nailya.shakirova on 19.06.2018.
 */

//@Repository("ReceiptRepository")
public interface ReceiptRepository extends JpaRepository<ReceiptEntity,Integer>{
    @Query(nativeQuery = true, value = "SELECT r.id FROM ehr.receipt r where r.id = ?1")
    List<ReceiptEntity> findById(Integer id);

    @Query(nativeQuery = true, value = "SELECT * FROM ehr.receipt r where r.id = ?1")
    ReceiptEntity findOneById(Integer id);

    @Query(nativeQuery = true, value = "SELECT * FROM ehr.receipt r where r.id = ?1")
    Optional<ReceiptEntity> findOneByIdO(Integer id);

}
