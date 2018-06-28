package ru.itpark.milkyKitchen.repositories;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;
import ru.itpark.milkyKitchen.models.IssueProductEntity;

import javax.persistence.QueryHint;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

//import org.springframework.stereotype.Repository;

/**
 * Created by nailya.shakirova on 19.06.2018.
 */

@Repository("IssueProductRepository")
public interface IssueProductRepository extends JpaRepository<IssueProductEntity,Integer>, JpaSpecificationExecutor<IssueProductEntity> {
/*
public interface IssueProductRepository extends JpaRepository<IssueProductEntity,Integer>, JpaSpecificationExecutor<IssueProductEntity> {

    public class ProductSpecification implements Specification<IssueProductEntity> {
        private String id;
        private String vol;

        public ProductSpecification(String locale, String titleToSearch) {
            this.id = id;
            this.vol = vol;
        }

        @Override
        public Predicate toPredicate(Root<IssueProductEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
            return (Predicate) builder.equal(builder.function("jsonb_extract_path_text", String.class, root.<String>get("title"), builder.literal(this.id)), this.id);
        }

    }

    @QueryHints(value ={
            @QueryHint(name = org.eclipse.per)
    })
*/


//    @Query(nativeQuery = true, value = "SELECT ip.id,  ip.receipt_id, ip.distribute_dt, ip.distribute_info, ip.user_id FROM milky.issue_product ip JOIN ehr.baby_food_product prod on prod.id where ip.receipt_id = ?1" )
    @Query(nativeQuery = true, value = "SELECT * FROM milky.issue_product ip where ip.receipt_id = 1" )
    List<IssueProductEntity> getAllIssues();
//    int receiptId

}
