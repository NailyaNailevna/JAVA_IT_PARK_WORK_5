package ru.itpark.milkyKitchen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.milkyKitchen.models.IssueProductEntity;

import java.util.List;

//import org.springframework.stereotype.Repository;

/**
 * Created by nailya.shakirova on 19.06.2018.
 */

//@Repository("ReceiptRepository")
public interface IssueProductRepository extends JpaRepository<IssueProductEntity,Long>{
    IssueProductEntity findById(int id);

    @Query(nativeQuery = true, value = "SELECT ip.id,  ip.receipt_id, ip.distribute_dt, ip.distribute_info, ip.user_id FROM milky.issue_product ip where ip.receipt_id = ?1" )
    List<IssueProductEntity> findAllByReceiptId(int receiptId);

}
